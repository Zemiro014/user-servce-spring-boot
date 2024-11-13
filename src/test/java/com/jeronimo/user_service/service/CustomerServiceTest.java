package com.jeronimo.user_service.service;

import com.jeronimo.user_service.domain.Customer;
import com.jeronimo.user_service.repositories.CustomerRepository;
import com.jeronimo.user_service.web.dtoRequest.CustomerRequestDTO;
import com.jeronimo.user_service.web.dtoResponse.CustomerResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void testGetAllCustomer(){
        when(customerRepository.findAll()).thenReturn(buildListOfCustomer());
        List<CustomerResponseDTO> customers = customerService.getAllCustomer();
        assertEquals(customers.size(), 2);

        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void createNewCustomer(){
        CustomerRequestDTO requestDTO = CustomerRequestDTO.builder()
                .firstName("First Name")
                .lastName("Second Name")
                .build();
        when(customerRepository.save(any())).thenReturn(buildListOfCustomer().get(1));
        CustomerResponseDTO responseDTO = customerService.createNewCustomer(requestDTO);

        assertNotNull(responseDTO);
        assertEquals("First Name", responseDTO.getFirstName());
        assertEquals("Second Name", responseDTO.getLastName());

        verify(customerRepository, times(1)).save(any());
    }

    private List<Customer> buildListOfCustomer() {
        Customer customer1 = new Customer();
        customer1.setId(2L);
        customer1.setVersion(1L);
        customer1.setFirstName("First Name");
        customer1.setLastName("Second Name");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setVersion(1L);
        customer2.setFirstName("First Name");
        customer2.setLastName("Second Name");
        return Arrays.asList(customer1, customer2);
    }
}