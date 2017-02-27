package com.giantrobotlabs.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.giantrobotlabs.util.ErrorResponse;
import com.giantrobotlabs.util.ResourceException;
import com.giantrobotlabs.util.ResourceExceptionHandler;

public class ResourceExceptionHandlerTest {

	private ResourceExceptionHandler resourceExceptionHandler;

	@Before
	public void setUp() throws Exception {
		resourceExceptionHandler = new ResourceExceptionHandler();
	}

	@Test
	public void testHandleException() throws Exception {

		ResourceException exception = new ResourceException("message", HttpStatus.OK, "description statement");
		ResponseEntity<ErrorResponse> entity = resourceExceptionHandler.handleException(exception);

		assertThat(entity, notNullValue());
		assertThat(entity.getStatusCode(), equalTo(exception.getHttpStatus()));
		assertThat(entity.getBody().getError(), equalTo(exception.getError()));
		assertThat(entity.getBody().getMessage(), equalTo(exception.getMessage()));

	}

}
