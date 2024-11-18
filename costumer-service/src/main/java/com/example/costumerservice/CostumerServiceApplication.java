package com.example.costumerservice;

import com.example.costumerservice.entities.Customer;
import com.example.costumerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CostumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder().name("Mohamed").email("med@gmail.com").build());
            customerRepository.save(Customer.builder().name("Imane").email("imane@gmail.com").build());
            customerRepository.save(Customer.builder().name("Ahmed").email("ahmed@gmail.com").build());
            customerRepository.save(Customer.builder().name("Fatima").email("fatima@gmail.com").build());
            customerRepository.save(Customer.builder().name("Sara").email("sara@gmail.com").build());

            customerRepository.findAll().forEach(c -> {
                System.out.println("=====================");
                System.out.println("ID: " + c.getId());
                System.out.println("Name: " + c.getName());
                System.out.println("Email: " + c.getEmail());
                System.out.println("=====================");
            });
        };
    }


}
