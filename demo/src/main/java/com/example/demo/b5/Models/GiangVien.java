package com.example.demo.b5.Models;

public class GiangVien {

    private String id;
    private String name;
    private int namSinh;

    public GiangVien() {
    }

    public GiangVien(String id, String name, int namSinh) {
        this.id = id;
        this.name = name;
        this.namSinh = namSinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
}
