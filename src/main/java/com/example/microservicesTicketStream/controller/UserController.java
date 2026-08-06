package com.example.microservicesTicketStream.controller;
import com.example.microservicesTicketStream.dto.UserLoginDTO;
import com.example.microservicesTicketStream.entity.User;
import com.example.microservicesTicketStream.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;

    @GetMapping("/add-user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginDTO loginDTO) {
        String token = userService.login(loginDTO.getEmail(), loginDTO.getPassword());

        return ResponseEntity.ok(token);
    }



    }





