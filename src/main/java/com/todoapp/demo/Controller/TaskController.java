package com.todoapp.demo.Controller;

import com.todoapp.demo.Entity.Task;
import com.todoapp.demo.Services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/todoApplicationUsingSpring")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getTask(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(
            @RequestParam("task") String task,
            @RequestParam(value = "dueDate", required = false) java.time.LocalDate dueDate,
            @RequestParam(value = "priority", required = false) com.todoapp.demo.Entity.Priority priority
    ) {
        taskService.creatTask(task, dueDate, priority);
        return "redirect:/todoApplicationUsingSpring";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/todoApplicationUsingSpring";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/todoApplicationUsingSpring";
    }
}
