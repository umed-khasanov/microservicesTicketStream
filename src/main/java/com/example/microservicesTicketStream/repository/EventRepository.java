package com.example.microservicesTicketStream.repository;

import com.example.microservicesTicketStream.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {
    Long id(long id);
}
