package com.example.util;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.example.util.ErrorResponse;

public class ErrorResponseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() throws Exception {

		assertThat(new ErrorResponse(null, null, null).toString(), notNullValue());

	}

}
