package com.example.api_kokostore.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_interaction_log")
public class UserInteractionLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String httpMethod;

    @Column(columnDefinition = "TEXT")
    private String requestUri;

    private String username;

    private LocalDateTime timestamp;

    private String remoteAddress;


    public UserInteractionLogEntity() {}

    public UserInteractionLogEntity(Long id, String httpMethod, String requestUri, String username, LocalDateTime timestamp, String remoteAddress) {
        this.id = id;
        this.httpMethod = httpMethod;
        this.requestUri = requestUri;
        this.username = username;
        this.timestamp = timestamp;
        this.remoteAddress = remoteAddress;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
