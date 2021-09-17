package tutorapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tutorapp.api.models.Lesson;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
//    @Query("SELECT s FROM Lesson s WHERE s.available = false ")
    List<Lesson> findLessonByAvailable(Boolean available);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Lesson l set l.available=false where l.startDate <= :date and l.startTime < :time or l.startDate < :date")
    void updateByStartDateStartTime(@Param("date") Date localDate, @Param("time") Time localTime);

};