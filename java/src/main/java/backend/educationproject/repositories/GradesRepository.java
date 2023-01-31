package backend.educationproject.repositories;

import backend.educationproject.entities.Grades;
import org.springframework.data.repository.CrudRepository;

public interface GradesRepository extends CrudRepository<Grades,Long> {
}
