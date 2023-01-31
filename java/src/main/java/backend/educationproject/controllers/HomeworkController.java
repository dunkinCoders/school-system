package backend.educationproject.controllers;

import backend.educationproject.clientmodels.ClientHomework;
import backend.educationproject.services.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homework")
public class HomeworkController {
    private final HomeworkService homeworkService;

    @Autowired
    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping("/{class_subject_id}")
    public List<ClientHomework> getAllHomeworks() {
        return null;
    }

    @GetMapping("/{class_subject_id}/{id}")
    public ClientHomework getConcreteHomework() {
        return null;
    }

    @PostMapping("/{class_subject_id}/add")
    public void assignHomework() {

    }

    @PutMapping("/update/{id}")
    public void update_homework() {

    }
}