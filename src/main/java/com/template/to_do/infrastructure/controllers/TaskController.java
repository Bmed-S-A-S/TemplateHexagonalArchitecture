package com.template.to_do.infrastructure.controllers;

import com.template.to_do.application.services.AdditionalTaskService;
import com.template.to_do.application.services.TaskService;
import com.template.to_do.domain.models.AditionalTaskInfo;
import com.template.to_do.domain.models.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

   private final TaskService taskService;
   private final AdditionalTaskService additionalTaskService;

   @PostMapping
   public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
      Tasks createdTask = taskService.createTask(task);
      return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
   }

   @GetMapping("/{taskId}")
   public ResponseEntity<Tasks> getTaskById(@PathVariable Long taskId) {
      return taskService.getTaskById(taskId)
              .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @GetMapping
   public ResponseEntity<List<Tasks>> getAllTasks() {
      List<Tasks> tasks = taskService.getAllTasks();
      return new ResponseEntity<>(tasks, HttpStatus.OK);
   }

   @PutMapping("/{taskId}")
   public ResponseEntity<Tasks> updateTask(@PathVariable Long taskId, @RequestBody Tasks updatedTask) {
      return taskService.updateTask(taskId, updatedTask)
              .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }

   @DeleteMapping("/{taskId}")
   public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
      if (taskService.deleteTask(taskId)) {
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
   }

   @GetMapping("/{taskId}/additional-info")
   public ResponseEntity<AditionalTaskInfo> getAdditionalTaskInfo(@PathVariable Long taskId) {
      AditionalTaskInfo additionalTaskInfo = additionalTaskService.getAdditionalTaskInfo(taskId);
      return new ResponseEntity<>(additionalTaskInfo, HttpStatus.OK);
   }
}
