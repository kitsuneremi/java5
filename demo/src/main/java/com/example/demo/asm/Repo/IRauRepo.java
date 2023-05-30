package com.example.demo.asm.Repo;


import com.example.demo.asm.Model.RauModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface IRauRepo extends JpaRepository<RauModel, Integer> {
    void deleteByMa(int ma);
    List<RauModel> findByAnsongIsFalse();

    Page<RauModel> findByTenContains(String kw, Pageable page);

    Page<RauModel> findByDongiaBetween(BigDecimal min, BigDecimal max, Pageable page);

    Page<RauModel> findByTenContainsAndDongiaBetween(String kw, BigDecimal min, BigDecimal max,Pageable page);

    RauModel findByMa(int ma);
}
