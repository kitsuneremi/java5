package com.example.demo.asm.Repo;

import com.example.demo.asm.Model.HoaDonChiTietModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hoadonchitietrepo")
public interface IHoaDonChiTietRepo extends JpaRepository<HoaDonChiTietModel, Integer> {

    List<HoaDonChiTietModel> findByMahoadon(int mahd);
    List<HoaDonChiTietModel> findByMa(int mahd);

    @Query("select h from hoadonchitiet h where h.mahoadon = :mahoadon and h.hoadon.mataikhoan = :mataikhoan")
    List<HoaDonChiTietModel> findbymahoadonandmataikhoan(int mahoadon, int mataikhoan);
}
