/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fwd.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fwd.domain.Customer;
import com.fwd.domain.Partner;
import com.fwd.service.RecaptchaService;
import java.util.HashMap;
import java.util.Map;
//import com.fwd.util.GlobalValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.fwd.util.CustomLogger;
import com.fwd.util.RC;
import com.fwd.util.RF;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author RIZAD
 */
@Controller
@RequestMapping({"/home"})
public class HomePageController {

    private static final Logger eventLogger = LoggerFactory.getLogger(CustomLogger.EVENT);
    private static final Logger errorLogger = LoggerFactory.getLogger(CustomLogger.ERROR);

    @Autowired
    private Environment environment;

    @Autowired
    private RecaptchaService recaptchaService;

    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/home";
    }

    @RequestMapping(value = "/home-slider", method = {RequestMethod.GET})
    public ResponseEntity<?> getHomeSlider() {

        // String urlAPI = GlobalValue.URL_BACKEND+"home/home-slider";
        String urlAPI = environment.getProperty("fwd.url.backend") + "home/home-slider";
        ResponseEntity<?> entity = getRequestRestClient(urlAPI);
        return entity;
    }

    @RequestMapping(value = "/list-menus/{menuType}", method = {RequestMethod.GET})
    public ResponseEntity<?> getListMenus(@PathVariable String menuType) {

        String urlAPI = environment.getProperty("fwd.url.backend") + "home/list-menus/" + menuType;
        ResponseEntity<?> entity = getRequestRestClient(urlAPI);
        return entity;
    }

    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer, @RequestParam(value = "g-recaptcha-response") String recaptchaResponse, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String captchaVerifyMessage = "";
        try {
            captchaVerifyMessage = recaptchaService.verifyRecaptcha(ip, recaptchaResponse);
        } catch (Exception ex) {
            errorLogger.error(ex.getMessage(), ex);
        }
        if (StringUtils.isNotEmpty(captchaVerifyMessage)) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", captchaVerifyMessage);
            return ResponseEntity.badRequest().body(response);
        }

        String url = environment.getProperty("fwd.url.backend") + "home/add-customer";
        MultiValueMap<String, String> headersPost = new LinkedMultiValueMap<String, String>();
        headersPost.add("Content-Type", "application/json");
        Map<String, Object> map = mapper.convertValue(customer, Map.class);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headersPost);
        ResponseEntity<?> entity = getPostRestClient(httpEntity, url);
        return entity;
    }

    @RequestMapping(value = "/add-partner", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addPartner(@RequestBody Partner partner, @RequestParam(value = "g-recaptcha-response") String recaptchaResponse, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String captchaVerifyMessage = recaptchaService.verifyRecaptcha(ip, recaptchaResponse);
        if (StringUtils.isNotEmpty(captchaVerifyMessage)) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", captchaVerifyMessage);
            return ResponseEntity.badRequest().body(response);
        }

        String url = environment.getProperty("fwd.url.backend") + "home/add-partner";
        MultiValueMap<String, String> headersPost = new LinkedMultiValueMap<String, String>();
        headersPost.add("Content-Type", "application/json");
        Map<String, Object> map = mapper.convertValue(partner, Map.class);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map, headersPost);
        ResponseEntity<?> entity = getPostRestClient(httpEntity, url);
        return entity;
    }

    private ResponseEntity<?> getRequestRestClient(String urlAPI) {

        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        Map<String, Object> resp = new HashMap<String, Object>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            //ObjectMapper mapper = new ObjectMapper();
            ResponseEntity<String> response = restTemplate.getForEntity(urlAPI, String.class);
            resp = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
            errorLogger.error(ex.getMessage(), ex);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);

        return entity;
    }

    public ResponseEntity<?> getPostRestClient(HttpEntity<Map<String, Object>> request, String url) {
        ResponseEntity<?> result = null;
        Map<String, Object> resp = new HashMap();
        RestTemplate restTemplate = new RestTemplate();
        try {
            String response = restTemplate.postForObject(url, request, String.class);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        result = new ResponseEntity(resp, headers, HttpStatus.OK);
        return result;
    }

    @RequestMapping(value = "/list-partner", method = {RequestMethod.GET})
    public ResponseEntity<?> getListPartner() {
        String urlAPI = environment.getProperty("fwd.url.backend") + "home/list-partner";
        ResponseEntity<?> entity = getRequestRestClient(urlAPI);
        return entity;
    }
}
