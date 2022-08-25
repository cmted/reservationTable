package com.example.reservation.repo;

import com.example.reservation.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT c from Customer c where c.email = ?1")
    Optional<Customer> findByEmail(String email);

    @Query(value = "delete FROM Customer c where c.email = ?1")
    @Modifying
    @Transactional
    void deleteByEmail(String email);

}
