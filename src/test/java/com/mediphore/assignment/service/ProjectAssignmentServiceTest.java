package com.mediphore.assignment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediphore.assignment.assignmentStategy.DefaultMatchingStrategy;
import com.mediphore.assignment.assignmentStategy.SkillMatchingStrategy;
import com.mediphore.assignment.exception.InvalidStrategyException;
import com.mediphore.assignment.exception.ProjectNotFoundException;
import com.mediphore.assignment.object.BookingSlot;
import com.mediphore.assignment.object.Project;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.Skill;
import com.mediphore.assignment.object.Task;
import com.mediphore.assignment.object.TaskAssignment;
import com.mediphore.assignment.repository.BookingRepository;
import com.mediphore.assignment.repository.ProjectRepository;
import com.mediphore.assignment.repository.ResourceRepository;
import com.mediphore.assignment.repository.TaskAssignmentRepository;
import com.mediphore.assignment.repository.TaskRepository;

@SpringBootTest
public class ProjectAssignmentServiceTest {

  @Mock
  private ProjectRepository projectRepository;

  @Mock
  private ResourceRepository resourceRepository;

  @Mock
  private ResourceSchedulerService resourceSchedulerService;

  @Mock
  private TaskRepository taskRepository;

  @Mock
  private BookingRepository bookingRepository;

  @Mock
  private TaskAssignmentRepository taskAssignmentRepository;

  @InjectMocks
  private ProjectAssignmentService projectAssignmentService;

  private Project project;
  private Resource resource1, resource2;
  private Skill skill1, skill2;
  private Task task1, task2;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    // Set up mock data
    skill1 = new Skill(1L, "ReactJS");
    skill2 = new Skill(2L, "NodeJS");

    resource1 = new Resource(1L, "Alice", Arrays.asList(skill1), null, null);
    resource2 = new Resource(2L, "Bob", Arrays.asList(skill2), null, null);

    task1 = new Task(1L, "Frontend Development", new Date(), new Date());
    task1.setRequiredSkill(skill1);

    task2 = new Task(2L, "Backend Development", new Date(), new Date());
    task2.setRequiredSkill(skill2);

    project = new Project(1L, "Project A", new Date(), new Date(), Arrays.asList(task1, task2));
  }


  @Test
  public void testAssignResourcesToNonExistingProject() {
    when(projectRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(ProjectNotFoundException.class, () -> {
      projectAssignmentService.assignResourcesToProject(1L, "skill");
    });

    verify(resourceSchedulerService, never()).assignResourcesToProject(any(), any());
  }

}
