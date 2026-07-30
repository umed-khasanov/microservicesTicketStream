package com.example.microservicesTicketStream;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public Event getEventsById(Long id){
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found!!"));

    }

    public Event creatEvent(Event event){
        event.setAvailableTickets(event.getTotalTickets());
        return eventRepository.save(event);
    }
}



