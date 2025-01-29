package com.source.open.payload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageRequest {

	private String sender;
	private String content;
	private String roomId;
	private LocalDateTime messageTime;
	
//	public MessageRequest(String sender, String content) {
//		super();
//		this.sender = sender;
//		this.content = content;
//		this.messageTime = LocalDateTime.now();
//	}
	
	
}
