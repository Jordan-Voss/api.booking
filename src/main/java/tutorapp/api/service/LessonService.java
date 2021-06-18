package tutorapp.api.service;

import tutorapp.api.model.Lesson;

import java.util.List;

public interface LessonService {
    Lesson saveLesson(Lesson lesson);

    Lesson updateLesson(Lesson lesson);

    void deleteLesson(Long lessonId);

    Long numberOfLessons();

    List<Lesson> findAllLessons();
}