package com.fwd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySource(value = "file:application.properties", ignoreResourceNotFound = true)
@SpringBootApplication
@EnableJpaRepositories
public class FWDPortalWebApplication extends SpringBootServletInitializer  {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FWDPortalWebApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(FWDPortalWebApplication.class, args);
    }
}
