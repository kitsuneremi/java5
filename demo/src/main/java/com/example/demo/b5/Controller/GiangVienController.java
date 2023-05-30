package com.example.demo.b5.Controller;

import com.example.demo.b5.Models.GiangVien;
import com.example.demo.b5.Service.GiangVienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/b5/giang-vien")
public class GiangVienController {
    GiangVienService service = new GiangVienService();


    @GetMapping
    public String viewAll(Model model){
        ArrayList<GiangVien> list = service.getList();
        model.addAttribute("list", list);
        return "b5/giangvien";
    }
}
