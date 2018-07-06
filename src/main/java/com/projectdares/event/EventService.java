package com.projectdares.event;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event joinEvent(String userId, String eventId) {
        Event event = getEventById(eventId);
        User user = new User(userId);
        event.addParticipant(user);
        return eventRepository.save(event);
    }

    public Event leaveEvent(String userId, String eventId) {
        Event event = getEventById(eventId);
        User user = new User(userId);
        event.removeParticipant(user);
        return eventRepository.save(event);
    }

    private Event getEventById(String eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Wrong event id"));
    }
}
