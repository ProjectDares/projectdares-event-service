package com.projectdares.event;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @PutMapping("/event/{eventId}/join")
    public Event joinEvent(@PathVariable String eventId, String userId) {
        return eventService.joinEvent(userId, eventId);
    }

    @PutMapping("/event/{eventId}/leave")
    public Event leaveEvent(@PathVariable String eventId, String userId) {
        return eventService.leaveEvent(userId, eventId);
    }
}
