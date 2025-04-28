package com.example.api_kokostore.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_kokostore.domain.entities.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
    // Custom query methods can be defined here if needed

}
