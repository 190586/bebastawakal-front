package com.fwd.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fwd.domain.Testimonial;
import com.fwd.repository.TestimonialRepository;
import com.fwd.util.RC;
import com.fwd.util.RF;
import com.fwd.util.Utils;

@Controller
@RequestMapping("/api")
public class TestimonialCustomController {
    
    public final static String TESTIMONIAL_IMAGE_PATH = "image/";
    public final static String TESTIMONIAL_AVATAR_PATH = "avatar/";
    @Autowired
    TestimonialRepository testimonialRepository;
    
    @RequestMapping(value = "/testimonialscustom", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addTestimonial(@RequestBody Testimonial request) {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getImageBackgroundPath() != null && !request.getImageBackgroundPath().isEmpty()) {
                String pathHeader = TESTIMONIAL_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getImageBackgroundPath(), pathHeader);
                request.setImageBackgroundPath(pathHeader);
            }
            
            if (request.getAvatarPath() != null && !request.getAvatarPath().isEmpty()) {
                String pathIcon = TESTIMONIAL_AVATAR_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getAvatarPath(), pathIcon);
                request.setAvatarPath(pathIcon);
            }
            testimonialRepository.save(request);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);
        return entity;
    }
    
    @RequestMapping(value = "/testimonialscustom/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editTestimonial(@PathVariable("id") Long id, @RequestBody Testimonial request) {
        
        Testimonial page = testimonialRepository.findOne(id);
        if (page.getImageBackgroundPath() != null && !page.getImageBackgroundPath().isEmpty() && request.isImageBackgroundPathChanged()) {
            String pathImageHeader = Utils.PATH_UPLOAD + page.getImageBackgroundPath();
            Utils.deleteFile(pathImageHeader);
        }
        
        if (page.getAvatarPath() != null && !page.getAvatarPath().isEmpty() && request.isAvatarPathChanged()) {
            String pathIcons = Utils.PATH_UPLOAD + page.getAvatarPath();
            //delete image existing
            Utils.deleteFile(pathIcons);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getImageBackgroundPath() != null && !request.getImageBackgroundPath().isEmpty() && request.isImageBackgroundPathChanged()) {
                String pathHeader = TESTIMONIAL_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getImageBackgroundPath(), pathHeader);
                request.setImageBackgroundPath(pathHeader);
            } else {
                request.setImageBackgroundPath(page.getImageBackgroundPath());
            }
            
            if (request.getAvatarPath() != null && !request.getAvatarPath().isEmpty() && request.isAvatarPathChanged()) {
                String pathIcon = TESTIMONIAL_AVATAR_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getAvatarPath(), pathIcon);
                request.setAvatarPath(pathIcon);
            } else {
                request.setAvatarPath(page.getAvatarPath());
            }
            testimonialRepository.save(request);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);
        return entity;
    }
    
    @RequestMapping(value = "/testimonialscustom/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteTestimonial(@PathVariable("id") Long id) {
        
        Testimonial page = testimonialRepository.findOne(id);
        if (page.getImageBackgroundPath() != null && !page.getImageBackgroundPath().isEmpty()) {
            String pathImageHeader = Utils.PATH_UPLOAD + page.getImageBackgroundPath();
            Utils.deleteFile(pathImageHeader);
        }
        
        if (page.getAvatarPath() != null && !page.getAvatarPath().isEmpty()) {
            String pathIcons = Utils.PATH_UPLOAD + page.getAvatarPath();
            //delete image existing
            Utils.deleteFile(pathIcons);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            testimonialRepository.delete(id);
            boolean success = true;
            resp.put(RF.RESULTS, success);
            resp.put(RF.RESPONSE_CODE, RC.SUCCESS);
            resp.put(RF.RESPONSE_MESSAGE, RC.SUCCESS_DESC);
        } catch (Exception ex) {
            resp.put(RF.RESPONSE_CODE, RC.UNKNOWN_FAIL);
            resp.put(RF.RESPONSE_MESSAGE, RC.UNKNOWN_FAIL_DESC);
        }
        entity = new ResponseEntity(resp, headers, HttpStatus.OK);
        return entity;
    }
    
}
