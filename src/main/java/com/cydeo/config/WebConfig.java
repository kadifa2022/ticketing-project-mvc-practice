package com.cydeo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {//defining all end point inside configuration class
        registry.addViewController("/welcome").setViewName("welcome");//is only for static//no data
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("login");
    }

}
