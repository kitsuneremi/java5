package com.example.demo.b4.Controller;

import com.example.demo.b4.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class productController {
    private static final List<Product> list = new ArrayList<>();
    static {
        list.add(new Product(1, "sp1", 1, 20000.0));
        list.add(new Product(2, "sp2", 5, 70000.0));
        list.add(new Product(3, "sp3", 3, 120000.0));
        list.add(new Product(4, "sp4", 7, 450000.0));
    }
    @RequestMapping("/b4")
    public String getListProduct(Model model){
        model.addAttribute("list", list);
        return "b4/sp";
    }

    public List<Product> getList(){
        return list;
    }

}
