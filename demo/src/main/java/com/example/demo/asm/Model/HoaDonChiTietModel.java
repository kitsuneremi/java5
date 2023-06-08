package com.example.demo.asm.Model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity(name = "hoadonchitiet")
@Transactional
public class HoaDonChiTietModel {
    @Id
    @Column
    @GeneratedValue(generator = "0", strategy = GenerationType.IDENTITY)
    private int ma;

    @Column(name = "marau")
    private int marau;

    @Column(name = "mahoadon")
    private int mahoadon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mahoadon", referencedColumnName = "ma", insertable = false, updatable = false)
    private HoaDonModel hoadon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marau", referencedColumnName = "ma", insertable = false, updatable = false)
    private RauModel rau;

    @Column
    private int soluong;

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getMarau() {
        return marau;
    }

    public void setMarau(int marau) {
        this.marau = marau;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

    public HoaDonModel getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDonModel hoadon) {
        this.hoadon = hoadon;
    }

    public RauModel getRau() {
        return rau;
    }

    public void setRau(RauModel rau) {
        this.rau = rau;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
