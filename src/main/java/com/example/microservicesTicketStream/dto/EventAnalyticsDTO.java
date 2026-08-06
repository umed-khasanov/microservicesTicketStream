package com.example.microservicesTicketStream.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventAnalyticsDTO {
    private Long eventId;
    private String eventName;

    // Финансовые метрики
    private BigDecimal totalRevenue;
    private BigDecimal averageTicketPrice;

    // Количественные метрики
    private long totalTicketsSold;
    private long vipTicketsSold;
    private long luxuryTicketsSold;
    private long standardTicketsSold;

    // Метрика заполняемости стадиона в %
    private double capacityUtilizationPercentage;
}

