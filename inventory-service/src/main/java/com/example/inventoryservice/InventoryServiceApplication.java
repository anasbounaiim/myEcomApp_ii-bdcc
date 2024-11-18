package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer").price(3200).quantity(11).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Smartphone").price(1200).quantity(25).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Tablet").price(800).quantity(15).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Monitor").price(500).quantity(20).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Keyboard").price(50).quantity(100).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Mouse").price(30).quantity(150).build());
            productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Printer").price(250).quantity(10).build());

            productRepository.findAll().forEach(p -> System.out.println(p.toString()));

        };
    }

}
