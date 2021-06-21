package com.example.backendforfrontend.config;

import com.example.backendforfrontend.app.web.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan("com.example.backendforfrontend.app.web")
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private final ServiceProperties properties;

    public MvcConfig(@Autowired ServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    public RestOperations restOperations(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.rootUri(properties.getDns()).build();
    }
}