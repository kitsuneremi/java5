package com.example.demo.asm.Controller;


import com.example.demo.asm.Model.*;
import com.example.demo.asm.Repo.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/asm")
public class RauController {
    @Autowired
    @Qualifier("raurepo")
    private IRauRepo repo;

    @Autowired
    @Qualifier("ghrepo")
    private IGioHangRepo ghrepo;

    @Autowired
    @Qualifier("taikhoanrepo")
    private ITaiKhoanRepo tkrepo;

    @Autowired
    @Qualifier("hoadonrepo")
    private IHoaDonRepo hdrepo;

    @Autowired
    @Qualifier("hoadonchitietrepo")
    private IHoaDonChiTietRepo hdctrepo;

    @GetMapping
    public String get(Model model, @RequestParam(name = "stt", required = false, defaultValue = "1") Integer stt, @RequestParam(name = "keyword", required = false, defaultValue = "") String kw, @RequestParam(name = "min", required = false, defaultValue = "0") BigDecimal min, @RequestParam(name = "max", required = false, defaultValue = "0") BigDecimal max) {
        if (stt == 0) {
            stt = 1;
        }
        Pageable pageable = PageRequest.of(stt - 1, 3);
        Page<RauModel> page = null;
        if (kw.equalsIgnoreCase("")) {

            if (Objects.equals(max, BigDecimal.ZERO)) {
                page = repo.findAll(pageable);
            } else {
                page = repo.findByDongiaBetween(min, max, pageable);
            }
        } else {
            if (Objects.equals(max, BigDecimal.ZERO)) {
                page = repo.findByTenContains(kw, pageable);
            } else {
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
    public String saveorupdate(@RequestParam(required = false, defaultValue = "-1") String ma, @RequestParam String ten, @RequestParam String soluong, @RequestParam String dongia, @RequestParam String ansong, @RequestParam String phanloai) {
        RauModel rau = new RauModel();
        rau.setMa(Integer.parseInt(ma));
        rau.setTen(ten);
        rau.setSoluong(Integer.parseInt(soluong));
        BigDecimal bigDecimalValue = new BigDecimal(dongia);
        BigDecimal maxValue = new BigDecimal("922337203685477.5807");
        BigDecimal minValue = new BigDecimal("-922337203685477.5808");
        if (bigDecimalValue.compareTo(maxValue) > 0) {
            bigDecimalValue = maxValue;
        } else if (bigDecimalValue.compareTo(minValue) < 0) {
            bigDecimalValue = minValue;
        }
        rau.setDongia(bigDecimalValue);
        rau.setAnsong(!ansong.equals("0"));
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
    public String detail(Model model, @PathVariable int id) {
        RauModel rau = repo.findByMa(id);
        model.addAttribute("rau", rau);
        return "/asm/detail";
    }

    @RequestMapping("/addcart")
    public String addcart(HttpServletRequest request, @RequestParam String marau, @RequestParam String sl) {
        int matk = Integer.parseInt(request.getSession().getAttribute("matk").toString());
        if (request.getSession().getAttribute("matk") == null) {
            return "redirect:/asm/login";
        }
        List<GioHangChiTietModel> list = ghrepo.findByMataikhoan(matk);
        int count = -1;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMarau() == Integer.parseInt(marau)){
                count = i;
            }
        }
        if(count == -1){
            GioHangChiTietModel newgh = new GioHangChiTietModel();
            newgh.setMarau(Integer.parseInt(marau));
            newgh.setMataikhoan(matk);
            newgh.setSoluong(Integer.parseInt(sl));
            ghrepo.save(newgh);
        }else{
            int oldvalue = list.get(count).getSoluong();
            GioHangChiTietModel m = list.get(count);
            m.setSoluong(oldvalue + 1);
            ghrepo.save(m);
        }
        return "redirect:/asm/cart";
    }

    @RequestMapping("/cart")
    public String cart(HttpSession session, Model model) {
        if (session.getAttribute("matk") == null) {
            return "redirect:/asm/login";
        }
        List<GioHangChiTietModel> list = ghrepo.findByMataikhoan(Integer.parseInt(session.getAttribute("matk").toString()));
        BigDecimal tongtien = BigDecimal.ZERO;
        for (GioHangChiTietModel l : list) {
            tongtien = tongtien.add(l.getRau().getDongia().multiply(BigDecimal.valueOf(l.getSoluong())));
        }
        model.addAttribute("list", list);
        model.addAttribute("tongtien", tongtien);
        return "/asm/cart";
    }

    @PostMapping("/cart/delete")
    @Transactional
    public String deletecart(HttpServletRequest request,@RequestParam String marau, @RequestParam String mataikhoan) {
        int matk = Integer.parseInt(request.getSession().getAttribute("matk").toString());
        if (request.getSession().getAttribute("matk") == null || matk == -1) {
            return "redirect:/asm/login";
        }
        ghrepo.deleteByMarauAndMataikhoan(Integer.parseInt(marau), Integer.parseInt(mataikhoan));
        return "redirect:/asm/cart";
    }

    @PostMapping("/cart/update")
    public String updatecart(HttpSession session,@RequestParam String marau, @RequestParam String sl) {
        GioHangChiTietModel ghmodel = new GioHangChiTietModel();
        List<GioHangChiTietModel> list = ghrepo.findAll();
        int count = -1;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getMarau() == Integer.parseInt(marau)){
                count = i;
            }
        }
        if(count == -1){
            GioHangChiTietModel newgh = new GioHangChiTietModel();
            newgh.setMarau(Integer.parseInt(marau));
            newgh.setMataikhoan(Integer.parseInt(session.getAttribute("matk").toString()));
            newgh.setSoluong(Integer.parseInt(sl));
            ghrepo.save(newgh);
        }else{
            GioHangChiTietModel m = list.get(count);
            m.setSoluong(Integer.parseInt(sl));
            ghrepo.save(m);
        }
        return "redirect:/asm/cart";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "");
        return "/asm/login";
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) {
        TaiKhoanModel tk = tkrepo.findByTendangnhapAndMatkhau(username, password);
        if (tk == null) {
            model.addAttribute("message", "login failed");
            return "/asm/login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("matk", tk.getMa());
            session.setAttribute("ten", tk.getTendangnhap());
            return "redirect:/asm";
        }

    }

    @RequestMapping("/register")
    public String register() {
        return "/asm/register";
    }

    @PostMapping("/register")
    public String postRegister(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email) {
        if (tkrepo.existsByTendangnhap(username)) {
            model.addAttribute("message", "ten dang nhap da ton tai");
            return "redirect:/asm/register";
        }else if(tkrepo.existsByEmail(email)){
            model.addAttribute("message", "email da duoc su dung");
            return "redirect:/asm/register";
        } else {
            TaiKhoanModel tk = new TaiKhoanModel();
            tk.setTendangnhap(username);
            tk.setMatkhau(password);
            tk.setEmail(email);
            tkrepo.save(tk);
            model.addAttribute("message", "tao tai khoan thanh cong");
            return "redirect:/asm/login";
        }
    }


    @PostMapping("/resolvecart")
    public String resolveCart(@RequestParam String matk) {
        HoaDonModel hdm = new HoaDonModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentTime = new Date();
        List<GioHangChiTietModel> list = ghrepo.findAll();

        try {
            String formattedDate = dateFormat.format(currentTime);
            Date parsedDate = dateFormat.parse(formattedDate);
            hdm.setNgaymua(parsedDate);
            hdm.setMataikhoan(Integer.parseInt(matk));
            hdrepo.save(hdm);
            for (GioHangChiTietModel g : list) {
                HoaDonChiTietModel hdctm = new HoaDonChiTietModel();
                hdctm.setMahoadon(hdm.getMa());
                hdctm.setMarau(g.getMarau());
                hdctm.setSoluong(g.getSoluong());
                hdctrepo.save(hdctm);
                int i = 0;
                if (repo.findByMa(g.getMarau()).getSoluong() > g.getSoluong()) {
                    i = repo.findByMa(g.getMarau()).getSoluong() - g.getSoluong();
                }
                RauModel raumodel = repo.findByMa(g.getMarau());
                raumodel.setSoluong(i);
                repo.save(raumodel);
            }
            ghrepo.deleteByMataikhoan(Integer.parseInt(matk));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "redirect:/asm/cart";
    }


    @RequestMapping("/bill")
    public String bill(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("matk") == null) {
            return "redirect:/asm/login";
        }

        List<HoaDonModel> listhd = hdrepo.findByMataikhoan(String.valueOf(session.getAttribute("matk")));
        List<HoaDonViewModel> listhdv = new ArrayList<>();
        for (HoaDonModel hd : listhd) {
            HoaDonViewModel hdvm = new HoaDonViewModel();
            hdvm.setMa(hd.getMa());
            hdvm.setNgaytao(hd.getNgaymua());
            List<HoaDonChiTietModel> listhdct = hdctrepo.findByMahoadon(hd.getMa());
            BigDecimal tongtien = BigDecimal.ZERO;
            for (HoaDonChiTietModel ctvm : listhdct) {
                tongtien = tongtien.add(repo.findByMa(ctvm.getMarau()).getDongia().multiply(BigDecimal.valueOf(ctvm.getSoluong())));
            }
            hdvm.setTongtien(tongtien);
            listhdv.add(hdvm);
        }
        model.addAttribute("list", listhdv);
        return "/asm/bill";
    }

    @RequestMapping("/detailbill")
    public String detailBill(HttpServletRequest request, Model model, @RequestParam String id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("matk") == null) {
            return "redirect:/asm/login";
        }
//        List<HoaDonChiTietModel> list = hdctrepo.findByMahoadon(Integer.parseInt(id));
        List<HoaDonChiTietModel> list = hdctrepo.findbymahoadonandmataikhoan(Integer.parseInt(id), Integer.parseInt(session.getAttribute("matk").toString()));
        model.addAttribute("list", list);
        return "/asm/detailbill";
    }

    @RequestMapping("/statistical")
    public String statistical(@RequestParam(required = false, defaultValue = "1-1-2000") String typeDate, Model model) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date parsedDate = sdf.parse(typeDate);


        List<Integer> list = repo.findTopSellingRaum(parsedDate, PageRequest.of(0, 10));

        List<TopSellingRauViewModel> listRauBanChay = new ArrayList<>();
        for (Integer integer : list) {
            RauModel rau = repo.findByMa(integer);
            TopSellingRauViewModel tsl = new TopSellingRauViewModel();
            tsl.setMa(rau.getMa());
            tsl.setTen(rau.getTen());
            tsl.setDongia(rau.getDongia());
            if (rau.isAnsong()) {
                tsl.setAnsong("duoc");
            } else {
                tsl.setAnsong("khong duoc");
            }
            if (rau.getPhanloai() == 0) {
                tsl.setPhanloai("rau");
            } else if (rau.getPhanloai() == 1) {
                tsl.setPhanloai("cu");
            } else {
                tsl.setPhanloai("qua");
            }
            tsl.setTongluongban(repo.findTopQuantity(rau.getMa()));
            listRauBanChay.add(tsl);
        }
        List<RauModel> listkobandc = repo.findTopRauCantSell(parsedDate, PageRequest.of(0, 10));
        model.addAttribute("listRauBanChay", listRauBanChay);
        model.addAttribute("listRauKhongBanDuoc", listkobandc);
        return "/asm/statistical";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        if(request.getSession().getAttribute("matk") != null){
            request.getSession().removeAttribute("matk");
        }
        return "redirect:/asm";
    }
}
