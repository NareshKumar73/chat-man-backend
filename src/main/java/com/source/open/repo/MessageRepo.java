package com.source.open.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.source.open.entity.Message;

public interface MessageRepo extends MongoRepository<Message, String> {
	
	long countByRoomId(String roomId);

	boolean existsByRoomId(String roomId);

	Page<Message> findByRoomId(String roomId, Pageable pageable);

	List<Message> findByRoomId(String roomId);

	void deleteByRoomId(String roomId);

}
