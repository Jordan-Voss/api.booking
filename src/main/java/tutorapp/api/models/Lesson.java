package tutorapp.api.models;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
    private Time startTime;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private Duration duration;
    private Boolean booked;

    private LocalDateTime booked_on;
    private Boolean available;
    private Long user_id;

    public Lesson() {
    }

    public Lesson(
            Long id,
            String subject,
            Time startTime,
            Date startDate,
            Duration duration,
            Boolean booked,
            LocalDateTime booked_on,
            Boolean available,
            Long user_id) {
        this.id = id;
        this.subject = subject;
        this.startTime = startTime;
        this.startDate = startDate;
        this.duration = duration;
        this.booked = booked;
        this.booked_on = booked_on;
        this.available = available;
        this.user_id = user_id;
    }

    public Lesson(
            String subject,
            Time startTime,
            Date startDate,
            Duration duration,
            Boolean booked,
            LocalDateTime booked_on,
            Boolean available,
            Long user_id) {
        this.subject = subject;
        this.startTime = startTime;
        this.startDate = startDate;
        this.duration = duration;
        this.booked = booked;
        this.booked_on = booked_on;
        this.available = available;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }

    public Boolean getBooked() {
        return booked;
    }

    public LocalDateTime getBooked_on() {
        return booked_on;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
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
                ", startDate=" + startDate +
                ", duration=" + duration +
                ", booked=" + booked +
                ", booked_on=" + booked_on +
                ", available=" + available +
                ", user_id=" + user_id +
                '}';
    }
}
