package com.template.to_do.application.services;

import com.template.to_do.domain.models.AditionalTaskInfo;
import com.template.to_do.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdditionalTaskService {

   private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

   public AditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
      return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(taskId);
   }
}
