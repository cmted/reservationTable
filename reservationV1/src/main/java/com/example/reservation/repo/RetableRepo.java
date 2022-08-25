package com.example.reservation.repo;

import com.example.reservation.pojo.Retable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RetableRepo extends JpaRepository<Retable,Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Retable r where r.tableId = ?1")
    void deleteByTableId(Integer id);

    @Query(value = "SELECT r.tableNum  From Retable r")
    List<String> findTableNum();

    @Query(value = "SELECT count(r) FROM Retable r")
    Integer countTable();
}
