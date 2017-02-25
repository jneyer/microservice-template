package com.example.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * ResourceExceptionHandler is the controller advice entity that intercepts
 * ResourceExceptions and prepares the ErrorResponse.
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceException.class)
	@ResponseBody
	ResponseEntity<ErrorResponse> handleException(ResourceException re) {

		ErrorResponse response = new ErrorResponse(re.getError(), re.getHttpStatus(), re.getMessage());
		return ResponseEntity.status(re.getHttpStatus()).body(response);
	}
}
