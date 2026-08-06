package com.example.microservicesTicketStream.repository;

import com.example.microservicesTicketStream.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName (String firstname);

    List<User> findBylastName(String lastName);

    Optional<User> findByEmail(String email);


}

