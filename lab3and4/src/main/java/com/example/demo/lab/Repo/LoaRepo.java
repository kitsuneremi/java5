package com.example.demo.lab.Repo;

import com.example.demo.lab.Models.Loa;
import com.example.demo.lab.Service.LoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class LoaRepo implements ILoaRepo{
    private static final ArrayList<Loa> list = new ArrayList<>();
    static {
        list.add(new Loa("ma loa 1", "ten loa 1", 1000, 0, 2000));
        list.add(new Loa("ma loa 2", "ten loa 2", 2000, 1, 2400));
        list.add(new Loa("ma loa 3", "ten loa 3", 3000, 2, 2200));
        list.add(new Loa("ma loa 4", "ten loa 4", 4000, 3, 2700));
        list.add(new Loa("ma loa 5", "ten loa 5", 5000, 4, 900));

    }

    @Override
    public ArrayList<Loa> getList() {
        return list;
    }
}
