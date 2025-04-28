package com.example.api_kokostore.config.seeders;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.api_kokostore.domain.entities.PaymentEntity;
import com.example.api_kokostore.domain.enums.PaymentEnum;
import com.example.api_kokostore.domain.repository.PaymentRepository;

@Component
@Profile("dev")
@Order(2)
public class PaymentMethodSeeder implements CommandLineRunner {

    private final PaymentRepository repository;

    public PaymentMethodSeeder(PaymentRepository paymentMethodRepository) {
        this.repository = paymentMethodRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) { // Solo se ejecuta si la tabla está vacía
            repository.saveAll(List.of(
                    new PaymentEntity(PaymentEnum.OTHER),
                    new PaymentEntity(PaymentEnum.PAYPAL),
                    new PaymentEntity(PaymentEnum.STRIPE)));
            System.out.println("Payment methods seeded successfully!");
        } else {
            System.out.println("Payment methods already exist. Skipping seeding.");
        }
    }

}
