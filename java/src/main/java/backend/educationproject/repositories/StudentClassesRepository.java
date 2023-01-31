package backend.educationproject.repositories;

import backend.educationproject.entities.StudentClasses;
import org.springframework.data.repository.CrudRepository;

public interface StudentClassesRepository extends CrudRepository<StudentClasses,Long> {
}
