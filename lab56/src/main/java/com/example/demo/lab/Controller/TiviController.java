package com.example.demo.lab.Controller;

import com.example.demo.lab.Model.Tivi;
import com.example.demo.lab.Repo.ITiviRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lab56")
public class TiviController {
    @Autowired
    private ITiviRepo repo;
    @GetMapping
    public String home(Model model, @RequestParam(required = false, defaultValue = "") String keyword, @RequestParam(required = false, defaultValue = "0") String stt){
        Page<Tivi> page;
        System.out.println(keyword);
        int x = Integer.parseInt(stt);
        if(x == -1){
            x = 0;
        }
        Pageable pab = PageRequest.of(x, 5);
        if(keyword.equalsIgnoreCase("")){
            page = repo.findAll(pab);
        }else{
            page = repo.findByTenContains(keyword, pab);
        }
        model.addAttribute("pagex", page);
        return "/lab56/home";
    }

    @PostMapping("/add")
    public String add(@RequestParam String ma, @RequestParam String ten, @RequestParam String nsx, @RequestParam String kichco, @RequestParam String dpg){
        Tivi tv = new Tivi();
        tv.setId(Integer.parseInt(ma));
        tv.setNsx(nsx);
        tv.setDophangiai(dpg);
        tv.setKichco(Integer.parseInt(kichco));
        tv.setTen(ten);
        repo.save(tv);
        return "redirect:/lab56";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        repo.delete(repo.findById(Integer.parseInt(id)));
        return "redirect:/lab56";
    }

}
