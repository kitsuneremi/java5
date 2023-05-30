package com.example.lab34.lab.Repo;


import com.example.lab34.lab.Models.Bai1Model;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class Bai1Repo implements Ibai1Repo{

    public final static ArrayList<Bai1Model> list = new ArrayList<>();
    static {
        Bai1Model x = new Bai1Model();
        x.setBatbuoc(false);
        x.setChuyennganh(2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        x.setGiangvien(b);
        x.setChuyennganh(3);
        x.setMamon("mamon1");
        x.setTenmon("tenmon1");
        list.add(x);
    }

    @Override
    public ArrayList<Bai1Model> getList() {
        return list;
    }
}
