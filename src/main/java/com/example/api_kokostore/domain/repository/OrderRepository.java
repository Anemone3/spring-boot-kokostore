package com.example.api_kokostore.domain.repository;

import com.example.api_kokostore.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
