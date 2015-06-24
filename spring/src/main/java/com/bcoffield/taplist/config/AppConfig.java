package com.bcoffield.taplist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.bcoffield.taplist.bean", "com.bcoffield.taplist.controller"})
public class AppConfig {
}
