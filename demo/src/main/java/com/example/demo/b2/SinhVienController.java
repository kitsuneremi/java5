package com.example.demo.b2;

import com.example.demo.model.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Calendar;

@Controller
@RequestMapping("/b2")
public class SinhVienController {
    @RequestMapping("/sv")
    public String test(Model model){
        ArrayList<SinhVien> list = new ArrayList<>();
        for (int i = 0 ; i <3 ; i++){
            list.add(new SinhVien("a", i));
        }
        model.addAttribute("list", list);
        return "/b2/sv";
    }

    @PostMapping("/tinh")
    public String testForm(Model model, @RequestParam Integer year){
        int tuoi = Calendar.getInstance().get(Calendar.YEAR) - year;
        model.addAttribute("tuoi", tuoi);
        return "/b2/tuoi";
    }
}
