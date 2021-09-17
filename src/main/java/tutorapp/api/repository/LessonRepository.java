package tutorapp.api.repository;

import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tutorapp.api.models.Lesson;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
//    @Query("SELECT s FROM Lesson s WHERE s.available = false ")
    List<Lesson> findLessonByAvailable(Boolean available);
//    public LocalDate lt = LocalDate.now();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Lesson l set l.available=false where l.startDate <= :date and l.startTime < :time or l.startDate < :date")
    void updateByStartDateStartTime(@Param("date") LocalDate localDate, @Param("time") LocalTime localTime);
//    void updateByStartDateStartTime(@Param("date") LocalDate localDate, @Param("time") LocalTime localTime);

//    List<Lesson> findLessonByAvailability(Boolean available);
};