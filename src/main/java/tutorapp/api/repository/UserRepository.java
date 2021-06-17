package tutorapp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tutorapp.api.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    find by username

    Optional<User> findByUsername(String username);
}
