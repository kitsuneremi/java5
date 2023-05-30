package com.example.demo.b2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/b2")
    public String Welcome(){
        return "index";
    }
}
