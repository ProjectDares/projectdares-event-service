package com.projectdares.event;

import java.time.Instant;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
@Getter @Setter
public class Event {

    @Id
    private String id;

    private String sport;

    private LocalDateTime dateTime;

    private String name;

    private int minParticipants = 2;

    private GeoJsonPoint location;

    private Instant created;

    public Event(String sport, LocalDateTime dateTime, int minParticipants, GeoJsonPoint location) {
        this(sport, dateTime, sport + ": " + location.toString() + ", " + dateTime.toString(), minParticipants, location);
    }

    public Event(String sport, LocalDateTime dateTime, String name, int minParticipants, GeoJsonPoint location) {
        this.sport = sport;
        this.dateTime = dateTime;
        this.name = name;
        this.minParticipants = minParticipants;
        this.location = location;
        this.created = Instant.now();
    }
}