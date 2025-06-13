package com.example.borrow.repository;


import com.example.borrow.Entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface Repository extends JpaRepository<Borrow, Long> {
}
