package com.giantrobotlabs.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModelTemplateTest {

	class TestModel extends ModelTemplate {

		TestModel(Long id) {
			this.modelId = id;
		}

	}

	@Test
	public void testModel() throws Exception {

		ModelTemplate model = new TestModel(999L);

		model.onCreate();
		model.onUpdate();

		assertThat(model.getCreated(), notNullValue());
		assertThat(model.getUpdated(), notNullValue());
		assertThat(model.getModelId(), equalTo(999L));

	}

	@Test
	public void testAddLinks() throws Exception {

		ModelTemplate model = new TestModel(999L);
		model.addLinks(null);

		// This test doesn't do anything yet
	}

}
