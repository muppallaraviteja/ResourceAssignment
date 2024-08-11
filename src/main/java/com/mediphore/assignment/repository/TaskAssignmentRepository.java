package com.mediphore.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediphore.assignment.object.Task;
import com.mediphore.assignment.object.TaskAssignment;

public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment, Long> {}