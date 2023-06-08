package com.example.demo.asm.Model;


import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity(name = "giohangchitiet")
@Transactional
public class GioHangChiTietModel {

    @Id
    @Column(name = "ma")
    @GeneratedValue(generator = "0", strategy = GenerationType.IDENTITY)
    private int ma;

    @Column(name = "mataikhoan")
    private int mataikhoan;

    @Column(name = "soluong")
    private int soluong;

    @Column(name = "marau")
    private int marau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mataikhoan", referencedColumnName = "ma", insertable = false, updatable = false)
    private TaiKhoanModel taikhoan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marau", referencedColumnName = "ma", insertable = false, updatable = false)
    private RauModel rau;

    public GioHangChiTietModel() {
    }

    public GioHangChiTietModel(int soluong, RauModel rau, TaiKhoanModel taikhoan) {
        this.soluong = soluong;
        this.rau = rau;
        this.taikhoan = taikhoan;
    }

    public GioHangChiTietModel(int mataikhoan, int soluong, int marau) {
        this.mataikhoan = mataikhoan;
        this.soluong = soluong;
        this.marau = marau;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public RauModel getRau() {
        return rau;
    }

    public void setRau(RauModel rau) {
        this.rau = rau;
    }

    public TaiKhoanModel getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(TaiKhoanModel taikhoan) {
        this.taikhoan = taikhoan;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public int getMarau() {
        return marau;
    }

    public void setMarau(int marau) {
        this.marau = marau;
    }
}
