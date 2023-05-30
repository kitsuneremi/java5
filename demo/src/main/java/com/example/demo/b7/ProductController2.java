package com.example.demo.b7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("b7/product")
public class ProductController2 {
    @Autowired
    private IProductRepo repo;

    @GetMapping
    public String viewAll(Model model){
        List<Product> list = repo.findAll();
        model.addAttribute("list", list);
        return "b7/product";
    }

    @GetMapping("/find")
    public String findAny(Model model){
        Pageable pageable = PageRequest.of(0, 10);
        Page<Product> page = repo.findAll(pageable);
        List<Product> list =page.getContent();
//        List<Product> list = repo.findByProductNameContains("Scarlet");
//        List<Product> list = repo.findByQuantityGreaterThan(500);
//        List<Product> list = repo.findByPriceBetween(BigDecimal.valueOf(3000000), BigDecimal.valueOf(4000000));
//        List<Product> list = repo.findByQuantityLessThanAndAndPriceAfterOrderByProductIdAsc(200, BigDecimal.valueOf(2000000));
        model.addAttribute("list", list);
        return "b7/product";
    }
}
