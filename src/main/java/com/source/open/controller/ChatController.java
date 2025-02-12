package com.source.open.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.source.open.entity.Message;
import com.source.open.exception.ResourceNotFoundException;
import com.source.open.payload.MessageRequest;
import com.source.open.service.MessageService;
import com.source.open.service.RoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ChatController {

	private final RoomService roomService;

	private final MessageService messageService;

	@GetMapping("/api/v1/home")
	public String home() {
		return "<h1>Welcome to Chat Man API Home. Cheers...🚀</h1>";
	}

	@MessageMapping("/sendMessage/{roomId}")
	@SendTo("/topic/room/{roomId}")
	public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest msg) {

		if (!roomService.existsByRoomId(roomId))
			throw new ResourceNotFoundException("Room", "roomId", roomId);
		
		return messageService.createMessage(msg);
	}

}
