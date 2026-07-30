package com.example.microservicesTicketStream.controller;
import com.example.microservicesTicketStream.User;
import com.example.microservicesTicketStream.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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


    }





