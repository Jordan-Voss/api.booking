//package tutorapp.api.config;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tutorapp.api.models.Lesson;
//import tutorapp.api.repository.LessonRepository;
//
//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.List;
//
//@Configuration
//public class LessonConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(LessonRepository lessonRepository) {
//        return args -> {
//            Lesson english = new Lesson(
//                    "English",
//                    LocalTime.of( 19, 55, 00),
//                    LocalDate.of(2021,9,16),
//                    Duration.ofMinutes(45),
//                    LocalDate.of(2021, 9, 16),
//                    LocalDateTime.of(2021, 9, 15, 19, 55, 00),
//                    true,
//                    1235288L
//            );
//            Lesson music = new Lesson(
//                    "Music",
//                    LocalTime.of( 19, 55, 00),
//                    LocalDate.of(2021,9,16),
//                    Duration.ofMinutes(45),
//                    LocalDate.of(2021, 9, 16),
//                    LocalDateTime.of(2021, 9, 16, 19, 55, 00),
//                    true,
//                    18457L
//            );
//            lessonRepository.saveAll(List.of(english, music));
//        };
//    }
//}
