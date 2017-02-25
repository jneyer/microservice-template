package com.example.util;

import org.springframework.http.HttpStatus;

/**
 * ResourceException A RuntimeException is thrown from the service layer.
 * Exceptions are managed by the ResourceExceptionHandler and should bubble up
 * as the client response.
 *
 */
public class ResourceException extends RuntimeException {

	private static final long serialVersionUID = 1307663515084916267L;
	private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	private String message;
	private String error;

	/**
	 * General runtime exceptions to be thrown by resources.
	 * 
	 * @param error
	 *            A short title for the error.
	 * @param message
	 *            The message detail provided for the error.
	 * 
	 */
	public ResourceException(String error, HttpStatus httpStatus, String message) {
		super(message);
		this.error = error;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getError() {
		return error;
	}

	@Override
	public String toString() {
		return "ResourceException [httpStatus=" + this.getHttpStatus() + ", message=" + this.getMessage() + ", error="
				+ this.getError() + "]";
	}
}