package com.example.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class CollectionResponseTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCollectionResponseWithPage() throws Exception {

		Page<String> page = new PageImpl<String>(new ArrayList<String>());
		CollectionResponse<String> response = new CollectionResponse<String>(page);

		assertThat(response.toString(), notNullValue());
		assertThat(response.getSize(), equalTo(0));
	}

	@Test
	public void testCollectionResponseWithCollection() throws Exception {

		Collection<String> collection = Arrays.asList(new String(), new String(), new String());
		CollectionResponse<String> response = new CollectionResponse<String>(collection);

		assertThat(response.toString(), notNullValue());
		assertThat(response.getPage(), equalTo(0));
		assertThat(response.getSize(), equalTo(3));
	}

	@Test
	public void testCollectionResponseWithCollectionNull() throws Exception {

		Collection<String> collection = null;
		CollectionResponse<String> response = new CollectionResponse<String>(collection);

		assertThat(response.toString(), notNullValue());
		assertThat(response.getPage(), equalTo(0));
		assertThat(response.getSize(), equalTo(0));
	}

}
