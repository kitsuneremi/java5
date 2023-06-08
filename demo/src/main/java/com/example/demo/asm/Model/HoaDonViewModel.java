package com.example.demo.asm.Model;

import java.math.BigDecimal;
import java.util.Date;

public class HoaDonViewModel {

    private int ma;
    private Date ngaytao;

    private BigDecimal tongtien;

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }
}
