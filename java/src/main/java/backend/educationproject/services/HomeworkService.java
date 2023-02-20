package backend.educationproject.services;

import backend.educationproject.clientmodels.ClientHomework;
import backend.educationproject.entities.Homeworks;
import backend.educationproject.entities.Teacher_Subjects;
import backend.educationproject.mappers.HomeworkMapper;
import backend.educationproject.postmodels.PostHomeworkModel;
import backend.educationproject.repositories.HomeworksRepository;
import backend.educationproject.repositories.Teacher_SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HomeworkService {
    private final Teacher_SubjectsRepository teacher_subjectsRepository;
    private final HomeworksRepository homeworksRepository;

    @Autowired
    public HomeworkService(Teacher_SubjectsRepository teacher_subjectsRepository, HomeworksRepository homeworksRepository) {
        this.teacher_subjectsRepository = teacher_subjectsRepository;
        this.homeworksRepository = homeworksRepository;
    }

    public void assignHomeworkForOneClass(Long class_id, Long subject_id, Long teacher_id, PostHomeworkModel homeworkModel) {
        Homeworks homeworks = Homeworks.builder()
                .homework_description(homeworkModel.getDescription())
                .deadline_date(homeworkModel.getDeadline_date())
                .teacher_subject(findTeacher_Subjects(class_id, subject_id, teacher_id))
                .build();
        homeworksRepository.save(homeworks);
    }

    public void assignHomeworkForAllClasses(Long subject_id, Long teacher_id, PostHomeworkModel homeworkModel) {
        for (Teacher_Subjects teacher_subjects : findTeacher_SubjectsList(subject_id, teacher_id)) {
            Homeworks homeworks = Homeworks.builder()
                    .homework_description(homeworkModel.getDescription())
                    .deadline_date(homeworkModel.getDeadline_date())
                    .teacher_subject(teacher_subjects)
                    .build();
        }
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

    public void deleteHomework(Long id) {
        homeworksRepository.deleteById(id);
    }

    public void update(Long id, PostHomeworkModel homeworkModel) {
        homeworksRepository.findById(id)
                .map(homework -> {
                    homework.setHomework_description(homeworkModel.getDescription());
                    homework.setDeadline_date(homeworkModel.getDeadline_date());
                    return homeworksRepository.save(homework);
                });
    }

    private Teacher_Subjects findTeacher_Subjects(Long class_id, Long subject_id, Long teacher_id) {
        Teacher_Subjects teacher_subjects = new Teacher_Subjects();
        teacher_subjectsRepository.findAll().forEach(teacher_subject -> {
            if (Objects.equals(teacher_subject.getSubject().getId(), subject_id)
                    && Objects.equals(teacher_subject.getTeacher().getId(), teacher_id)
                    && Objects.equals(teacher_subject.getStudentClass().getId(), class_id)) {
                teacher_subjects.setId(teacher_subject.getId());
                teacher_subjects.setTeacher(teacher_subject.getTeacher());
                teacher_subjects.setSubject(teacher_subject.getSubject());
                teacher_subjects.setStudentClass(teacher_subject.getStudentClass());
            }
        });
        return teacher_subjects;
    }

    private List<Teacher_Subjects> findTeacher_SubjectsList(Long subject_id, Long teacher_id) {
        List<Teacher_Subjects> teacher_subjectsList = new ArrayList<>();
        teacher_subjectsRepository.findAll().forEach(teacher_subject -> {
            if (Objects.equals(teacher_subject.getSubject().getId(), subject_id)
                    && Objects.equals(teacher_subject.getTeacher().getId(), teacher_id)) {
                teacher_subjectsList.add(teacher_subject);
            }
        });
        return teacher_subjectsList;
    }

}
