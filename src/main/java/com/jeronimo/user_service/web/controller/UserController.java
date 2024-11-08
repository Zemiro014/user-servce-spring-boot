package com.jeronimo.user_service.web.controller;

import com.jeronimo.user_service.service.CustomerService;
import com.jeronimo.user_service.web.dtoResponse.CustomerResponseDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final CustomerService customerService;

    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("test")
    public ResponseEntity<String> testOk() {
        return ResponseEntity.ok("Tudo OK");
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByIs(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id).orElseThrow());
    }

    @GetMapping("customer/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
}
