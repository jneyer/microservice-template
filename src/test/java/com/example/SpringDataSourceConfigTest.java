package com.example;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.example.SpringDataSourceConfig;

public class SpringDataSourceConfigTest {

	SpringDataSourceConfig config;

	@Before
	public void setUp() throws Exception {
		config = new SpringDataSourceConfig();
	}

	@Test
	public void testDataSource() throws Exception {

		DataSource dataSource = config.dataSource();

		assertThat(dataSource, notNullValue());
	}

	@Test
	public void testEntityManagerFactory() throws Exception {

		LocalContainerEntityManagerFactoryBean factory = config.entityManagerFactory();

		assertThat(factory, notNullValue());

	}

}
