package com.example.demo.lab.Model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

@Entity(name = "tv")
@Transactional
public class Tivi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "0")
    private int id;

    @Column
    private String ten;
    @Column
    private String nsx;

    @Column
    private int kichco;
    @Column
    private String dophangiai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public int getKichco() {
        return kichco;
    }

    public void setKichco(int kichco) {
        this.kichco = kichco;
    }

    public String getDophangiai() {
        return dophangiai;
    }

    public void setDophangiai(String dophangiai) {
        this.dophangiai = dophangiai;
    }
}
