package backend.educationproject.repositories;

import backend.educationproject.entities.Subjects;
import org.springframework.data.repository.CrudRepository;

public interface SubjectsRepository extends CrudRepository<Subjects,Long> {
}
