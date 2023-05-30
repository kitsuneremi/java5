package com.example.demo.b5.Repo;

import com.example.demo.b5.Models.GiangVien;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class GiangVienRepo implements IGiangVienRepo{
    private static ArrayList<GiangVien> danhsachgiangvien = new ArrayList<>();
    static {
        danhsachgiangvien.add(new GiangVien("gv1", "name 1", 1999));
        danhsachgiangvien.add(new GiangVien("gv2", "name 2", 1456));
        danhsachgiangvien.add(new GiangVien("gv3", "name 3", 1123));
        danhsachgiangvien.add(new GiangVien("gv4", "name 4", 1745));

    }


    @Override
    public ArrayList<GiangVien> getList() {
        return danhsachgiangvien;
    }
}
