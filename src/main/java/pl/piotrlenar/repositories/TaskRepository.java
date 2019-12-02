package pl.piotrlenar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrlenar.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
