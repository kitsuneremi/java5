package com.example.demo.lab.Controller;


import com.example.demo.lab.Models.Loa;
import com.example.demo.lab.Service.LoaService;
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
@RequestMapping("/lab34/bai-2")
public class LoaController {

    @Autowired
    private LoaService service;

    @RequestMapping("")
    public String get(Model model){

        ArrayList<Loa> list = service.getList();
        model.addAttribute("list", list);
        return "lab/bai2";
    }

    @PostMapping("/add")
    public String add(Model model, @RequestParam String maloa, @RequestParam String tenloa, @RequestParam String congsuat, @RequestParam int mausac, @RequestParam String kenhamthanh){
        Loa loa = new Loa();
        loa.setCongsuat(Integer.parseInt(congsuat));
        loa.setKenhamthanh(Integer.parseInt(kenhamthanh));
        loa.setMausac(mausac);
        loa.setMaloa(maloa);
        loa.setTenloa(tenloa);
        ArrayList<Loa> list = service.getList();
        list.add(loa);
        model.addAttribute("list", list);
        return "redirect:/lab34/bai-2";
    }

    @RequestMapping("/delete/{maloa}")
    public String delete(Model model, @PathVariable String maloa){
        System.out.println(maloa);
        ArrayList<Loa> list = service.getList();
        list.removeIf(loa -> Objects.equals(loa.getMaloa(), maloa));
        model.addAttribute("list", list);
        return "redirect:/lab34/bai-2";
    }

    @PostMapping("/update")
    public String update( @RequestParam String maloa, @RequestParam String tenloa, @RequestParam String congsuat, @RequestParam int mausac, @RequestParam String kenhamthanh){
        Loa loa = new Loa();
        loa.setCongsuat(Integer.parseInt(congsuat));
        loa.setKenhamthanh(Integer.parseInt(kenhamthanh));
        loa.setMausac(mausac);
        loa.setMaloa(maloa);
        loa.setTenloa(tenloa);
        ArrayList<Loa> list = service.getList();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getMaloa().equalsIgnoreCase(maloa)){
                list.set(i, loa);
            }

        }
        return "redirect:/lab34/bai-2";
    }


}
