package backend.educationproject.repositories;

import backend.educationproject.entities.Teachers;
import org.springframework.data.repository.CrudRepository;

public interface TeachersRepository extends CrudRepository<Teachers,Long> {
}
