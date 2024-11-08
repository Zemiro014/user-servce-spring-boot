package com.jeronimo.user_service.service;

import com.jeronimo.user_service.domain.Customer;
import com.jeronimo.user_service.repositories.CustomerRepository;
import com.jeronimo.user_service.web.dtoResponse.CustomerResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerResponseDTO> getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        CustomerResponseDTO responseDTO = CustomerResponseDTO.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
        return Optional.of(responseDTO);
    }

    public List<CustomerResponseDTO> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> new CustomerResponseDTO(customer.getFirstName(), customer.getLastName())).toList();
    }
}
