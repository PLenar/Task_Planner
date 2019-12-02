package pl.piotrlenar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrlenar.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
