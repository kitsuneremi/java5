package com.example.demo.b5.Service;

import com.example.demo.b5.Models.GiangVien;
import com.example.demo.b5.Repo.GiangVienRepo;
import com.example.demo.b5.Repo.IGiangVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GiangVienService implements IGiangVienService{
    @Autowired
    private IGiangVienRepo repo;
    @Override
    public ArrayList<GiangVien> getList() {
        return repo.getList();
    }
}
