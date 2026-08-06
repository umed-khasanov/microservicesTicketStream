package com.example.microservicesTicketStream.service;

import com.example.microservicesTicketStream.dto.EventAnalyticsDTO;
import com.example.microservicesTicketStream.entity.Event;
import com.example.microservicesTicketStream.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final TicketRepository ticketRepository;
    private final EventService eventService;

    public EventAnalyticsDTO getEventFinancialAnalytics(Long eventId) {
        Event event = eventService.getEventsById(eventId);

        BigDecimal totalRevenue = ticketRepository.calculateTotalRevenueByEventId(eventId);

        long vipSold = ticketRepository.countByEventIdAndCategory(eventId, "VIP");
        long luxurySold = ticketRepository.countByEventIdAndCategory(eventId, "LUXURY");
        long standardSold = ticketRepository.countByEventIdAndCategory(eventId, "STANDARD");

        long totalTicketsSold = vipSold + luxurySold + standardSold;

        BigDecimal averageTicketPrice = BigDecimal.ZERO;
        if (totalTicketsSold > 0) {
            averageTicketPrice = totalRevenue.divide(
                    BigDecimal.valueOf(totalTicketsSold),
                    2,
                    RoundingMode.HALF_UP
            );
        }

        double capacityUtilization = 0.0;
        if (event.getTotalTickets() > 0) {
            capacityUtilization = ((double) totalTicketsSold / event.getTotalTickets()) * 100.0;
            capacityUtilization = Math.round(capacityUtilization * 100.0) / 100.0;
        }

        return new EventAnalyticsDTO(
                eventId,
                event.getTitle(),
                totalRevenue,
                averageTicketPrice,
                totalTicketsSold,
                vipSold,
                luxurySold,
                standardSold,
                capacityUtilization
        );
    }
}
