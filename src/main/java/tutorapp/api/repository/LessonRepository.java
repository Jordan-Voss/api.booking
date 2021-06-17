package tutorapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutorapp.api.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
