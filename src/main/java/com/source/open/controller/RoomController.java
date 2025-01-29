package com.source.open.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.source.open.entity.Room;
import com.source.open.repo.RoomRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("*")
public class RoomController {

	private final RoomRepo roomRepo;

	@PostMapping
	public ResponseEntity<?> createRoom(@RequestBody String roomId) {

		if (roomRepo.findByRoomId(roomId) != null) {
			return ResponseEntity.badRequest().body("Room already exists!");
		}

		Room room = new Room();

		room.setRoomId(roomId);

		Room saved = roomRepo.save(room);

		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping("/{roomId}")
	public ResponseEntity<?> joinRoom(@PathVariable String roomId) {

		Room room = roomRepo.findByRoomId(roomId);

		if (room == null) {
			return ResponseEntity.badRequest().body("Room not found!!");
		}

		return ResponseEntity.ok(room);
	}

	@GetMapping("/{roomId}/messages")
	public ResponseEntity<?> getMessages(@PathVariable String roomId) {

		Room room = roomRepo.findByRoomId(roomId);

		if (room == null) {
			return ResponseEntity.badRequest().body("Room not found!!");
		}

		return ResponseEntity.ok(room.getMessages());
	}
	
//	@GetMapping("/{roomId}/messages")
//	public ResponseEntity<?> getMessages(@PathVariable String roomId,
//			@RequestParam(defaultValue = "0", required = false) int page,
//			@RequestParam(defaultValue = "20", required = false) int size,
//			@RequestParam(defaultValue = "id", required = false) String sort,
//			@RequestParam(defaultValue = "false", required = false) boolean reverse) {
//
//		Room room = roomRepo.findByRoomId(roomId);
//
//		if (room == null) {
//			return ResponseEntity.badRequest().body("Room not found!!");
//		}
//
//		List<Message> messages = room.getMessages();
//
////		Comparator<Message> comparator = Comparator.comparing(Message::getTimestamp);
////
////		if (reverse)
////			comparator = comparator.reversed();
////
////		messages.sort(comparator);
//
//		// Paginate messages
//		int start = Math.min(page * size, messages.size());
//		int end = Math.min(start + size, messages.size());
//		
//		List<Message> paginatedMessages = messages.subList(start, end);
//
//		Page<Message> paged = new PageImpl<>(paginatedMessages, PageRequest.of(page, size), messages.size());
//
//		return ResponseEntity.ok(paged);
//	}


}
