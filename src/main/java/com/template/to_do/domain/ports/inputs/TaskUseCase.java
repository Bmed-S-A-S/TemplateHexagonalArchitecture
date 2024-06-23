package com.template.to_do.domain.ports.inputs;

import com.template.to_do.domain.models.Tasks;

import java.util.List;
import java.util.Optional;

public interface TaskUseCase {
   Tasks createTask(Tasks task);
   Optional<Tasks> getTaskById(Long id);
   List<Tasks> getAllTasks();
   Optional<Tasks> updateTask(Long id, Tasks updatedTask);
   boolean deleteTask(Long id);
}
