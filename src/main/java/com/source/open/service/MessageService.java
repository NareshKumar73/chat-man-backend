package com.source.open.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.source.open.entity.Message;
import com.source.open.payload.MessageRequest;
import com.source.open.payload.PagePayload;

public interface MessageService {

	Long messageCount();
	
	Long messageCountByRoomId(String roomId);

	PagePayload<Message> getPage(String roomId, Pageable pageable);

	List<Message> getByRoomId(String roomId);

	List<Message> getAll();

	Message createMessage(MessageRequest req);

	void deleteMessageByRoomId(String roomId);

	void deleteAll();
}
