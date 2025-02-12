package com.source.open.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class ResourceNotFoundException extends RuntimeException {

    /**
     * @author Naresh Kumar
     */
    @Serial
    private static final long serialVersionUID = 1L;
	
	private final String message;

	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
		this("%s not found with %s: %d".formatted(resourceName, fieldName, fieldValue));
	}

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		this("%s not found with %s: %s".formatted(resourceName, fieldName, fieldValue));
	}

}
