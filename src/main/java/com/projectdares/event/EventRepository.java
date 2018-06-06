package com.projectdares.event;

import java.time.Instant;
import java.util.Collection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {

    Collection<Event> findByCreatedAfter(Instant instant, Pageable pageable);
}
