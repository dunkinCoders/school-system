package backend.educationproject.controllers;

import backend.educationproject.clientmodels.ClientHomework;
import backend.educationproject.entities.Homeworks;
import backend.educationproject.postmodels.PostHomeworkModel;
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

    @GetMapping("/get/class={class_id}")
    public List<ClientHomework> getAllHomeworks(@PathVariable Long class_id) {
        return homeworkService.getAllHomeworks(class_id);
    }

    //soon
    @GetMapping("/get/class={class_id}/actual")
    public List<ClientHomework>getActualHomeworks(@PathVariable Long class_id){
        return null;
    }

    @PostMapping("/add/class={class_id}")
    public void assignHomeworkForClass(@PathVariable Long class_id, @RequestBody PostHomeworkModel homework) {

    }
    @PostMapping("/add/{subject_id}")
    public void assignHomeworkForAllClasses(@PathVariable Long subject_id, @RequestBody PostHomeworkModel homework){

    }

    @PutMapping("/update/{id}")
    public void update_homework() {

    }
}