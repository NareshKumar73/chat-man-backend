package com.source.open.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.source.open.entity.Message;
import com.source.open.entity.Room;
import com.source.open.payload.RoomRequest;
import com.source.open.service.MessageService;
import com.source.open.service.RoomService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

	private final RoomService roomService;
	
	private final MessageService messageService;

	@PostMapping
	public ResponseEntity<Room> createRoom(@RequestBody RoomRequest req) {

		Room saved = roomService.createRoom(req.getRoomId());

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping("/{roomId}")
	public ResponseEntity<Room> joinRoom(@PathVariable String roomId) {

		Room room = roomService.getByRoomId(roomId);

		return ResponseEntity.ok(room);
	}

	@GetMapping
	public ResponseEntity<List<Room>> getRooms() {

		List<Room> rooms = roomService.getAll();

		return ResponseEntity.ok(rooms);
	}

	@GetMapping("/{roomId}/messages")
	public ResponseEntity<List<Message>> getMessages(@PathVariable String roomId) {

		List<Message> messages = messageService.getByRoomId(roomId);

		return ResponseEntity.ok(messages);
	}

}
