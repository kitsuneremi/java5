package com.example.demo.asm.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "rau")
public class RauModel {
    @Id
    @GeneratedValue(generator = "0", strategy = GenerationType.IDENTITY)
    @Column(name = "ma")
    private int ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "soluong")
    private int soluong;

    @Column(name = "dongia")
    private BigDecimal dongia;

    @Column(name = "ansong")
    private boolean ansong;

    @Column(name = "phanloai")
    private int phanloai;
    public RauModel() {
    }

    public RauModel(int ma, String ten, int soluong, BigDecimal dongia, boolean ansong, int phanloai) {
        this.ma = ma;
        this.ten = ten;
        this.soluong = soluong;
        this.dongia = dongia;
        this.ansong = ansong;
        this.phanloai = phanloai;
    }

    public Integer getMa() {
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

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public boolean isAnsong() {
        return ansong;
    }

    public void setAnsong(boolean ansong) {
        this.ansong = ansong;
    }

    public int getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(int phanloai) {
        this.phanloai = phanloai;
    }
}
