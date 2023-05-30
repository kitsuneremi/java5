package com.example.asm.mx.Repo;

import com.example.asm.mx.Model.RauModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRauRepo extends JpaRepository<RauModel, Integer> {

}
