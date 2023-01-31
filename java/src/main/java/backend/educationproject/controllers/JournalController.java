package backend.educationproject.controllers;

import backend.educationproject.entities.Journals;
import backend.educationproject.services.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/journal")
public class JournalController {
    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @GetMapping("/get/{teacher_id}")
    public List<Journals> getTeacherJournals(@PathVariable Long teacher_id) {
        return journalService.getTeacherJournals(teacher_id);
    }

    @GetMapping("/get/{class_id}/{subject_id}")
    public Journals getJournalbyClass() {
        return null;
    }


}
