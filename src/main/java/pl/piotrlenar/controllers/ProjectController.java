package pl.piotrlenar.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrlenar.entities.Project;
import pl.piotrlenar.entities.Task;
import pl.piotrlenar.repositories.ProjectRepository;
import pl.piotrlenar.repositories.TaskRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user/project")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public ProjectController(ProjectRepository projectRepository, TaskRepository taskRepository){
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @ModelAttribute("progressStatus")
    public List<Integer> progress(){
        List list = new ArrayList();
        for (int i = 0; i <= 100; i++){
            list.add(i);
        }
        return list;
    }

    @RequestMapping(value = "/details/{projectId}", method = RequestMethod.GET)
    public String projectDetails(Model model, @PathVariable Long projectId) {
        List<Task> projectTasks = taskRepository.findAllByProjectId(projectId);
        model.addAttribute("tasks", projectTasks);
        return "projectDetails";
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

    @PostMapping("/add")
    public String processProject(@Valid @ModelAttribute Project project, BindingResult br){
        if(!br.hasErrors()){
        return "project-form";
        }
        projectRepository.save(project);
        return "manageProject";
    }

    @GetMapping("/edit/{id}")
    public String editProjectForm(Model model, @PathVariable Long id) {
        Project projectToEdit = projectRepository.findOne(id);
        model.addAttribute("project", projectToEdit);
        return "project-form";
    }

    @PostMapping("/edit/{id}")
    public String editProject(@Valid @ModelAttribute Project project, @PathVariable Long id, BindingResult br) {
        Project dbProject = projectRepository.findOne(id);
        if (br.hasErrors()){
            return "project-form";
        }
        dbProject.setName(project.getName());
        dbProject.setDescription(project.getDescription());
        dbProject.setProgressStatus(project.getProgressStatus());
        dbProject.setUsers(project.getUsers());
        projectRepository.save(dbProject);
        return "redirect: /user/project/all";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteProject(@PathVariable Long id) {
        projectRepository.delete(id);
        return "redirect: /user/project/all";
    }

}
