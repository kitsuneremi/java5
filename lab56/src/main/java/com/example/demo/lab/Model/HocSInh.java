package com.example.demo.lab.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "hocsinh")
public class HocSInh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "1")
    private int ma;

    private String ten;

    private int lop;

    private float tbm;

    private int hanhkiem;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public float getTbm() {
        return tbm;
    }

    public void setTbm(float tbm) {
        this.tbm = tbm;
    }

    public int getHanhkiem() {
        return hanhkiem;
    }

    public void setHanhkiem(int hanhkiem) {
        this.hanhkiem = hanhkiem;
    }
}
