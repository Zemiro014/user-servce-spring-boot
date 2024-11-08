package com.jeronimo.user_service.repositories;

import com.jeronimo.user_service.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@ActiveProfiles("local")
//@DataJpaTest
//@AutoConfigureTestDatabase( replace = AutoConfigureTestDatabase.Replace.NONE)
//@Import(CustomerRepository.class)
@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void getAllCustomers(){
        List<Customer> allCustomers = customerRepository.findAll();
        assertThat(allCustomers).isNotNull();
    }
}