package com.fwd.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GlobalValue {

    public static String PATH_IMAGE;
    public static String TALENTS_PROTOCOL;

    @Value("${fwd.path.image}")
    public void setDatabase(String path) {
    	PATH_IMAGE = path;
    }
}
