package com.template.to_do.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class AditionalTaskInfo {
   private final Long userId;
   private final String userName;
   private final String userEmail;
}
