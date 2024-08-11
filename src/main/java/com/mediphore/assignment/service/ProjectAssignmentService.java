package com.mediphore.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mediphore.assignment.assignmentStategy.DefaultMatchingStrategy;
import com.mediphore.assignment.assignmentStategy.SkillMatchingStrategy;
import com.mediphore.assignment.exception.InvalidStrategyException;
import com.mediphore.assignment.exception.ProjectNotFoundException;
import com.mediphore.assignment.object.BookingSlot;
import com.mediphore.assignment.object.Project;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.Task;
import com.mediphore.assignment.object.TaskAssignment;
import com.mediphore.assignment.repository.BookingRepository;
import com.mediphore.assignment.repository.ProjectRepository;
import com.mediphore.assignment.repository.ResourceRepository;
import com.mediphore.assignment.repository.TaskAssignmentRepository;
import com.mediphore.assignment.repository.TaskRepository;

@Service
public class ProjectAssignmentService {

  private final ProjectRepository projectRepository;
  private final ResourceRepository resourceRepository;
  private final ResourceSchedulerService resourceSchedulerService;
  private final TaskRepository taskRepository;
  private final BookingRepository bookingRepository;
  private final TaskAssignmentRepository taskAssignmentRepository;

  public ProjectAssignmentService(ProjectRepository projectRepository,
      ResourceRepository resourceRepository,
      ResourceSchedulerService resourceSchedulerService,
      TaskRepository taskRepository, BookingRepository bookingRepository,
      TaskAssignmentRepository taskAssignmentRepository) {
    this.projectRepository = projectRepository;
    this.resourceRepository = resourceRepository;
    this.resourceSchedulerService = resourceSchedulerService;
    this.taskRepository = taskRepository;
    this.bookingRepository = bookingRepository;
    this.taskAssignmentRepository = taskAssignmentRepository;
  }

  public List<TaskAssignment> assignResourcesToProject(Long projectId, String strategyType)
     {
    Project project = projectRepository.findById(projectId)
        .orElseThrow(() -> new ProjectNotFoundException("Project not found"));

    List<Resource> resources = resourceRepository.findAll();

    switch (strategyType.toLowerCase()) {
      case "skill":
        resourceSchedulerService.setStrategy(new SkillMatchingStrategy());
        break;

      case "default":
        resourceSchedulerService.setStrategy(new DefaultMatchingStrategy());
        break;
      default:
        throw new InvalidStrategyException("Invalid strategy type");
    }

    List<TaskAssignment> assignments =  resourceSchedulerService.assignResourcesToProject(project, resources);

    for (TaskAssignment assignment : assignments) {
      Task task = assignment.getTask();
      Resource resource = assignment.getResource();
      taskAssignmentRepository.save(assignment);
      BookingSlot taskSlot = new BookingSlot(task.getStartDate(), task.getEndDate(),resource);
      resource.getBookings().add(taskSlot);
      resourceRepository.save(resource);
      task.setAssignedResource(resource);
      taskRepository.save(task);
    }

    return assignments;
  }
}
