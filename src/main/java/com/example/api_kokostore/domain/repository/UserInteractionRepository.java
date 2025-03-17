package com.example.api_kokostore.domain.repository;

import com.example.api_kokostore.domain.entities.UserInteractionLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInteractionRepository extends JpaRepository<UserInteractionLogEntity,Long> {
}
