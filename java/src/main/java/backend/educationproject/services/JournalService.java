package backend.educationproject.services;

import backend.educationproject.clientmodels.ClientGrades;
import backend.educationproject.clientmodels.ClientStudents;
import backend.educationproject.entities.*;
import backend.educationproject.mappers.GradeMapper;
import backend.educationproject.mappers.StudentMapper;
import backend.educationproject.repositories.*;
import backend.educationproject.services.sorters.JournalDateComparator;
import backend.educationproject.services.sorters.JournalMonthPicker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JournalService {
    private final Teacher_SubjectsRepository teacher_subjectsRepository;
    private final JournalsRepository journalsRepository;
    private final StudentClassesRepository studentClassesRepository;
    private final GradesRepository gradesRepository;
    private final StudentsRepository studentsRepository;
    private final EventsRepository eventsRepository;

    @Autowired
    public JournalService(Teacher_SubjectsRepository teacher_subjectsRepository, JournalsRepository journalsRepository, StudentClassesRepository studentClassesRepository, GradesRepository gradesRepository, StudentsRepository studentsRepository, EventsRepository eventsRepository) {
        this.teacher_subjectsRepository = teacher_subjectsRepository;
        this.journalsRepository = journalsRepository;
        this.studentClassesRepository = studentClassesRepository;
        this.gradesRepository = gradesRepository;
        this.studentsRepository = studentsRepository;
        this.eventsRepository = eventsRepository;
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

    public Journals getJournalByClassAndSubject(Long class_id, Long subject) {
        Journals journal = new Journals();
        teacher_subjectsRepository.findAll().forEach(teacher_subjects -> {
            if (Objects.equals(teacher_subjects.getStudentClass().getId(), class_id)
                    && Objects.equals(teacher_subjects.getSubject().getId(), subject)) {
                journalsRepository.findAll().forEach(journals_objects -> {
                    if (journals_objects.getTeacher_subject() == teacher_subjects) {
                        journal.setId(journals_objects.getId());
                        journal.setTeacher_subject(journals_objects.getTeacher_subject());
                    }
                });
            }
        });
        return journal;
    }

    public List<ClientStudents> getAllGrades(Long id) {
        List<ClientStudents> grades_list = new ArrayList<>();
        List<Students> students = getAllStudentsFromClass(id);
        for (Students st : students) {
            ClientStudents clientStudent = StudentMapper.toModel(st);
            clientStudent.setGrades(getAllGradesForStudent(st));
            grades_list.add(clientStudent);
        }
        return grades_list;
    }

    public List<ClientStudents> getGradesOrderByMonth(Long id, Long month) {
        JournalMonthPicker journalMonthPicker = new JournalMonthPicker(eventsRepository);
        List<ClientStudents> grades_list = new ArrayList<>();
        List<Students> students = getAllStudentsFromClass(id);
        for (Students st : students) {
            ClientStudents clientStudent = StudentMapper.toModel(st);
            List<ClientGrades> grades = getAllGradesForStudent(st);
            journalMonthPicker.pick(grades, month-1);
            clientStudent.setGrades(grades);
            grades_list.add(clientStudent);
        }
        return grades_list;
    }

    private List<Students> getAllStudentsFromClass(Long journal_id) {
        List<Students> students = new ArrayList<>();
        StudentClasses studentClass = studentClassesRepository.findById(journalsRepository.findById(journal_id)
                .get()
                .getTeacher_subject()
                .getStudentClass()
                .getId()).get();
        studentsRepository.findAll().forEach(student -> {
            if (Objects.equals(student.getStudentClass(), studentClass)) {
                students.add(student);
            }
        });
        return students;
    }

    private List<ClientGrades> getAllGradesForStudent(Students student) {
        List<ClientGrades> grades = new ArrayList<>();
        gradesRepository.findAll().forEach(grade -> {
            if (grade.getStudent() == student) {
                grades.add(GradeMapper.toModel(grade));
            }
        });
        JournalDateComparator journalDateComparator = new JournalDateComparator(eventsRepository);
        grades.sort(journalDateComparator);
        return grades;
    }

    //soon
    private List<Grades> getAllSortedGrades() {
        return null;
    }

}
