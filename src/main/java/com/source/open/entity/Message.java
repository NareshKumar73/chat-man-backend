package com.source.open.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {

	private String sender;
	private String content;
	private LocalDateTime timestamp;
	
	public Message(String sender, String content) {
		super();
		this.sender = sender;
		this.content = content;
		this.timestamp = LocalDateTime.now();
	}
	
	
}
