package backend.educationproject.mappers;

import backend.educationproject.clientmodels.ClientHomework;
import backend.educationproject.entities.Homeworks;
import backend.educationproject.postmodels.PostHomeworkModel;

public class HomeworkMapper {
    public static ClientHomework toModel(Homeworks homework){
        return ClientHomework.builder()
                .id(homework.getId())
                .description(homework.getHomework_description())
                .date(homework.getDeadline_date())
                .build();
    }

    public static Homeworks toEntity(PostHomeworkModel homework){
        return Homeworks.builder()
                .deadline_date(homework.getDeadline_date())
                .homework_description(homework.getDescription())
                .build();
    }
}