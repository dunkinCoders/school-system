package backend.educationproject.repositories;

import backend.educationproject.entities.Journals;
import org.springframework.data.repository.CrudRepository;

public interface JournalsRepository extends CrudRepository<Journals,Long> {
}
