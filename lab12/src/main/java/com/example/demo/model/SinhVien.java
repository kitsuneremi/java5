package com.example.demo.model;

public class SinhVien {

    private String namex;
    private int gioitinh;
    private int chuyenNganh;

    public SinhVien() {
    }

    public SinhVien(String namex, int gioitinh, int chuyenNganh) {
        this.namex = namex;
        this.gioitinh = gioitinh;
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamex() {
        return namex;
    }

    public void setName(String namex) {
        this.namex = namex;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(int chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
}
