package com.template.to_do.application.usecases;

import com.template.to_do.domain.models.Tasks;
import com.template.to_do.domain.ports.inputs.TaskUseCase;
import com.template.to_do.domain.ports.outputs.TaskRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TaskServiceImpl implements TaskUseCase {

   private final TaskRepositoryPort taskRepositoryPort;

   @Override
   public Tasks createTask(Tasks task) {
      return taskRepositoryPort.save(task);
   }

   @Override
   public Optional<Tasks> getTaskById(Long id) {
      return taskRepositoryPort.findById(id);
   }

   @Override
   public List<Tasks> getAllTasks() {
      return taskRepositoryPort.findAll();
   }

   @Override
   public Optional<Tasks> updateTask(Long id, Tasks updatedTask) {
      return taskRepositoryPort.update(updatedTask);
   }

   @Override
   public boolean deleteTask(Long id) {
      return taskRepositoryPort.deleteById(id);
   }
}
