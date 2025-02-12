package com.source.open.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.source.open.entity.Room;
import com.source.open.payload.PagePayload;

public interface RoomService {

	Long roomCount();

	boolean existsByRoomId(String roomId);

	Room getByRoomId(String roomId);

	PagePayload<Room> getRoomPage(Pageable pageable);

	List<Room> getAll();

	Room createRoom(String roomId);

	void deleteRoom(String roomId);

	void deleteAll();
}
