package com.mediphore.assignment.object;

import lombok.Data;

@Data
public class TaskAssignmentDTO {
  private Long id;
  private String taskName;
  private String resourceName;

  public TaskAssignmentDTO(Long id, String taskName, String resourceName) {
    this.id = id;
    this.resourceName = resourceName;
    this.taskName = taskName;
  }

}
