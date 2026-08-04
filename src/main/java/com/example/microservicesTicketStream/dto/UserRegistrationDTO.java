package com.example.microservicesTicketStream.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRegistrationDTO {
    @NotBlank(message = "Name field must not be empty")
    private String firstName;

    @NotBlank(message = "Last Name field must not be empty")
    private String lastName;

    @NotBlank(message = "Email field must not be empty")
    @Email(message = " Please provide a valid email")
    private String email;

    @NotBlank(message = "Password field must not be empty")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]).+$",
            message = "Password must contain at least one uppercase letter, one number, and one special character"
    )
    private String password;

    @NotBlank(message = "Phone Number field must not be empty")

    @Pattern(
            regexp = "^\\+353(83|85|87|89)\\d{7}$",
            message = "Invalid Irish mobile number format"
    )
    private String phoneNumber;

    private LocalDate dateOfBirth;
}
