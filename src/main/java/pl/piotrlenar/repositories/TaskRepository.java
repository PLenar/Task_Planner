package pl.piotrlenar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrlenar.entities.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByProjectId(Long id);
}
