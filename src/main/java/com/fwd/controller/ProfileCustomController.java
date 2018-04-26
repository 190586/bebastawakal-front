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

import com.fwd.domain.Profile;
import com.fwd.repository.ProfileRepository;
import com.fwd.util.RC;
import com.fwd.util.RF;
import com.fwd.util.Utils;

@Controller
@RequestMapping("/api")
public class ProfileCustomController {
    
    public final static String PROFILE_IMAGE_PATH = "image/";
    
    @Autowired
    ProfileRepository profileRepository;
    
    @RequestMapping(value = "/profilescustom", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addProfile(@RequestBody Profile request) {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getLogo() != null && !request.getLogo().isEmpty()) {
                String pathHeader = PROFILE_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getLogo(), pathHeader);
                request.setLogo(pathHeader);
            }
            
            profileRepository.save(request);
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
    
    @RequestMapping(value = "/profilescustom/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editPage(@PathVariable("id") Long id, @RequestBody Profile request) {
        
        Profile profile = profileRepository.findOne(id);
        if (profile.getLogo() != null && !profile.getLogo().isEmpty() && request.isLogoChanged()) {
            String pathImageHeader = Utils.PATH_UPLOAD + profile.getLogo();
            Utils.deleteFile(pathImageHeader);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getLogo() != null && !request.getLogo().isEmpty() && request.isLogoChanged()) {
                String pathHeader = PROFILE_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getLogo(), pathHeader);
                request.setLogo(pathHeader);
            } else {
                request.setLogo(profile.getLogo());
            }
            
            profileRepository.save(request);
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
    
    @RequestMapping(value = "/profilescustom/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePage(@PathVariable("id") Long id) {
        
        Profile menu = profileRepository.findOne(id);
        if (menu.getLogo() != null && !menu.getLogo().isEmpty()) {
            String pathImageHeader = Utils.PATH_UPLOAD + menu.getLogo();
            Utils.deleteFile(pathImageHeader);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            profileRepository.delete(id);
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
