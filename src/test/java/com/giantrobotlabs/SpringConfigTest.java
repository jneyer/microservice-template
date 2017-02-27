package com.giantrobotlabs;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.giantrobotlabs.SpringConfig;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

@RunWith(MockitoJUnitRunner.class)
public class SpringConfigTest {

	@Mock
	private Environment env;

	@InjectMocks
	private SpringConfig springConfig;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testMappingJackson2HttpMessageConverter() throws Exception {

		MappingJackson2HttpMessageConverter converter = springConfig.mappingJackson2HttpMessageConverter();

		assertThat(converter, notNullValue());
	}

	@Test
	public void testApi() throws Exception {

		Docket docket = springConfig.api();

		assertThat(docket, notNullValue());
	}

	@Test
	public void testGetApiInfo() throws Exception {

		ApiInfo info = springConfig.getApiInfo();

		assertThat(info, notNullValue());
	}

}
