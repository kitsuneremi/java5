package com.example.demo.asm.Repo;


import com.example.demo.asm.Model.RauModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository("raurepo")
@Transactional
public interface IRauRepo extends JpaRepository<RauModel, Integer> {
    void deleteByMa(int ma);
    List<RauModel> findByAnsongIsFalse();

    Page<RauModel> findByTenContains(String kw, Pageable page);

    Page<RauModel> findByDongiaBetween(BigDecimal min, BigDecimal max, Pageable page);

    Page<RauModel> findByTenContainsAndDongiaBetween(String kw, BigDecimal min, BigDecimal max,Pageable page);


    RauModel findByMa(int ma);

    @Query("select h.rau.ma from hoadonchitiet h where h.hoadon.ngaymua >= :startDate group by h.rau.ma order by SUM(h.soluong) desc")
    List<Integer> findTopSellingRaum(@Param("startDate") Date startDate, Pageable pageable);

    @Query("select sum(h.soluong) from hoadonchitiet h where h.marau = :ma")
    Integer findTopQuantity(@Param("ma") int marau);

    @Query("SELECT r FROM rau r WHERE r.ma NOT IN (SELECT h.marau FROM hoadonchitiet h WHERE h.hoadon.ngaymua >= :startDate) ORDER BY r.ma asc")
    List<RauModel> findTopRauCantSell(@Param("startDate") Date startDate, Pageable pageable);



}
