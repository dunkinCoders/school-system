package backend.educationproject.controllers;

import backend.educationproject.entities.Events;
import backend.educationproject.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumController {
    private final EventService eventService;

    @Autowired
    public CurriculumController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{class_id}/get")
    public List<Events> getCurriculum(@PathVariable Long class_id) {
        return null;
    }

    @GetMapping("/{class_id}/event/{id}")
    public Events getEvent(@PathVariable Long id, @PathVariable Long class_id) {
        return null;
    }

    @DeleteMapping("/{class_id}/delete")
    public void deleteCurriculum(@PathVariable Long class_id) {

    }

    @DeleteMapping("/{class_id}/event/delete")
    public void deleteEvent() {

    }

    @PostMapping("/{class_id}/event/add")
    public void addEvent() {

    }

    @PostMapping("/{class_id}/spreadsheet")
    public void addSheet() {

    }

    @PutMapping("/{class_id}/event/put")
    public void updateEvent() {

    }

    @PatchMapping("/{class_id}/event/patch")
    public void updateEvent(@PathVariable Long class_id) {

    }
}