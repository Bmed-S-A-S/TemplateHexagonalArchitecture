package com.template.to_do.application.services;

import com.template.to_do.domain.models.Tasks;
import com.template.to_do.domain.ports.inputs.TaskUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskService {

   private final TaskUseCase taskUseCase;

   public Tasks createTask(Tasks task) {
      return taskUseCase.createTask(task);
   }

   public Optional<Tasks> getTaskById(Long id) {
      return taskUseCase.getTaskById(id);
   }

   public List<Tasks> getAllTasks() {
      return taskUseCase.getAllTasks();
   }

   public Optional<Tasks> updateTask(Long id, Tasks updatedTask) {
      return taskUseCase.updateTask(id, updatedTask);
   }

   public boolean deleteTask(Long id) {
      return taskUseCase.deleteTask(id);
   }
}
