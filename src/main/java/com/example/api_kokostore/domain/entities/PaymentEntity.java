package com.example.api_kokostore.domain.entities;

import com.example.api_kokostore.domain.enums.PaymentEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentEnum method;

    public PaymentEntity() {
    }

    public PaymentEntity(int id, PaymentEnum method) {
        this.id = id;
        this.method = method;
    }

    public PaymentEntity(PaymentEnum method) {
        this.method = method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentEnum getMethod() {
        return method;
    }

    public void setMethod(PaymentEnum method) {
        this.method = method;
    }

}
