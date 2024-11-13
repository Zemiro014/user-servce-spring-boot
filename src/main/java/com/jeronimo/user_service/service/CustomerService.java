package com.jeronimo.user_service.service;

import com.jeronimo.user_service.domain.Customer;
import com.jeronimo.user_service.repositories.CustomerRepository;
import com.jeronimo.user_service.web.dtoResponse.CustomerResponseDTO;
import com.jeronimo.user_service.web.dtoRequest.CustomerRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerResponseDTO> getCustomerById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow();
        logger.info("Customer from DB: {}", customer);
        CustomerResponseDTO responseDTO = CustomerResponseDTO.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
        logger.info("CustomerResponseDTO: {}", responseDTO);
        return Optional.of(responseDTO);
    }

    public List<CustomerResponseDTO> getAllCustomer() {
        List<CustomerResponseDTO> list = customerRepository.findAll()
                .stream()
                .map(customer -> new CustomerResponseDTO(customer.getFirstName(), customer.getLastName()))
                .toList();
        logger.info("All Customer Response: {}", list);
        return list;
    }

    public CustomerResponseDTO createNewCustomer(CustomerRequestDTO requestDTO) {
        Customer customer = customerRepository.save(Customer.builder()
                .firstName(requestDTO.getFirstName())
                .lastName(requestDTO.getLastName())
                .build());
        logger.info("New Customer: {}", customer);
        return CustomerResponseDTO.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .build();
    }
}
