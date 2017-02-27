package com.giantrobotlabs.util;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.giantrobotlabs.util.ResourceException;

public class ResourceExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() throws Exception {

		assertThat(new ResourceException("reason", HttpStatus.OK, "description statement").toString(), notNullValue());
	}

}
