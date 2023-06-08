package com.example.demo.asm.Repo;

import com.example.demo.asm.Model.GioHangChiTietModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository("ghrepo")
@Transactional
public interface IGioHangRepo extends JpaRepository<GioHangChiTietModel, Integer> {
    GioHangChiTietModel findByMarauAndMataikhoan(int marau, int mataikhoan);
    void  deleteByMarauAndMataikhoan(int marau, int mataikhoan);

    void deleteByMataikhoan(int matk);

    List<GioHangChiTietModel> findByMataikhoan(int matk);
}
