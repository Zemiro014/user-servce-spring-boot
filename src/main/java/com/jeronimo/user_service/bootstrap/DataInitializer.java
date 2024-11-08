package com.jeronimo.user_service.bootstrap;

import com.jeronimo.user_service.domain.Customer;
import com.jeronimo.user_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap Start");

        Customer customer = Customer.builder()
                .firstName("Son")
                .lastName("John")
                .build();
        Customer save = customerRepository.save(customer);
        System.out.println("Saved Customer version: "+save.getVersion());
    }
}
