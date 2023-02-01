package backend.educationproject.mappers;

import backend.educationproject.clientmodels.ClientStudents;
import backend.educationproject.entities.Students;

public class StudentMapper {
    public static ClientStudents toModel(Students student) {
        return ClientStudents.builder()
                .id(student.getId())
                .first_name(student.getFirst_name())
                .surname(student.getSurname())
                .patronymic(student.getPatronymic())
                .build();
    }
}
