package com.example.api_kokostore.domain.repository;

import com.example.api_kokostore.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailOrUsername(String email, String username);
}
