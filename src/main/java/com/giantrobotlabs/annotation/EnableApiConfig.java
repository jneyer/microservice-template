package com.giantrobotlabs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.giantrobotlabs.config.DefaultSpringConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableResourceHandler
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(DefaultSpringConfig.class)
public @interface EnableApiConfig {

}
