package pl.piotrlenar.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.piotrlenar.entities.Project;
import pl.piotrlenar.repositories.ProjectRepository;
import pl.piotrlenar.repositories.TaskRepository;

import javax.validation.Valid;

@RequestMapping("/user/project")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectController(ProjectRepository projectRepository, TaskRepository taskRepository){
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @RequestMapping("/all")
    public String allProjects(Model m){
        m.addAttribute("projects", projectRepository.findAll());
        return "allProjects";
    }

    @GetMapping("/add")
    public String getProject(Model m){
        m.addAttribute("project", new Project());
        return "project-form";
    }

//    @PostMapping("/add")
//    public String processProject(@Valid @ModelAttribute Project project, BindingResult br){
//        if(!br.hasErrors()){
//
//        }
//
//    }

}
