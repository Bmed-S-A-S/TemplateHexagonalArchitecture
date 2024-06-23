package com.template.to_do.infrastructure.config;

import com.template.to_do.application.services.AdditionalTaskService;
import com.template.to_do.application.services.TaskService;
import com.template.to_do.application.usecases.AdditionalTaskServiceImpl;
import com.template.to_do.application.usecases.TaskServiceImpl;
import com.template.to_do.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import com.template.to_do.domain.ports.inputs.TaskUseCase;
import com.template.to_do.domain.ports.outputs.ExternalServicePort;
import com.template.to_do.domain.ports.outputs.TaskRepositoryPort;
import com.template.to_do.infrastructure.adapters.ExternalServiceAdapter;
import com.template.to_do.infrastructure.repositories.JpaTaskRepository;
import com.template.to_do.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

   @Bean
   public TaskService taskService(TaskUseCase taskUseCase) {
      return new TaskService(taskUseCase);
   }

   @Bean
   public AdditionalTaskService additionalTaskService(GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
      return new AdditionalTaskService(getAdditionalTaskInfoUseCase);
   }

   @Bean
   public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
      return new AdditionalTaskServiceImpl(externalServicePort);
   }

   @Bean
   public ExternalServicePort externalServicePort() {
      return new ExternalServiceAdapter(new RestTemplate());
   }

   @Bean
   public TaskUseCase taskUseCase(TaskRepositoryPort taskRepositoryPort) {
      return new TaskServiceImpl(taskRepositoryPort);
   }

   @Bean
   public TaskRepositoryPort taskRepositoryPort(JpaTaskRepository jpaTaskRepository) {
      return new JpaTaskRepositoryAdapter(jpaTaskRepository);
   }

}
