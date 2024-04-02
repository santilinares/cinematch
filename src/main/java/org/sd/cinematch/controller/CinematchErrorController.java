package org.sd.cinematch.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CinematchErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {        
        return "error";
    }
    
    public String getErrorPath() {
        return "/error";
    }
}
