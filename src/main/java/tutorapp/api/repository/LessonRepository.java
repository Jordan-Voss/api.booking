package tutorapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tutorapp.api.models.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
