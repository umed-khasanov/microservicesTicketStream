package com.example.microservicesTicketStream.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserLoginDTO {
    @NotBlank(message = "Email field must not be empty")
    @Email(message = " Please provide a valid email")
    private String email;

    @NotBlank(message = "Password field must not be empty")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]).+$",
            message = "Password must contain at least one uppercase letter, one number, and one special character"

    )
    private String password;

}
