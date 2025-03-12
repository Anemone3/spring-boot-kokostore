package com.example.api_kokostore.domain.model;


import com.example.api_kokostore.domain.enums.AuthProviderEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(nullable = false, length = 30)
    private String username;

    @Column(length = 100,nullable = false,unique = true)
    private String email;

    @Column(nullable = true, length = 30)
    private String password;

    @Column(nullable = false,columnDefinition = "boolean default true",name = "is_active")
    private boolean isActive = true;


    @Column(nullable = true, length = 255)
    private String profileImage;

    @Enumerated(EnumType.STRING)
    @Column(length = 20,nullable = false)
    private AuthProviderEnum provider;


    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
