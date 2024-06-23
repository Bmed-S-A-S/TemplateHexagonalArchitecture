package com.template.to_do.infrastructure.repositories;

import com.template.to_do.domain.models.Tasks;
import com.template.to_do.domain.ports.outputs.TaskRepositoryPort;
import com.template.to_do.infrastructure.entities.TaskEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

   private final JpaTaskRepository jpaTaskRepository;

   @Override
   public Tasks save(Tasks task) {
      TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
      TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);
      return savedTaskEntity.toDomainModel();
   }

   @Override
   public Optional<Tasks> findById(Long id) {
      return jpaTaskRepository.findById(id).map(TaskEntity::toDomainModel);
   }

   @Override
   public List<Tasks> findAll() {
      return jpaTaskRepository.findAll().stream()
              .map(TaskEntity::toDomainModel)
              .collect(Collectors.toList());
   }

   @Override
   public Optional<Tasks> update(Tasks task) {
      if (jpaTaskRepository.existsById(task.getId())) {
         TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
         TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
         return Optional.of(updatedTaskEntity.toDomainModel());
      }
      return Optional.empty();
   }

   @Override
   public boolean deleteById(Long id) {
      if (jpaTaskRepository.existsById(id)) {
         jpaTaskRepository.deleteById(id);
         return true;
      }
      return false;
   }
}
