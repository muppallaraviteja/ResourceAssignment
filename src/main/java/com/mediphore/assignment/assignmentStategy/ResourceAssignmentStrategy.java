package com.mediphore.assignment.assignmentStategy;

import java.util.List;

import com.mediphore.assignment.object.Project;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.TaskAssignment;

public interface ResourceAssignmentStrategy {
  List<TaskAssignment> assignResources(Project project, List<Resource> resources);
}