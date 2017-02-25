package com.example.util;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.example.util.CollectionRequest;

public class CollectionRequestTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCollectionRequestWithLimits() throws Exception {

		CollectionRequest request = new CollectionRequest(1, 10);

		assertThat(request.toString(), notNullValue());

	}

	@Test
	public void testCollectionRequestDefaults() throws Exception {

		CollectionRequest request = new CollectionRequest();

		assertThat(request.toString(), notNullValue());

	}

}
