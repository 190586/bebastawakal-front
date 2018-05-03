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
import com.fwd.repository.CustomerRepository;
import com.fwd.repository.PartnerRepository;
import com.fwd.repository.TestimonialRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fwd.util.GlobalValue;
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

import com.fwd.service.HomePageService;
import com.fwd.util.CustomLogger;
import com.fwd.util.RC;
import com.fwd.util.RF;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
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
    private HomePageService homePageService;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PartnerRepository partnerRepository;

    
    ObjectMapper mapper = new ObjectMapper();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public String index() {
        return "/home";
    }

    @RequestMapping(value = "/home-slider", method = {RequestMethod.GET})
    public ResponseEntity<?> getHomeSlider() {

        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getHomeSlider();
            resp.put(RF.RESULTS, results);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
            errorLogger.error(ex.getMessage(), ex);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);

        return entity;
    }

    @RequestMapping(value = "/list-menus/{menuType}", method = {RequestMethod.GET})
    public ResponseEntity<?> getListMenus(@PathVariable String menuType) {
        
        String urlAPI = GlobalValue.URL_BACKEND+"home/list-menus/"+menuType;
        ResponseEntity<?> entity = getRequestRestClient(urlAPI);
        return entity;
    }

    @RequestMapping(value = "/testimonial", method = {RequestMethod.GET})
    public ResponseEntity<?> getTestimonial() {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getTestimonial();
            resp.put(RF.RESULTS, results);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
            errorLogger.error(ex.getMessage(), ex);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);

        return entity;
    }

    @RequestMapping(value = "/celebrate", method = {RequestMethod.GET})
    public ResponseEntity<?> getCelebrate() {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getCelebrate();
            resp.put(RF.RESULTS, results);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
            errorLogger.error(ex.getMessage(), ex);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);

        return entity;
    }

    @RequestMapping(value = "/list-pages/{pageType}", method = {RequestMethod.GET})
    public ResponseEntity<?> getListPages(@PathVariable String pageType) {
        String urlAPI = GlobalValue.URL_BACKEND+"home/list-pages/"+pageType;
        ResponseEntity<?> entity = getRequestRestClient(urlAPI);
        return entity;
    }

    @RequestMapping(value = "/profile", method = {RequestMethod.GET})
    public ResponseEntity<?> getProfile() {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getProfile();
            resp.put(RF.RESULTS, results);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
            errorLogger.error(ex.getMessage(), ex);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);

        return entity;
    }

    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addCustomer(@RequestBody Customer request) {
        String url = GlobalValue.URL_BACKEND+"home/add-customer";
        MultiValueMap<String, String> headersPost = new LinkedMultiValueMap<String, String>();
        headersPost.add("Content-Type", "application/json");
        Map<String, Object> map = mapper.convertValue(request, Map.class);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map,headersPost);
        ResponseEntity<?> entity =  getPostRestClient(httpEntity, url);
        return entity;
    }
    
    @RequestMapping(value = "/add-partner", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addPartner(@RequestBody Partner request) {
        String url = GlobalValue.URL_BACKEND+"home/add-partner";
        MultiValueMap<String, String> headersPost = new LinkedMultiValueMap<String, String>();
        headersPost.add("Content-Type", "application/json");
        Map<String, Object> map = mapper.convertValue(request, Map.class);
        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(map,headersPost);
        ResponseEntity<?> entity =  getPostRestClient(httpEntity, url);
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
            ResponseEntity<String> response = restTemplate.getForEntity(urlAPI , String.class);
            resp = mapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>(){});
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
        RestTemplate restTemplate = new RestTemplate();try {
            String response = restTemplate.postForObject(url, request,String.class);
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
        String urlAPI = GlobalValue.URL_BACKEND+"home/list-partner";
        ResponseEntity<?> entity = getRequestRestClient(urlAPI);
        return entity;
    }
}
