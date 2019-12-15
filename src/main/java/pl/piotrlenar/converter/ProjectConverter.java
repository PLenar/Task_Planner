package pl.piotrlenar.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.piotrlenar.entities.Project;
import pl.piotrlenar.repositories.ProjectRepository;

public class ProjectConverter implements Converter<String, Project> {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project convert(String s) {
        return projectRepository.findOne(Long.valueOf(s));
    }
}