package com.niit.Collaboration_Back.config;

import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@WebAppConfiguration
@ComponentScan(basePackages = "com.niit.Collaboration_Back")
public class AppConfig {

}

