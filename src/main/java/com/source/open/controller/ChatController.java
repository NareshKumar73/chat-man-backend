package com.source.open.controller;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.source.open.entity.Message;
import com.source.open.entity.Room;
import com.source.open.payload.MessageRequest;
import com.source.open.repo.RoomRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
//@RequestMapping("/api/v1/chats")
@CrossOrigin("*")
public class ChatController {

	private final RoomRepo roomRepo;
	
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome to Chat Man API Home. Cheers...🚀</h1>";
	}
	
	@MessageMapping("/sendMessage/{roomId}")
	@SendTo("/topic/room/{roomId}")
	public Message sendMessage(@DestinationVariable String roomId, @RequestBody MessageRequest request) {
		
		Room room = roomRepo.findByRoomId(roomId);

		Message m = new Message();
		m.setSender(request.getSender());
		m.setContent(request.getContent());
		m.setTimestamp(LocalDateTime.now());
		
		if (room != null) {
			room.getMessages().add(m);
			roomRepo.save(room);
		} else
			throw new RuntimeException("Room not found!!");
		
		return m;
	}

}
