package com.mediphore.assignment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediphore.assignment.object.TaskAssignment;
import com.mediphore.assignment.service.ProjectAssignmentService;

@RestController
@RequestMapping("/api")
public class ProjectController {


  private final ProjectAssignmentService projectAssignmentService;

  public ProjectController(ProjectAssignmentService projectAssignmentService) {
    this.projectAssignmentService = projectAssignmentService;
  }

  @PostMapping("/projects/{projectId}/assign")
  public ResponseEntity<List<TaskAssignment>> assignResources(@PathVariable Long projectId, @RequestParam String strategyType){
    List<TaskAssignment> assignments = projectAssignmentService.assignResourcesToProject(projectId, strategyType);
    return ResponseEntity.ok(assignments);
  }

}
