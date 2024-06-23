package com.template.to_do.application.usecases;

import com.template.to_do.domain.models.AditionalTaskInfo;
import com.template.to_do.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import com.template.to_do.domain.ports.outputs.ExternalServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdditionalTaskServiceImpl implements GetAdditionalTaskInfoUseCase {

   private final ExternalServicePort externalServicePort;
   @Override
   public AditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
      return externalServicePort.getAdditionalTaskInfo(taskId);
   }
}
