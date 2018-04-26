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

import com.fwd.domain.Pages;
import com.fwd.repository.PageRepository;
import com.fwd.util.RC;
import com.fwd.util.RF;
import com.fwd.util.Utils;

@Controller
@RequestMapping("/api")
public class PagesCustomController {
    
    public final static String PAGES_IMAGE_PATH = "image/";
    public final static String PAGES_ICON_PATH = "icon/";
    @Autowired
    PageRepository pageRepository;
    
    @RequestMapping(value = "/pagescustom", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addPage(@RequestBody Pages request) {
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getHeaderImagePath() != null && !request.getHeaderImagePath().isEmpty()) {
                String pathHeader = PAGES_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getHeaderImagePath(), pathHeader);
                request.setHeaderImagePath(pathHeader);
            }
            
            if (request.getIconPath() != null && !request.getIconPath().isEmpty()) {
                String pathIcon = PAGES_ICON_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getIconPath(), pathIcon);
                request.setIconPath(pathIcon);
            }
            pageRepository.save(request);
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
    
    @RequestMapping(value = "/pagescustom/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> editPage(@PathVariable("id") Long id, @RequestBody Pages request) {
        
        Pages page = pageRepository.findOne(id);
        if (page.getHeaderImagePath() != null && !page.getHeaderImagePath().isEmpty() && request.isHeaderImagePathChanged()) {
            String pathImageHeader = Utils.PATH_UPLOAD + page.getHeaderImagePath();
            Utils.deleteFile(pathImageHeader);
        }
        
        if (page.getIconPath() != null && !page.getIconPath().isEmpty() && request.isIconPathChanged()) {
            String pathIcons = Utils.PATH_UPLOAD + page.getIconPath();
            //delete image existing
            Utils.deleteFile(pathIcons);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            if (request.getHeaderImagePath() != null && !request.getHeaderImagePath().isEmpty() && request.isHeaderImagePathChanged()) {
                String pathHeader = PAGES_IMAGE_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getHeaderImagePath(), pathHeader);
                request.setHeaderImagePath(pathHeader);
            } else {
                request.setHeaderImagePath(page.getHeaderImagePath());
            }
            
            if (request.getIconPath() != null && !request.getIconPath().isEmpty() && request.isIconPathChanged()) {
                String pathIcon = PAGES_ICON_PATH + RandomStringUtils.randomAlphanumeric(10) + "."
                        + Utils.UPLOAD_IMAGE_TYPE;
                Utils.createImage(request.getIconPath(), pathIcon);
                request.setIconPath(pathIcon);
            } else {
                request.setIconPath(page.getIconPath());
            }
            pageRepository.save(request);
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
    
    @RequestMapping(value = "/pagescustom/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePage(@PathVariable("id") Long id) {
        
        Pages page = pageRepository.findOne(id);
        if (page.getHeaderImagePath() != null && !page.getHeaderImagePath().isEmpty()) {
            String pathImageHeader = Utils.PATH_UPLOAD + page.getHeaderImagePath();
            Utils.deleteFile(pathImageHeader);
        }
        
        if (page.getIconPath() != null && !page.getIconPath().isEmpty()) {
            String pathIcons = Utils.PATH_UPLOAD + page.getIconPath();
            //delete image existing
            Utils.deleteFile(pathIcons);
        }
        
        ResponseEntity<?> entity = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Map<String, Object> resp = new HashMap();
        try {
            pageRepository.delete(id);
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
