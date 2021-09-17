package tutorapp.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tutorapp.api.models.Lesson;
import tutorapp.api.repository.LessonRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getLessons() {
        return lessonRepository.findAll();
    }

    public void addLessonNew(Lesson lesson) {
//        Optional<Lesson> lessonOptional = lessonRepository
//                .findLessonByAvailable(lesson.getAvailable());
//        if (lessonOptional.isPresent()) {
//            throw new IllegalStateException("nope");
//        }
        lessonRepository.save(lesson);
        System.out.println(lesson);
    }

    public List<Lesson> getAvailableLessons() {
        return lessonRepository.findLessonByAvailable(true);
    };

    @Scheduled(cron = "* * * ? * *")
    @Transactional
    public void makePastBookingUnavailable() {
//        lessonRepository.updateByStartDateStartTime(LocalDate.now(), LocalTime.now());
        lessonRepository.updateByStartDateStartTime(LocalDate.now(), LocalTime.now());

        System.out.println(LocalTime.now());
    }
};
