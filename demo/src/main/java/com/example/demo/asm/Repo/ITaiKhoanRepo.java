package com.example.demo.asm.Repo;

import com.example.demo.asm.Model.TaiKhoanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("taikhoanrepo")
public interface ITaiKhoanRepo extends JpaRepository<TaiKhoanModel, Integer> {

    TaiKhoanModel findByMa(int ma);
    TaiKhoanModel findByTendangnhapAndMatkhau(String username, String password);

    Boolean existsByTendangnhap(String username);

    Boolean existsByEmail(String email);
}
