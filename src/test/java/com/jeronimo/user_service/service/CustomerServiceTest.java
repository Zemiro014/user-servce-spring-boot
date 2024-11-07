package com.jeronimo.user_service.service;

import com.jeronimo.user_service.domain.Customer;
import com.jeronimo.user_service.repositories.CustomerRepository;
import com.jeronimo.user_service.web.dtoResponse.CustomerResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    void setUp(){
        customer = Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .build();
    }

    @Test
    void testGetCustomerById(){
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        Optional<CustomerResponseDTO> responseDTO = customerService.getCustomerById(1L);
        assertTrue(responseDTO.isPresent());
        assertEquals("John", responseDTO.get().getFirstName());
        assertEquals("Doe", responseDTO.get().getLastName());

        verify(customerRepository, times(1)).findById(1L);
    }
}