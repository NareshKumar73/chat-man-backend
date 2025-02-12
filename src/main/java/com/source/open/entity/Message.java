package com.source.open.entity;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "messages")
public class Message {

	@Id
	private String id;
	private String roomId;
	private String from;
	private String content;
	private Instant at;
	
	public Message(String roomId) {
		super();
		this.roomId = roomId;
	}
	
	public Message(String roomId, String from, String content) {
		super();
		this.roomId = roomId;
		this.from = from;
		this.content = content;
		this.at = Instant.now();
	}
	
}
