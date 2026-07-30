package com.example.microservicesTicketStream;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Получить список всех пользователей системы (Для админ-панели статистики)
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Найти пользователя по его уникальному ID
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: User with ID " + id + " not found"));
    }

    /**
     * Создать и зарегистрировать нового пользователя
     */
    public User createUser(User user) {
        // Проверка бизнес-логики: email должен быть уникальным
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Error: User with this email already exists!");
        }

        // Защита системы: если роль не передана с фронтенда, принудительно ставим "CUSTOMER"
        if (user.getRole() == null || user.getRole().trim().isEmpty()) {
            user.setRole("CUSTOMER");
        }

        // Сохраняем чистый, провалидированный объект в базу данных PostgreSQL
        return userRepository.save(user);
    }
}
