package com.example.microservicesTicketStream.controller;

import com.example.microservicesTicketStream.Ticket;
import com.example.microservicesTicketStream.TicketService;
import com.example.microservicesTicketStream.dto.TicketPaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor

public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody TicketPaymentDTO dto) {
        return ticketService.createTicketRequest(dto.getUserId(), dto.getEventId(), dto.getCategory());
    }

    @GetMapping("/user/{userId}")
    public List<Ticket> getTicketsUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUserId(userId);
    }


}
