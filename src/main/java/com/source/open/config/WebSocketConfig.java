package com.source.open.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(@NonNull StompEndpointRegistry registry) {
		// This is the HTTP URL for the endpoint to which a WebSocket (or SockJS)
		// client needs to connect for the WebSocket handshake
//		@formatter:off
		registry
		.addEndpoint("/chat")
		.setAllowedOrigins("http://localhost:5173")
//		.setAllowedOrigins("*")  // Uncomment this to allow all origins instead for development
		.withSockJS();
//		@formatter:on
		
	}

	@Override
	public void configureMessageBroker(@NonNull MessageBrokerRegistry registry) {
		// Use the built-in message broker for subscriptions and broadcasting and
		// route messages whose destination header begins with /topic to the broker
		registry.enableSimpleBroker("/topic");
		// STOMP messages whose destination header begins with /app are routed to
		// @MessageMapping methods in @Controller classes
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	@Override
	public void configureWebSocketTransport(@NonNull WebSocketTransportRegistration registry) {
		registry.setMessageSizeLimit(4 * 8192);
		registry.setTimeToFirstMessage(30000);
	}

}
