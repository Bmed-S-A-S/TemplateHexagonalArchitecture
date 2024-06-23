package com.template.to_do.domain.ports.outputs;

import com.template.to_do.domain.models.AditionalTaskInfo;

public interface ExternalServicePort {
   AditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
