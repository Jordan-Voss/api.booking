package tutorapp.api.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import liquibase.pro.packaged.A;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorapp.api.model.Lesson;
import tutorapp.api.model.StringResponse;
import tutorapp.api.model.Transaction;
import tutorapp.api.model.User;
import tutorapp.api.service.LessonService;
import tutorapp.api.service.TransactionService;
import tutorapp.api.service.UserService;

@RestController
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private LessonService lessonService;

    @PostMapping("api/admin/user-update")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        User existUser = userService.findByUsername(user.getUserName());
        if (existUser != null && !existUser.getId().equals(user.getId())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @PostMapping("api/admin/user-delete")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("api/admin/user-all")
    public ResponseEntity<?> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("api/admin/user-number")
    public ResponseEntity<?> numberOfUsers() {
        Long counts = userService.userCount();
        StringResponse response = new StringResponse();
        response.setResponse(counts.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("api/admin/lesson-create")
    public ResponseEntity<?> createLesson(@RequestBody Lesson lesson) {
        return new ResponseEntity<>(lessonService.saveLesson(lesson), HttpStatus.CREATED);
    }

    @PostMapping("api/admin/lesson-update")
    public ResponseEntity<?> updateLesson(@RequestBody Lesson lesson) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/admin/lesson-delete")
    public ResponseEntity<?> deleteLesson(@RequestBody Lesson lesson){
        lessonService.deleteLesson(lesson.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/api/admin/lesson-all")
    public ResponseEntity<?> findAllLessons(){
        return new ResponseEntity<>(lessonService.findAllLessons(), HttpStatus.OK);
    }

    @GetMapping("/api/admin/lesson-number")
    public ResponseEntity<?> numberOfLessons(){
        Long number = lessonService.numberOfLessons();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/admin/transaction-all")
    public ResponseEntity<?> findAllTransactions(){
        return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("api/admin/transaction-number")
    public ResponseEntity<?> numberOfTransactions(){
        Long number = transactionService.numberOfTransactions();
        StringResponse response = new StringResponse();
        response.setResponse(number.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
