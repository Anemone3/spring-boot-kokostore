package com.example.api_kokostore.domain.repository;

import com.example.api_kokostore.domain.entities.DetailOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailOrderRepository extends JpaRepository<DetailOrderEntity,Long> {
}
