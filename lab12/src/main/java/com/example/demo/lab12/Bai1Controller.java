package com.example.demo.lab12;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab12/bai-1")
public class Bai1Controller {

    @RequestMapping("")
    public String start(){
        return "lab12/bai1";
    }

    @PostMapping("")
    public String tinhdiem(Model model, @RequestParam Float lab, @RequestParam Float quiz, @RequestParam Float asm, @RequestParam Float finalx){
        Double tongket = lab*0.28 + quiz*0.12 + asm*0.2 + finalx*0.4;
        if(tongket > 5 && finalx > 5){
            model.addAttribute("result","pass");
        }else{
            model.addAttribute("result","fail");
        }
        model.addAttribute("tongket", tongket);
        return "lab12/bai1result";
    }
}
