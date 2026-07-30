package com.example.microservicesTicketStream.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketPaymentDTO {
    private Long userId;
    private Long eventId;
    private String category;
}

