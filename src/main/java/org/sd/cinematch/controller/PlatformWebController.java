package org.sd.cinematch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlatformWebController {

     @GetMapping("/createplatform")
     public String showCreatePlatform() {
         return "createplatform";
     }

     @GetMapping("/updateplatform")
     public String showUpdatePlatform() {
         return "updateplatform";
     }

     @GetMapping("/deleteplatform")
     public String showRemovePage() {
         return "deleteplatform";
     }

     @GetMapping("/replaceplatform")
     public String showReplacePage() {
         return "replaceplatform";
     }
}
