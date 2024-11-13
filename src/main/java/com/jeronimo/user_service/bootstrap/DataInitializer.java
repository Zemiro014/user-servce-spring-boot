package com.jeronimo.user_service.bootstrap;

import com.jeronimo.user_service.domain.Customer;
import com.jeronimo.user_service.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class DataInitializer implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        logger.info("DataInitializer Start");

        Customer customer = Customer.builder()
                .firstName("Son")
                .lastName("John")
                .build();
        Customer save = customerRepository.save(customer);
        logger.info("Saved Customer: {}",save);
    }
}
