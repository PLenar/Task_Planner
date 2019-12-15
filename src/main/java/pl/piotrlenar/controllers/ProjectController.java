package pl.piotrlenar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrlenar.entities.Project;
import pl.piotrlenar.entities.Task;
import pl.piotrlenar.entities.User;
import pl.piotrlenar.repositories.ProjectRepository;
import pl.piotrlenar.repositories.TaskRepository;
import pl.piotrlenar.repositories.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user/project")
@Controller
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public ProjectController(ProjectRepository projectRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("loggedInUser")
    public void getLoggedUser(HttpSession s, Model model){
       model.addAttribute("loggedInUser", s.getAttribute("loggedInUser"));
    }

    @ModelAttribute("users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @ModelAttribute("progress")
    public List<Integer> progress() {
        List list = new ArrayList();
        for (int i = 0; i <= 100; i++) {
            list.add(i);
        }
        return list;
    }

    @ModelAttribute("allProjects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }


    @GetMapping("/details/{projectId}")
    public String projectDetails(Model model, @PathVariable Long projectId) {
        List<Task> projectTasks = taskRepository.findAllByProjectId(projectId);
        model.addAttribute("tasks", projectTasks);
        return "projectDetails";
    }

    @RequestMapping("/all")
    public String allProjects(Model m) {
        m.addAttribute("projects", projectRepository.findAll());
        return "allProjects";
    }

    @GetMapping("/add")
    public String getProject(Model m) {
        m.addAttribute("project", new Project());
        return "project-form";
    }

    @PostMapping("/add")
    public String processProject(@Valid @ModelAttribute Project project, BindingResult br, Model m) {
        if (br.hasErrors()) {
            m.addAttribute("project", new Project());
            return "redirect: /add";
        }
        projectRepository.save(project);
        return "redirect: /user/project/all";
    }

    @GetMapping("/edit/{id}")
    public String editProjectForm(Model model, @PathVariable Long id) {
        Project projectToEdit = projectRepository.findOne(id);
        model.addAttribute("project", projectToEdit);
        return "project-form";
    }

    @PostMapping("/edit/{id}")
    public String editProject(@Valid @ModelAttribute Project project, @PathVariable Long id, BindingResult br, Model m) {
        Project dbProject = projectRepository.findOne(id);
        if (br.hasErrors()) {
            Project projectToEdit = projectRepository.findOne(id);
            m.addAttribute("project", projectToEdit);
            return "project-form";
        }
        dbProject.setName(project.getName());
        dbProject.setDescription(project.getDescription());
        dbProject.setProgressStatus(project.getProgressStatus());
        dbProject.setUsers(project.getUsers());
        projectRepository.save(dbProject);
        return "redirect: /user/project/all";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectRepository.delete(id);
        return "redirect: /user/project/all";
    }

}
