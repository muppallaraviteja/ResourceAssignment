//package com.mediphore.assignment.assignmentStategy;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.mediphore.assignment.object.Resource;
//import com.mediphore.assignment.object.Skill;
//import com.mediphore.assignment.object.Task;
//import com.mediphore.assignment.object.TaskAssignment;
//
//public class SkillMatchingStrategyTest {
//
//  private SkillMatchingStrategy skillMatchingStrategy;
//
//  private Skill skill1;
//  private Skill skill2;
//  private Skill skill3;
//
//  private Resource resource1;
//  private Resource resource2;
//  private Resource resource3;
//
//  private Task task1;
//  private Task task2;
//  private Task task3;
//
//  @BeforeEach
//  public void setUp() {
//    skillMatchingStrategy = new SkillMatchingStrategy();
//
//    skill1 = new Skill(1L, "ReactJS");
//    skill2 = new Skill(2L, "NodeJS");
//    skill3 = new Skill(3L, "Python");
//
//    resource1 = new Resource(1L, "Alice", Arrays.asList(skill1, skill2), null, null);
//    resource2 = new Resource(2L, "Bob", Arrays.asList(skill2), null, null);
//    resource3 = new Resource(3L, "Charlie", Arrays.asList(skill3), null, null);
//
//    task1 = new Task(1L, "Frontend Development", new Date(), new Date());
//    task1.setRequiredSkill(skill1);
//
//    task2 = new Task(2L, "Backend Development", new Date(), new Date());
//    task2.setRequiredSkill(skill2);
//
//    task3 = new Task(3L, "Data Analysis", new Date(), new Date());
//    task3.setRequiredSkill(skill3);
//  }
//
//  @Test
//  public void testAssignResourcesWhenSkillsMatch() {
//    List<Resource> resources = Arrays.asList(resource1, resource2, resource3);
//    List<Task> tasks = Arrays.asList(task1, task2, task3);
//
//    List<TaskAssignment> assignments = skillMatchingStrategy.assignResources(tasks, resources);
//
//    assertEquals(3, assignments.size());
//
//    assertEquals(resource1, assignments.get(0).getResource());
//    assertEquals(task1, assignments.get(0).getTask());
//
//    assertEquals(resource2, assignments.get(1).getResource());
//    assertEquals(task2, assignments.get(1).getTask());
//
//    assertEquals(resource3, assignments.get(2).getResource());
//    assertEquals(task3, assignments.get(2).getTask());
//  }
//
//  @Test
//  public void testNoResourceAssignedWhenNoSkillMatches() {
//    Skill skill4 = new Skill(4L, "Java");
//    Task task4 = new Task(4L, "Backend Development", new Date(), new Date());
//    task4.setRequiredSkill(skill4);
//
//    List<Resource> resources = Arrays.asList(resource1, resource2, resource3);
//    List<Task> tasks = Arrays.asList(task4);
//
//    List<TaskAssignment> assignments = skillMatchingStrategy.assignResources(tasks, resources);
//
//    assertEquals(0, assignments.size());  // No matching resource for task4
//  }
//
//  @Test
//  public void testMultipleTasksWithOverlappingSkills() {
//    Resource resource4 = new Resource(4L, "Dave", Arrays.asList(skill1, skill2), null, null);
//
//    List<Resource> resources = Arrays.asList(resource1, resource2, resource3, resource4);
//    List<Task> tasks = Arrays.asList(task1, task2);
//
//    List<TaskAssignment> assignments = skillMatchingStrategy.assignResources(tasks, resources);
//
//    assertEquals(2, assignments.size());
//
//    // Ensure that the tasks are assigned based on the first matching skill
//    assertEquals(resource1, assignments.get(0).getResource());
//    assertEquals(task1, assignments.get(0).getTask());
//
//    assertEquals(resource2, assignments.get(1).getResource());
//    assertEquals(task2, assignments.get(1).getTask());
//  }
//
//  @Test
//  public void testResourceWithMultipleSkillsAssignedToMultipleTasks() {
//    List<Resource> resources = Arrays.asList(resource1);
//    List<Task> tasks = Arrays.asList(task1, task2);
//
//    List<TaskAssignment> assignments = skillMatchingStrategy.assignResources(tasks, resources);
//
//    assertEquals(2, assignments.size());
//
//    assertEquals(resource1, assignments.get(0).getResource());
//    assertEquals(task1, assignments.get(0).getTask());
//
//    assertEquals(resource1, assignments.get(1).getResource());
//    assertEquals(task2, assignments.get(1).getTask());
//  }
//}
