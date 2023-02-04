package backend.educationproject.controllers;

import backend.educationproject.clientmodels.ClientGrades;
import backend.educationproject.clientmodels.ClientStudents;
import backend.educationproject.entities.Events;
import backend.educationproject.entities.Grades;
import backend.educationproject.entities.Journals;
import backend.educationproject.entities.Students;
import backend.educationproject.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/journal")
//@Api(description = "Controller for a journals")
public class JournalController {
    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/get/{teacher_id}")
//    @ApiOperation("Select all journals for existing teacher")
    public List<Journals> getTeacherJournals(@PathVariable Long teacher_id) {
        return journalService.getTeacherJournals(teacher_id);
    }

    @GetMapping("/get/{class_id}/{subject_id}")
    public Journals getJournalByClassAndSubject(@PathVariable Long subject_id, @PathVariable Long class_id) {
        return journalService.getJournalByClassAndSubject(class_id, subject_id);
    }

    @GetMapping("/grades/{id}/get")
    public List<ClientStudents> getAllGrades(@PathVariable Long id) {
        return journalService.getAllGrades(id);
    }

    @GetMapping("/grades/{id}/month={month}/get")
    public List<ClientStudents> getGradesOrderByMonth(@PathVariable Long id, @PathVariable Long month) {
        return journalService.getGradesOrderByMonth(id, month);
    }

}
