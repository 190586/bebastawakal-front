/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fwd.service;

import com.fwd.util.CustomLogger;
import com.fwd.util.RecaptchaUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author RIZAD
 */
@Service
public class RecaptchaService {

    private static final Logger eventLogger = LoggerFactory.getLogger(CustomLogger.EVENT);
    private static final Logger errorLogger = LoggerFactory.getLogger(CustomLogger.ERROR);

    private static final String GOOGLE_RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    @Autowired
    private Environment environment;

    RestTemplate restTemplateBuilder  = new RestTemplate();

    public String verifyRecaptcha(String ip, String recaptchaResponse) {
        String recaptchaSecret = environment.getProperty("google.recaptcha.secret");
        Map<String, String> body = new HashMap<>();
        body.put("secret", recaptchaSecret);
        body.put("response", recaptchaResponse);
        body.put("remoteip", ip);
        eventLogger.debug("Request body for recaptcha: {}", body);
        ResponseEntity<Map> recaptchaResponseEntity = restTemplateBuilder.postForEntity(GOOGLE_RECAPTCHA_VERIFY_URL+ "?secret={secret}&response={response}&remoteip={remoteip}", body, Map.class, body);

        eventLogger.debug("Response from recaptcha: {}", recaptchaResponseEntity);
        Map<String, Object> responseBody = recaptchaResponseEntity.getBody();

        boolean recaptchaSucess = (Boolean) responseBody.get("success");
        if (!recaptchaSucess) {
            List<String> errorCodes = (List) responseBody.get("error-codes");

            String errorMessage = errorCodes.stream().map(s -> RecaptchaUtil.RECAPTCHA_ERROR_CODE.get(s)).collect(Collectors.joining(", "));

            return errorMessage;
        } else {
            return StringUtils.EMPTY;
        }
    }
}
