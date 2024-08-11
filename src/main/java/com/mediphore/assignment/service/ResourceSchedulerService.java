package com.mediphore.assignment.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.mediphore.assignment.assignmentStategy.ResourceAssignmentStrategy;
import com.mediphore.assignment.object.Project;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.TaskAssignment;

@Service
public class ResourceSchedulerService {

  private ResourceAssignmentStrategy strategy;

  /**
   * Set the strategy for resource assignment.
   *
   * @param strategy the resource assignment strategy
   */
  public void setStrategy(ResourceAssignmentStrategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Assigns resources to tasks within a project based on the selected strategy.
   *
   * @param project   the project with tasks that need to be staffed
   * @param resources the available resources
   * @return a list of task assignments (which resource is assigned to which task)
   */
  public List<TaskAssignment> assignResourcesToProject(Project project, List<Resource> resources) {
    if (strategy == null) {
      throw new IllegalStateException("Resource assignment strategy must be set before calling this method.");
    }

    return strategy.assignResources(project, resources);
  }
}
