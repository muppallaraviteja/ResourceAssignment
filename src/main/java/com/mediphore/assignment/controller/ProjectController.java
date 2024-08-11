package com.mediphore.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediphore.assignment.exception.InvalidStrategyException;
import com.mediphore.assignment.object.TaskAssignment;
import com.mediphore.assignment.object.TaskAssignmentDTO;
import com.mediphore.assignment.service.ProjectAssignmentService;

@RestController
@RequestMapping("/api")
public class ProjectController {


  private final ProjectAssignmentService projectAssignmentService;

  public ProjectController(ProjectAssignmentService projectAssignmentService) {
    this.projectAssignmentService = projectAssignmentService;
  }

  @PostMapping("/projects/{projectId}/assign")
  public ResponseEntity<List<TaskAssignmentDTO>> assignResources(@PathVariable Long projectId, @RequestParam String strategyType)
      throws InvalidStrategyException {
    List<TaskAssignment> assignments = projectAssignmentService.assignResourcesToProject(projectId, strategyType);
    List<TaskAssignmentDTO> dtos = assignments.stream()
        .map(a -> new TaskAssignmentDTO(a.getId(), a.getTask().getTaskName(), a.getResource().getResourceName()))
        .collect(Collectors.toList());
    return ResponseEntity.ok(dtos);
  }

}
