package com.example.demo.lab.Repo;

import com.example.demo.lab.Model.HocSInh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("hocsinhrepo")
@Transactional
public interface IHocSinhRepo extends JpaRepository<HocSInh, Integer> {
    Page<HocSInh> findHocSInhByHanhkiemGreaterThanOrderByHanhkiemDesc(int i,Pageable pab);

    List<HocSInh> findAllByOrderByHanhkiemDesc();

    void deleteByMa(int ma);

    Page<HocSInh> findHocSInhByTenLike(String keyword, Pageable pab);

    Page<HocSInh> findHocSInhByTenContaining(String keyword, Pageable pab);
}
