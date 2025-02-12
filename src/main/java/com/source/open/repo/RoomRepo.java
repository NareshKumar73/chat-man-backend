package com.source.open.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.source.open.entity.Room;

public interface RoomRepo extends MongoRepository<Room, String> {

	boolean existsByRoomId(String roomId);

	Optional<Room> findByRoomId(String roomId);

	void deleteByRoomId(String roomId);

}

//Old version to fetch roomId only 
//@Query(value = "{}", fields = "{ 'messages' : 0 }")
//List<Room> findAllWithoutMessages();

