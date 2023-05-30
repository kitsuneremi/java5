package com.example.demo.asm.Controller;


import com.example.demo.asm.Model.RauModel;
import com.example.demo.asm.Repo.IRauRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/asm")
public class RauController {
    @Autowired
    private IRauRepo repo;

    @GetMapping
    public String get(Model model, @RequestParam(name = "stt", required = false, defaultValue = "1") Integer stt, @RequestParam(name = "keyword", required = false, defaultValue = "") String kw, @RequestParam(name = "min", required = false, defaultValue = "0") BigDecimal min, @RequestParam(name = "max", required = false, defaultValue = "0") BigDecimal max) {
        if (stt == 0) {
            stt = 1;
        }
        Pageable pageable = PageRequest.of(stt - 1, 3);
        Page<RauModel> page = null;
        if (kw.equalsIgnoreCase("")) {

            if(Objects.equals(max, BigDecimal.ZERO)){
                page = repo.findAll(pageable);
            }else{
                page = repo.findByDongiaBetween(min, max, pageable);
            }
        } else {
            if(Objects.equals(max, BigDecimal.ZERO)){
                page = repo.findByTenContains(kw, pageable);
            }else{
                page = repo.findByTenContainsAndDongiaBetween(kw, min, max, pageable);
            }

        }
        model.addAttribute("pagex", page);
        return "asm/home";
    }

    @RequestMapping("/delete/{ma}")
    public String deltele(Model model, @PathVariable int ma) {
        repo.deleteByMa(ma);
        return "redirect:/asm";
    }

    @PostMapping("/add")
    public String saveorupdate(@RequestParam String ma, @RequestParam String ten, @RequestParam String soluong, @RequestParam String dongia, @RequestParam String ansong, @RequestParam String phanloai) {
        RauModel rau = new RauModel();
        rau.setMa(Integer.parseInt(ma));
        rau.setTen(ten);
        rau.setSoluong(Integer.parseInt(soluong));
        rau.setDongia(BigDecimal.valueOf(Double.parseDouble(dongia)));
        rau.setAnsong(Boolean.parseBoolean(ansong));
        rau.setPhanloai(Integer.parseInt(phanloai));

        RauModel existingModel = repo.findById(rau.getMa()).orElse(null);
        if (existingModel != null) {
            existingModel.setTen(rau.getTen());
            existingModel.setDongia(rau.getDongia());
            existingModel.setAnsong(rau.isAnsong());
            existingModel.setPhanloai(rau.getPhanloai());
            repo.save(existingModel);
        } else {
            repo.save(rau);
        }

        return "redirect:/asm";
    }


    @RequestMapping("/detail/{id}")
    public String detail(Model model,@PathVariable int id){
        RauModel rau = repo.findByMa(id);
        model.addAttribute("rau", rau);
        return "/asm/detail";
    }
}
