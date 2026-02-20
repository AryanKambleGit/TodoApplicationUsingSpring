package com.todoapp.demo.Services;

import com.todoapp.demo.Entity.Priority;
import com.todoapp.demo.Entity.Task;
import com.todoapp.demo.Repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }


    public void creatTask(String title, LocalDate dueDate, Priority priority) {
        Task task = new Task();
        task.setTitle(title);

        // optional fields
        task.setDueDate(dueDate);

        // if null, keep default MEDIUM
        if (priority != null) {
            task.setPriority(priority);
        }

        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}