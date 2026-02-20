package com.todoapp.demo.Repository;

import com.todoapp.demo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository< Task, Long > {

}
