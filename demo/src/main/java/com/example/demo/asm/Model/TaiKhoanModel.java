package com.example.demo.asm.Model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Entity(name = "taikhoan")
@Transactional
public class TaiKhoanModel {
    @Id
    @GeneratedValue(generator = "0", strategy = GenerationType.IDENTITY)
    @Column(name = "ma")
    private int ma;

    @Column(name = "tendangnhap")
    private String tendangnhap;

    @Column(name = "matkhau")
    private String matkhau;

    @Column
    private String email;

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(int ma, String tendangnhap, String matkhau, String email) {
        this.ma = ma;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.email = email;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
