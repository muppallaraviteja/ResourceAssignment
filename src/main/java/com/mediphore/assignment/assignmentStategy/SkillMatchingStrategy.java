package com.mediphore.assignment.assignmentStategy;

import java.util.ArrayList;
import java.util.List;

import com.mediphore.assignment.exception.ResourceNotAvailableException;
import com.mediphore.assignment.object.BookingSlot;
import com.mediphore.assignment.object.Project;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.Skill;
import com.mediphore.assignment.object.Task;
import com.mediphore.assignment.object.TaskAssignment;


public class SkillMatchingStrategy implements ResourceAssignmentStrategy {

  @Override
  public List<TaskAssignment> assignResources(Project project, List<Resource> resources) {
    List<TaskAssignment> assignments = new ArrayList<>();
    List<TaskAssignment> tempAssignments = new ArrayList<>();

    for (Task task : project.getTasks()) {
      Skill requiredSkill = task.getRequiredSkill();
      boolean resourceAssigned = false;
      for (Resource resource : resources) {
        if (!isAvailable(resource, task)) {
          continue;
        }

        if (resource.getSkills().contains(requiredSkill)) {
          task.setAssignedResource(resource);
          tempAssignments.add(new TaskAssignment(task, resource));
          resourceAssigned = true;
          break;
        }
      }
      if (!resourceAssigned) {
        for (Resource resource : resources) {
          if (!isAvailable(resource, task)) {
            continue;
          }

          for (Skill skill : resource.getSkills()) {
            if (skill.equals(requiredSkill)) {
              task.setAssignedResource(resource);
              tempAssignments.add(new TaskAssignment(task, resource));
              resourceAssigned = true;
              break;
            }
          }

          if (resourceAssigned) {
            break;
          }
        }
      }
      if (!resourceAssigned) {
        throw new ResourceNotAvailableException(
            "Sufficient resources are not present to complete all the tasks of the project");
      }
    }
    assignments.addAll(tempAssignments);
    return assignments;
  }

  private boolean isAvailable(Resource resource, Task task) {
    for (BookingSlot bookingSlot : resource.getBookings()) {
      if (task.getEndDate().after(bookingSlot.getBookedFrom())
          && task.getStartDate().before(bookingSlot.getBookingTo())) {
        return false;
      }
    }
    return true;
  }
}

