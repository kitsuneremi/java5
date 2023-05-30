package com.example.lab34.lab.Models;

import java.util.ArrayList;

public class Bai1Model {

    private String mamon;
    private String tenmon;
    private int stc;
    private int chuyennganh;

    private ArrayList<Integer> giangvien;

    private boolean batbuoc;

    public Bai1Model() {
    }

    public Bai1Model(String mamon, String tenmon, int stc, int chuyennganh, ArrayList<Integer> giangvien, boolean batbuoc) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.stc = stc;
        this.chuyennganh = chuyennganh;
        this.giangvien = giangvien;
        this.batbuoc = batbuoc;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getStc() {
        return stc;
    }

    public void setStc(int stc) {
        this.stc = stc;
    }

    public int getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(int chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public ArrayList<Integer> getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(ArrayList<Integer> giangvien) {
        this.giangvien = giangvien;
    }

    public boolean isBatbuoc() {
        return batbuoc;
    }

    public void setBatbuoc(boolean batbuoc) {
        this.batbuoc = batbuoc;
    }
}
