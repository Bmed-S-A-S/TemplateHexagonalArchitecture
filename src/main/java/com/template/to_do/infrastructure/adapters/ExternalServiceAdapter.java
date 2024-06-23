package com.template.to_do.infrastructure.adapters;

import com.template.to_do.domain.models.AditionalTaskInfo;
import com.template.to_do.domain.ports.outputs.ExternalServicePort;
import com.template.to_do.infrastructure.adapters.json_placeholder.JsonPlaceholderTodo;
import com.template.to_do.infrastructure.adapters.json_placeholder.JsonPlaceholderUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class ExternalServiceAdapter implements ExternalServicePort {

   private final RestTemplate restTemplate;

   @Override
   public AditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
      String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
      ResponseEntity<JsonPlaceholderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceholderTodo.class);
      JsonPlaceholderTodo todo = response.getBody();

      if (todo == null) {
         return null;
      }

      apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
      ResponseEntity<JsonPlaceholderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceholderUser.class);
      JsonPlaceholderUser user = userResponse.getBody();

      if (user == null) {
         return null;
      }

      return new AditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
   }
}
