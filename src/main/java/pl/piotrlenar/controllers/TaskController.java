package pl.piotrlenar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrlenar.entities.Project;
import pl.piotrlenar.entities.Task;
import pl.piotrlenar.repositories.CommentRepository;
import pl.piotrlenar.repositories.ProjectRepository;
import pl.piotrlenar.repositories.TaskRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/task")
public class TaskController {

    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final ProjectRepository projectRepository;

    public TaskController(TaskRepository taskRepository, CommentRepository commentRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.projectRepository = projectRepository;
    }

    @ModelAttribute("dateNow")
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @ModelAttribute("projects")
    public List<Project> getListOfProjects(){
        return projectRepository.findAll();
    }

    @RequestMapping("/all")
    public String allTask(Model model) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("allTasks", allTasks);
        return "allTasks";
    }

    @GetMapping("/add")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/add")
    public String addTask(@Valid @ModelAttribute Task task, BindingResult br, Model model) {
        if (br.hasErrors()){
            model.addAttribute("task", new Task());
            return "task-form";
        }
        taskRepository.save(task);
        return "redirect: all";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(Model model, @PathVariable Long id) {
        Task taskToEdit = taskRepository.findOne(id);
        model.addAttribute("task", taskToEdit);
        return "task-form";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@Valid @ModelAttribute Task task, @PathVariable Long id, BindingResult br, Model model) {
        if (br.hasErrors()){
            Task taskToEdit = taskRepository.findOne(id);
            model.addAttribute("task", taskToEdit);
            return "task-form";
        }
        Task dbTask = taskRepository.findOne(id);
        dbTask.setName(task.getName());
        dbTask.setProject(task.getProject());
        dbTask.setDescription(task.getDescription());
        dbTask.setPriority(task.getPriority());
        dbTask.setDeadline(task.getDeadline());
        taskRepository.save(dbTask);
        return "redirect: /user/task/all";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRepository.delete(id);
        return "redirect: /user/task/all";
    }


}
