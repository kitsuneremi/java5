package com.example.demo.lab.Service;

import com.example.demo.lab.Models.Loa;
import com.example.demo.lab.Repo.LoaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoaService implements ILoaService{
    @Autowired
    private LoaRepo repo;
    @Override
    public ArrayList<Loa> getList() {
        return repo.getList();
    }
}
