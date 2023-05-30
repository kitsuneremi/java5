package com.example.demo.b5.Models;

public class Loa {

    private String maloa;
    private String tenloa;
    private int congsuat;
    private int mausac;
    private int kenhamthanh;


    public Loa() {
    }

    public Loa(String maloa, String tenloa, int congsuat, int mausac, int kenhamthanh) {
        this.maloa = maloa;
        this.tenloa = tenloa;
        this.congsuat = congsuat;
        this.mausac = mausac;
        this.kenhamthanh = kenhamthanh;
    }

    public String getMaloa() {
        return maloa;
    }

    public void setMaloa(String maloa) {
        this.maloa = maloa;
    }

    public String getTenloa() {
        return tenloa;
    }

    public void setTenloa(String tenloa) {
        this.tenloa = tenloa;
    }

    public int getCongsuat() {
        return congsuat;
    }

    public void setCongsuat(int congsuat) {
        this.congsuat = congsuat;
    }

    public int getMausac() {
        return mausac;
    }

    public void setMausac(int mausac) {
        this.mausac = mausac;
    }

    public int getKenhamthanh() {
        return kenhamthanh;
    }

    public void setKenhamthanh(int kenhamthanh) {
        this.kenhamthanh = kenhamthanh;
    }
}
