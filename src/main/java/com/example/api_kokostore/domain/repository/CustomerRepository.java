package com.example.api_kokostore.domain.repository;
import com.example.api_kokostore.domain.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
    Optional<CustomerEntity> findByUserId(UUID userId);

}
