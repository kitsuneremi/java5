package com.example.demo.b4;

import java.util.HashMap;
import java.util.Map;

public class Giohang {
    private Map<Product, Integer> listproduct = new HashMap<>();

    public Map<Product, Integer> getListproduct() {
        return listproduct;
    }

    public void setListproduct(Map<Product, Integer> listproduct) {
        this.listproduct = listproduct;
    }
}
