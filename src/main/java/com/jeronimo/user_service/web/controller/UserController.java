package com.jeronimo.user_service.web.controller;

import com.jeronimo.user_service.service.CustomerService;
import com.jeronimo.user_service.web.dtoRequest.CustomerRequestDTO;
import com.jeronimo.user_service.web.dtoResponse.CustomerResponseDTO;

import org.slf4j.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
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
        logger.info("UserController.getCustomerByIs Start. Customer ID: {}", id);
        return ResponseEntity.ok(customerService.getCustomerById(id).orElseThrow());
    }

    @GetMapping("customer/all")
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomer(){
        logger.info("UserController.getAllCustomer Start.");
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping("customer")
    public ResponseEntity<Void> createNewCustomer(@RequestBody() CustomerRequestDTO requestDTO){
        customerService.createNewCustomer(requestDTO);
        return ResponseEntity.created(URI.create("")).build();
    }
}
