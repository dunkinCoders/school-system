package backend.educationproject.mappers;

import backend.educationproject.clientmodels.ClientGrades;
import backend.educationproject.entities.Grades;

public class GradeMapper {
    public static ClientGrades toModel(Grades grades) {
        return ClientGrades.builder()
                .id(grades.getId())
                .grade(grades.getGrade())
                .build();
    }
}
