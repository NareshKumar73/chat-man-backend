package com.source.open.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.source.open.entity.Room;
import com.source.open.exception.NotUniqueException;
import com.source.open.exception.ResourceNotFoundException;
import com.source.open.payload.PagePayload;
import com.source.open.repo.RoomRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RoomService0 implements RoomService {

	private final RoomRepo roomRepo;

	@Override
	public Long roomCount() {
		return roomRepo.count();
	}

	@Override
	public boolean existsByRoomId(String roomId) {
		return roomRepo.existsByRoomId(roomId);
	}

	@Override
	public Room getByRoomId(String roomId) {
		return roomRepo.findByRoomId(roomId).orElseThrow(() -> new ResourceNotFoundException("Room", "roomId", roomId));
	}

	@Override
	public List<Room> getAll() {
		return roomRepo.findAll();
	}

	@Override
	public PagePayload<Room> getRoomPage(Pageable pageable) {
		return PagePayload.of(roomRepo.findAll(pageable));
	}

	@Override
	public Room createRoom(String roomId) {

		if (roomRepo.existsByRoomId(roomId)) {
			throw new NotUniqueException("Room", "roomId", roomId);
		}

		Room room = new Room();

		room.setRoomId(roomId);

		return roomRepo.save(room);
	}

	@Override
	public void deleteRoom(String roomId) {
		if (!roomRepo.existsByRoomId(roomId))
			throw new ResourceNotFoundException("Room", "roomId", roomId);

		roomRepo.deleteByRoomId(roomId);

		log.debug("Deleted room: %s".formatted(roomId));
	}

	@Override
	public void deleteAll() {
		roomRepo.deleteAll();
	}

}
