package com.example.api_kokostore.config.seeders;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.api_kokostore.application.dto.product.CreateProductDto;
import com.example.api_kokostore.application.service.ProductService;

@Component
@Profile("dev") // @Profile("dev") annotation indicates that this class should only be loaded in
@Order(1)
public class ProductSeeder implements CommandLineRunner {

        private final ProductService service;

        public ProductSeeder(ProductService service) {
                this.service = service;
        }

        @Override
        public void run(String... args) throws Exception {

                List<CreateProductDto> products = List.of(
                                new CreateProductDto(
                                                "Smartphone flagship con cámara de 108MP",
                                                "Smartphone X9",
                                                "https://example.com/images/x9.jpg",
                                                799.99,
                                                "SMARTPH-X9-2024",
                                                "Electrónicos"),
                                new CreateProductDto(
                                                "Camiseta de algodón 100% talla M",
                                                "Camiseta Básica Blanca",
                                                "https://example.com/images/tshirt.jpg",
                                                19.99,
                                                "APPAREL-TS-BLA",
                                                "Ropa"),
                                new CreateProductDto(
                                                "Audífonos inalámbricos con cancelación de ruido",
                                                "Audífonos Pro Z",
                                                "https://example.com/images/earbuds.jpg",
                                                249.95,
                                                "AUDIO-PROZ-2024",
                                                "Accesorios"),
                                new CreateProductDto(
                                                "Libro de ciencia ficción bestseller",
                                                "La Galaxia Perdida",
                                                "https://example.com/images/book.jpg",
                                                14.99,
                                                "BOOK-SCIFI-025",
                                                "Libros"),
                                new CreateProductDto(
                                                "Smartwatch con monitor de ritmo cardíaco",
                                                "Reloj Inteligente V10",
                                                "https://example.com/images/smartwatch.jpg",
                                                159.50,
                                                "WEARABLE-V10-S",
                                                "Tecnología"));

                products.forEach(product -> {
                        boolean exists = service.listProduct().stream()
                                        .anyMatch(p -> p.getSku().equals(product.sku()));
                        if (!exists) {
                                service.saveProduct(product);
                        }
                });

                System.out.println("Database seeded with initial products.");
        }

}
