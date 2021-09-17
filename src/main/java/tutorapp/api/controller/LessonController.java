package tutorapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorapp.api.models.Lesson;
import tutorapp.api.service.LessonService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/lesson")
public class LessonController {


    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/available")
    public List<Lesson> getAvailableLessons(){
        return lessonService.getAvailableLessons();
    };
    
    @PostMapping("/insert-available")
    public void insertNewAvailableBooking(@RequestBody List<Lesson> lessons) {
        for (Lesson lesson: lessons
             ) {
            lessonService.insertNewAvailableLesson(lesson);
        }

    }

    @PostMapping
    public void bookNewLesson(@RequestBody Lesson lesson) {
        lessonService.addLessonNew(lesson);
    }


}
