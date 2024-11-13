package com.jeronimo.user_service.web.dtoRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CustomerRequestDTO implements Serializable {
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "CustomerRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
