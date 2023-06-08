package com.example.demo.lab.Repo;

import com.example.demo.lab.Model.Tivi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITiviRepo extends JpaRepository<Tivi, Integer> {
    Page<Tivi> findByTenContains(String keyword, Pageable pab);
    Tivi findById(int id);
}
