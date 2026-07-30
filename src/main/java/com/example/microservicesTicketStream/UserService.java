package com.example.microservicesTicketStream;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User with ID " + id + " not found"));
    }

    public User createUser(User user) {
        // Проверка бизнес-логики: email должен быть уникальным
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Error: User with this email already exists!");
        }

        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            user.setRole("CUSTOMER");
        }
        return userRepository.save(user);
    }
}
