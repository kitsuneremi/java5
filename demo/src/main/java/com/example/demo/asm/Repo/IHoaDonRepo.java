package com.example.demo.asm.Repo;

import com.example.demo.asm.Model.HoaDonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("hoadonrepo")
public interface IHoaDonRepo extends JpaRepository<HoaDonModel, Integer> {
    int countByMataikhoan(int matk);

    List<HoaDonModel> findByMataikhoan(String matk);
}
