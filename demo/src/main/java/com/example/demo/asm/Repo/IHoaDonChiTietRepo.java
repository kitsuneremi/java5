package com.example.demo.asm.Repo;

import com.example.demo.asm.Model.HoaDonChiTietModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hoadonchitietrepo")
public interface IHoaDonChiTietRepo extends JpaRepository<HoaDonChiTietModel, Integer> {

    List<HoaDonChiTietModel> findByMahoadon(int mahd);
    List<HoaDonChiTietModel> findByMa(int mahd);

}
