package com.example.demo.lab12;

import com.example.demo.model.SinhVien;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/lab12/bai-3")
public class Bai3Controller {

    @PostMapping("")
    public String bai3(Model model, @RequestParam String namex, @RequestParam Integer gender, @RequestParam Integer d){
        ArrayList<SinhVien> list = new ArrayList<>();
        SinhVien sv1 = new SinhVien();
        sv1.setName("a");
        sv1.setChuyenNganh(1);
        sv1.setGioitinh(0);


        list.add(sv1);
        SinhVien sv =  new SinhVien(namex, gender, d);
        list.add(sv);

        model.addAttribute("lists", list);

        return "lab12/bai3result";
    }

    @RequestMapping("")
    public String in(Model model){

        return "lab12/bai3";
    }


    public ArrayList<SinhVien> add(ArrayList<SinhVien> list){

        return list;
    }
}
