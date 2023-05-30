package com.example.demo.lab.Service;

import com.example.demo.lab.Models.Bai1Model;
import com.example.demo.lab.Repo.Bai1Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Bai1Service implements Ibai1Service{

    @Autowired
    private Bai1Repo repo;
    @Override
    public ArrayList<Bai1Model> getList() {
        return repo.getList();
    }


}
