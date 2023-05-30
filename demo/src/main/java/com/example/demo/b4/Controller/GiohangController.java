package com.example.demo.b4.Controller;

import com.example.demo.b4.Product;
import com.example.demo.b4.Services.GiohangService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/b4/cart")
public class GiohangController {

    private final GiohangService ghService = new GiohangService();

    @RequestMapping("/add/{proid}")
    public String addpro(@PathVariable(name = "proid") int proid){
        ghService.add(proid, 1);
        return "redirect:/b4/cart";
    }

    @GetMapping
    public String view(Model model){
        Map<Product, Integer> list = ghService.getList();
        model.addAttribute("list",list);
        return "b4/cart";
    }

    @RequestMapping("/remove/{proid}")
    public String remove(@PathVariable(name = "proid") int proid){
        ghService.remove(proid);
        return "redirect:/b4/cart";
    }
}
