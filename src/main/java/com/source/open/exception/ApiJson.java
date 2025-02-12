package com.source.open.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiJson {

	private String message;
	private boolean success;

	public ApiJson(String message) {
		this.message = message;
	}
		
}
