package com.example.demo.lab.Controller;

import com.example.demo.lab.Models.Bai1Model;
import com.example.demo.lab.Service.Bai1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/lab34/bai-1")
public class Bai1Controller {

    @Autowired
    private Bai1Service service;

    @RequestMapping("")
    public String Get(Model model){
        ArrayList<Bai1Model> list = service.getList();
        model.addAttribute("list", list);
        return "lab/bai1";
    }

    @PostMapping("/add")
    public String add(Model model, @RequestParam String mamon, @RequestParam String tenmon, @RequestParam String stc, @RequestParam int chuyennganh, @RequestParam int[] giangvien, @RequestParam int batbuoc  ){
        Bai1Model mod = new Bai1Model();
        mod.setTenmon(tenmon);
        mod.setMamon(mamon);
        mod.setChuyennganh(chuyennganh);
        mod.setStc(Integer.parseInt(stc));
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < giangvien.length; i++){
            x.add(giangvien[i]);
        }
        mod.setGiangvien(x);
        mod.setBatbuoc(batbuoc == 0);

        ArrayList<Bai1Model> list = service.getList();

        list.add(mod);

        model.addAttribute("list", list);
        return "redirect:/lab34/bai-1";
    }

    @RequestMapping("/delete/{mamon}")
    public String remove(Model model, @PathVariable String mamon){

        ArrayList<Bai1Model> list = service.getList();
        System.out.println(mamon);
        list.removeIf(val -> Objects.equals(val.getMamon(), mamon));
        model.addAttribute("list", list);
        return "redirect:/lab34/bai-1";
    }
}
