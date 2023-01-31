package backend.educationproject.repositories;

import backend.educationproject.entities.Events;
import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<Events,Long> {
}
