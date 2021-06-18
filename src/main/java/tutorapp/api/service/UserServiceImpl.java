package tutorapp.api.service;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tutorapp.api.model.User;
import tutorapp.api.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userid){
        userRepository.deleteById(userid);
    }

    @Override
    public User findByUsername(String username){
        return userRepository.findByUserName(username).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Long userCount() {
        return userRepository.count();
    }
}
