package com.source.open.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.source.open.entity.Room;

public interface RoomRepo extends MongoRepository<Room, String> {

	Room findByRoomId(String roomId);
}
