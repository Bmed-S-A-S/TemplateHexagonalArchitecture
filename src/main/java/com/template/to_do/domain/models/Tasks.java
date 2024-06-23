package com.template.to_do.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {

   private Long id;
   private String title;
   private String description;
   private LocalDateTime creationDate;
   private boolean completed;
}
