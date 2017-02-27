package com.giantrobotlabs;

import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringConfig {

	@Autowired
	private Environment env;

	//
	// JSON Presentation Configuration
	//

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat(
				Optional.ofNullable(env.getProperty("api.date.format")).orElse("yyyy-MM-dd'T'hh:mm:ssz")));
		mapper.registerModule(new JodaModule());
		mapper.setSerializationInclusion(Include.NON_NULL);
		return new MappingJackson2HttpMessageConverter(mapper);
	}

	//
	// Swagger Configuration
	//

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/").apiInfo(getApiInfo()).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
	}

	ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title(env.getProperty("api.title")).description(env.getProperty("api.description"))
				.version(env.getProperty("api.version")).build();
	}
}
