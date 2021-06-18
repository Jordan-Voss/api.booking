package tutorapp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorapp.api.model.Lesson;
import tutorapp.api.repository.LessonRepository;

import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson saveLesson(final Lesson lesson){
        lessonRepository.save(lesson);
        return lesson;
    }

    @Override
    public Lesson updateLesson(final Lesson lesson){
        return lessonRepository.save(lesson);
    }

    @Override
    public void deleteLesson(final Long lessonId){
        lessonRepository.deleteById(lessonId);
    }

    @Override
    public Long numberOfLessons(){
        return lessonRepository.count();
    }

    @Override
    public List<Lesson> findAllLessons(){
        return lessonRepository.findAll();
    }
}