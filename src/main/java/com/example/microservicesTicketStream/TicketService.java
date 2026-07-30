package com.example.microservicesTicketStream;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final EventService eventService;

    public List<Ticket> getTicketsByUserId(Long userId) {
        return ticketRepository.findByUserId(userId);
    }

    public Ticket createTicketRequest(Long userId, Long eventId, String category) {
        User user = userService.getUserById(userId);

        Event event = eventService.getEventsById(eventId);

        if (event.getAvailableTickets() <= 0) {
            throw new RuntimeException("Error: No tickets left for this event!");
        }

        BigDecimal finalPrice;

        switch (category.toUpperCase()) {
            case "VIP":
                finalPrice = new BigDecimal("150.00");
                break;
            case "LUXURY":
                finalPrice = new BigDecimal("300.00");
                break;
            case "STANDARD":
            default:
                finalPrice = new BigDecimal("50.00");
                break;
        }

        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setPrice(finalPrice);
        ticket.setStatus("PENDING");

        return ticketRepository.save(ticket);
    }
}







