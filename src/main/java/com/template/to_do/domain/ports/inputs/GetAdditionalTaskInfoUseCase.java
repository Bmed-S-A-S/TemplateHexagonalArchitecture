package com.template.to_do.domain.ports.inputs;

import com.template.to_do.domain.models.AditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
   AditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
