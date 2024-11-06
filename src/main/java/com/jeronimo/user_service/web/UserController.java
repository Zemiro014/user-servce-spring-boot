package com.jeronimo.user_service.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @GetMapping("test")
    public ResponseEntity<String> testOk() {
        return ResponseEntity.ok("Tudo OK");
    }
}
