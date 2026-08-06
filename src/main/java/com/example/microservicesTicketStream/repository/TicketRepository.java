package com.example.microservicesTicketStream.repository;

import com.example.microservicesTicketStream.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {



    List<Ticket> findByUserId(Long userId);

    @Query(value = "SELECT * FROM tickets t WHERE t.event_id = :eventId", nativeQuery = true)
    List<Ticket> findByEventIdNative(@Param("eventId") Long eventId);

    @Query(value = "SELECT COALESCE(SUM(t.price), 0) FROM tickets t WHERE t.event_id = :eventId", nativeQuery = true)
    BigDecimal calculateTotalRevenueByEventId(@Param("eventId") Long eventId);

    @Query(value = "SELECT COUNT(t.id) FROM tickets t WHERE t.event_id = :eventId AND UPPER(t.category) = UPPER(:category)", nativeQuery = true)
    long countByEventIdAndCategory(@Param("eventId") Long eventId, @Param("category") String category);
}
