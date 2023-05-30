package com.example.asm.mx.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name = "rau")
public class RauModel {
    @Id
    @GeneratedValue
    private int ma;

    private String ten;

    private int soluong;

    private BigDecimal dongia;

    private boolean ansong;
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
