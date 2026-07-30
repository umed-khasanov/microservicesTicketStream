package com.example.microservicesTicketStream;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;



import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private String description;
    @Column (nullable = false)
    private LocalDateTime dateTime;
    @Column (nullable = false)
    private int totalTickets;
    @Column (nullable = false)
    private int availableTickets;

    public Event(){}
}
