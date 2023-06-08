package com.example.demo.asm.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "hoadon")
public class HoaDonModel {
    @Id
    @GeneratedValue(generator = "0", strategy = GenerationType.IDENTITY)
    private int ma;

    @Column
    private int mataikhoan;

    @Column
    private Date ngaymua;

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

    public Date getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

}
