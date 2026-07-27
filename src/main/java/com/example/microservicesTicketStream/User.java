package com.example.microservicesTicketStream;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(name = "user_email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", unique = true, nullable = false)
    @Pattern(
            regexp = "^\\+353(83|85|87|89)\\d{7}$",
            message = "Invalid Irish mobile number format"
    )
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
