package com.fwd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "file:application.properties", ignoreResourceNotFound = true)
@SpringBootApplication
public class FWDPortalWebApplication extends SpringBootServletInitializer  {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FWDPortalWebApplication.class);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(FWDPortalWebApplication.class, args);
    }
}
