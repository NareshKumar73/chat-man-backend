package com.source.open.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

	private final String message;

	public BadRequestException(String message) {
		super(message);
		this.message = message;
	}

}
