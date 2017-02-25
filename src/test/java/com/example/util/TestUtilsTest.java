package com.example.util;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class TestUtilsTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testAsJsonString() throws Exception {
		String result = TestUtils.asJsonString("test string");
		assertThat(result, notNullValue());
		assertThat(result, containsString("test string"));
	}

	@Test
	public void testAsJsonStringException() throws Exception {

		class TestModel {
			TestModel(int someval) {
				// Do something
			}
		}

		TestModel model = new TestModel(1);
		thrown.expect(RuntimeException.class);
		TestUtils.asJsonString(model);

	}

	@Test
	public void testSomething() throws Exception {

		TestUtils utils = new TestUtils();
		utils.toString();
	}

}
