package com.example.demo.lab.Controller;

import com.example.demo.lab.Model.HocSInh;
import com.example.demo.lab.Repo.IHocSinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/lab78")
public class HocSinhController {

    @Autowired
    @Qualifier("hocsinhrepo")
    private IHocSinhRepo repo;


    @RequestMapping("")
    public String home(Model model, @RequestParam(required = false, defaultValue = "-1") String stt, @RequestParam(required = false, defaultValue = "") String keyword){
        int p = Integer.parseInt(stt);
        if(p == -1){
            p = 0;
        }
        Pageable pab = PageRequest.of(p,5);
        if(keyword.equalsIgnoreCase("")){
            Page<HocSInh> pagex = repo.findHocSInhByHanhkiemGreaterThanOrderByHanhkiemDesc(-1, pab);
            model.addAttribute("pagex", pagex);
        }else{
//            Page<HocSInh> pagex = repo.findHocSInhByTenLike(keyword, pab);
            Page<HocSInh> pagex = repo.findHocSInhByTenContaining(keyword, pab);
            model.addAttribute("pagex", pagex);
        }
        return "/lab78/home";
    }


    @PostMapping("/add")
    public String add(@RequestParam(required = false, defaultValue = "-1") String ma, @RequestParam String ten, @RequestParam String lop, @RequestParam String tbm, @RequestParam String hanhkiem){
        int id = Integer.parseInt(ma);
        HocSInh hs = new HocSInh();
        if(id != -1){
               hs.setMa(id);
        }
        hs.setTen(ten);
        hs.setLop(Integer.parseInt(lop));
        if(hanhkiem.contains(",")){
            String[] x = hanhkiem.split(",");
            hanhkiem = x[0] + "." + x[1];
            hs.setHanhkiem(Integer.parseInt(hanhkiem));
        }else{
            hs.setHanhkiem(Integer.parseInt(hanhkiem));
        }
        hs.setTbm(Float.parseFloat(tbm));
        repo.save(hs);
        return "redirect:/lab78";
    }

    @RequestMapping("/delete/{ma}")
    public String delete(@PathVariable String ma){
        repo.deleteByMa(Integer.parseInt(ma));
        return "redirect:/lab78";
    }

    @RequestMapping("/satistical")
    public String statistical(Model model){
        List<HocSInh> list = repo.findAllByOrderByHanhkiemDesc();
        model.addAttribute("list", list);

        return "lab78/satistical";
    }

    @RequestMapping("/addpage")
    public String addpage(){
        return "/lab78/addpage";
    }
}
