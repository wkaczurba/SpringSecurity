package com.some.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Import(DataConfig.class)
@Configuration
// scanning of everything, except for com.some.web,
// as that one is scanned by com.some.web.WebConfig, called from SomeWebInitializer 
@ComponentScan(basePackages = "com.some", 
  excludeFilters = @Filter(type=FilterType.REGEX, pattern="com\\.some\\.web\\..*"))
public class RootConfig {
	// Anything app-related.
}
