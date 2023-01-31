package backend.educationproject.repositories;

import backend.educationproject.entities.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students,Long> {
}
