package com.source.open.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.source.open.entity.Message;
import com.source.open.exception.ResourceNotFoundException;
import com.source.open.payload.MessageRequest;
import com.source.open.payload.PagePayload;
import com.source.open.repo.MessageRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MessageService0 implements MessageService {

	private final MessageRepo messageRepo;

	@Override
	public Long messageCount() {
		return messageRepo.count();
	}

	@Override
	public Long messageCountByRoomId(String roomId) {
		return messageRepo.countByRoomId(roomId);
	}

	@Override
	public PagePayload<Message> getPage(String roomId, Pageable pageable) {
		return PagePayload.of(messageRepo.findByRoomId(roomId, pageable));
	}

	@Override
	public List<Message> getByRoomId(String roomId) {
		return messageRepo.findByRoomId(roomId);
	}

	@Override
	public List<Message> getAll() {
		return messageRepo.findAll();
	}

	@Override
	public Message createMessage(MessageRequest msg) {

		Message m = new Message(msg.getRoomId(), msg.getFrom(), msg.getContent());

		return messageRepo.save(m);
	}

	@Override
	public void deleteMessageByRoomId(String roomId) {

		if (!messageRepo.existsByRoomId(roomId)) {
			throw new ResourceNotFoundException("Message", "roomId", roomId);
		}

		messageRepo.deleteByRoomId(roomId);
	}

	@Override
	public void deleteAll() {
		messageRepo.deleteAll();
	}

}
