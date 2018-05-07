package com.fwd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @RequestMapping(value = "/partner", method = RequestMethod.GET)
    public String partner() {
        return "partner";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "error/403";
    }

}
