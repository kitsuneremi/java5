package com.example.demo.asm.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "rau")
@SequenceGenerator(name = "rau_seq", sequenceName = "rau_seq", allocationSize = 1)
public class RauModel {
    @Id
    @GeneratedValue(generator = "0", strategy = GenerationType.IDENTITY)
    private int ma;
    @Column
    private String ten;
    @Column
    private int soluong;
    @Column
    private BigDecimal dongia;
    @Column
    private boolean ansong;
    @Column
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
