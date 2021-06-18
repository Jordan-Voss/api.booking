package tutorapp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tutorapp.api.model.Role;
import tutorapp.api.model.User;
import tutorapp.api.model.Transaction;
import tutorapp.api.service.LessonService;
import tutorapp.api.service.TransactionService;
import tutorapp.api.service.UserService;
import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUserName()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {
//        principal = request.getUserPrincipal();
        if (principal == null || principal.getName() == null) {
            return new ResponseEntity<>(principal, HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("api/user/purchase")
    public ResponseEntity<?> purchaseLesson(@RequestBody Transaction transaction) {
        transaction.setPurchaseDate(LocalDateTime.now());
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping("api/user/lessons")
    public ResponseEntity<?> getAllLessons() {
        return new ResponseEntity<>(lessonService.findAllLessons(), HttpStatus.OK);
    }
}
