package backend.educationproject.services;

import backend.educationproject.entities.Journals;
import backend.educationproject.repositories.JournalsRepository;
import backend.educationproject.repositories.Teacher_SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class JournalService {
    private final Teacher_SubjectsRepository teacher_subjectsRepository;
    private final JournalsRepository journalsRepository;

    @Autowired

    public JournalService(Teacher_SubjectsRepository teacher_subjectsRepository, JournalsRepository journalsRepository) {
        this.teacher_subjectsRepository = teacher_subjectsRepository;
        this.journalsRepository = journalsRepository;
    }

    public List<Journals> getTeacherJournals(Long teacher_id) {
        List<Journals> journals = new ArrayList<>();
        teacher_subjectsRepository.findAll().forEach(teacher_subjects -> {
            if (Objects.equals(teacher_id, teacher_subjects.getTeacher().getId())) {
                journalsRepository.findAll().forEach(journals_objects -> {
                    if (journals_objects.getTeacher_subject() == teacher_subjects) {
                        journals.add(journals_objects);
                    }
                });
            }
        });
        return journals;
    }
}
