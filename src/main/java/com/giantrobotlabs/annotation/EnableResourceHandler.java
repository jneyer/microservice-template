package com.giantrobotlabs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.giantrobotlabs.util.ResourceExceptionHandler;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ResourceExceptionHandler.class)
public @interface EnableResourceHandler {

}
