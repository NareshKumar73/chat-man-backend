package com.source.open.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class NotUniqueException extends RuntimeException {

    /**
     * @author Naresh Kumar
     */
    @Serial
    private static final long serialVersionUID = 1L;

	private final String message;

	public NotUniqueException(String message) {
		super(message);
		this.message = message;
	}
	
	public NotUniqueException(String resourceName, String fieldName, String fieldValue) {
		this("%s already exist with %s: %s".formatted(resourceName, fieldName, fieldValue));
	}

}
