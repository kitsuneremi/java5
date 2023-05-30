package com.example.asm.mx.Controller;

import com.example.asm.mx.Model.RauModel;
import com.example.asm.mx.Repo.IRauRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/asm")
public class RauController {
    @Autowired
    private IRauRepo repo;

    @GetMapping
    public String get(Model model){
        List<RauModel> list = repo.findAll();
        model.addAttribute("list", list);
        return "test/home";
    }
}
