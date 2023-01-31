package backend.educationproject.services;

import backend.educationproject.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventsRepository eventsRepository;

    @Autowired
    public EventService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
}
