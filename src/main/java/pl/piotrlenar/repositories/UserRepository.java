package pl.piotrlenar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrlenar.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
