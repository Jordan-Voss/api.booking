package tutorapp.api.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="day")
    private String day;

    @Column(name="time")
    private Double time;

    @Column(name="date")
    private String date;
}
