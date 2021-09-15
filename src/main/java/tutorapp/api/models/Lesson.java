package tutorapp.api.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table
public class Lesson {
    @Id
    @SequenceGenerator(name = "lesson_sequence",
    sequenceName = "lesson_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "lesson_sequence")
    private Long id;
    private String subject;
    private LocalDateTime startTime;
    private Duration duration;
    private LocalDate date;
    private LocalDateTime booked_on;
    private Long user_id;

    public Lesson() {
    }

    public Lesson(
            Long id,
            String subject,
            LocalDateTime startTime,
            Duration duration,
            LocalDate date,
            LocalDateTime booked_on,
            Long user_id) {
        this.id = id;
        this.subject = subject;
        this.startTime = startTime;
        this.duration = duration;
        this.date = date;
        this.booked_on = booked_on;
        this.user_id = user_id;
    }

    public Lesson(
            String subject,
            LocalDateTime startTime,
            Duration duration,
            LocalDate date,
            LocalDateTime booked_on,
            Long user_id) {
        this.subject = subject;
        this.startTime = startTime;
        this.duration = duration;
        this.date = date;
        this.booked_on = booked_on;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getBooked_on() {
        return booked_on;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setBooked_on(LocalDateTime booked_on) {
        this.booked_on = booked_on;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", startTime=" + startTime +
                ", duration=" + duration +
                ", date=" + date +
                ", booked_on=" + booked_on +
                ", user_id=" + user_id +
                '}';
    }
}
