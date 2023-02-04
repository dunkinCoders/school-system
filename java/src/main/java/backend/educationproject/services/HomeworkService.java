package backend.educationproject.services;

import backend.educationproject.clientmodels.ClientHomework;
import backend.educationproject.mappers.HomeworkMapper;
import backend.educationproject.repositories.HomeworksRepository;
import backend.educationproject.repositories.Teacher_SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomeworkService {
    private final HomeworksRepository homeworksRepository;

    @Autowired
    public HomeworkService(HomeworksRepository homeworksRepository) {
        this.homeworksRepository = homeworksRepository;
    }


    public List<ClientHomework> getAllHomeworks(Long class_id) {
        List<ClientHomework> homeworks = new ArrayList<>();
        homeworksRepository.findAll().forEach(homework -> {
            if (Objects.equals(homework.getTeacher_subject().getStudentClass().getId(), class_id)) {
                homeworks.add(HomeworkMapper.toModel(homework));
            }
        });
        return homeworks;
    }

}
