package com.example.demo.lab12;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/lab12/bai-2")
public class Bai2Controller {

    @PostMapping("")
    public String bai2(Model model, @RequestParam Double weight, @RequestParam Double height){
        double BMI = weight/(height * 2);
        String result = "";
        if(BMI < 16){
            result = "gầy độ III";
        }else if(BMI < 17){
            result = "gầy độ II";
        }else if(BMI < 18.5){
            result = "gầy độ I";
        }else if(BMI < 25){
            result = "bình thường";
        }else if(BMI < 30){
            result = "thừa cân";
        }else if(BMI < 35){
            result = "béo phì độ I";
        }else if(BMI < 40){
            result = "béo phì độ II";
        }else{
            result = "béo phì độ III";
        }
        model.addAttribute("result", result);
        return "lab12/bai2result";
    }
    @RequestMapping("")
    public String in(){
        return "lab12/bai2";
    }
}
