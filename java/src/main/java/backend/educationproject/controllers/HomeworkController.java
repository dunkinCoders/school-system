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

    @GetMapping("/class={class_id}")
    public List<ClientHomework> getAllHomeworks(@PathVariable Long class_id) {
        return homeworkService.getAllHomeworks(class_id);
    }

    //soon
    @GetMapping("/class={class_id}/actual")
    public List<ClientHomework> getActualHomeworks(@PathVariable Long class_id) {
        return null;
    }

    @PostMapping("/{teacher_id}/subject={subject_id}/class={class_id}")
    public void assignHomeworkForClass(@PathVariable Long class_id,
                                       @PathVariable Long subject_id,
                                       @PathVariable Long teacher_id,
                                       @RequestBody PostHomeworkModel homework) {
        homeworkService.assignHomeworkForOneClass(class_id, subject_id, teacher_id, homework);
    }

    @PostMapping("/{teacher_id}/subject={subject_id}")
    public void assignHomeworkForAllClasses(@PathVariable Long subject_id,
                                            @PathVariable Long teacher_id,
                                            @RequestBody PostHomeworkModel homework) {
        homeworkService.assignHomeworkForAllClasses(subject_id, teacher_id, homework);
    }

    @PatchMapping("/{id}")
    public void updateHomework(@PathVariable Long id, @RequestBody PostHomeworkModel homework) {
        homeworkService.update(id, homework);
    }

    @DeleteMapping("/{id}")
    public void delete_homework(@PathVariable Long id) {
        homeworkService.deleteHomework(id);
    }
}