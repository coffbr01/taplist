package com.bcoffield.taplist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.bcoffield.taplist.service", "com.bcoffield.taplist.controller"})
public class AppConfig {
}
