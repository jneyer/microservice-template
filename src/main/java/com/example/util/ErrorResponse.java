package com.example.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ErrorResponse This is the error response that is returned by the
 * ResourceExceptionHandler.
 * 
 */
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 2810233588500478523L;

	@JsonIgnore
	private final HttpStatus status;

	private final String error;

	private final String message;

	public ErrorResponse(String error, HttpStatus status, String message) {
		this.error = error;
		this.status = status;
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + this.getStatus() + ", error=" + this.getError() + ", message="
				+ this.getMessage() + "]";
	}
}
