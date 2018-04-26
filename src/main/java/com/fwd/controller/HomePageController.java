/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fwd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
  
    public String index() {
        return "/home";
    }
    
    @RequestMapping(value = "/main-carousel-bar", method = {RequestMethod.GET})
    public ResponseEntity<?> getMainCarouselBar() {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getMainCarouselBar();
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
    
    @RequestMapping(value = "/main-static-right", method = {RequestMethod.GET})
    public ResponseEntity<?> getMainStaticRight() {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getMainStaticRight();
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
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getMenu(menuType);
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
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            List results = homePageService.getListPages(pageType);
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
    
}
