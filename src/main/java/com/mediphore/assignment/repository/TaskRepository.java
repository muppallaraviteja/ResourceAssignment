package com.mediphore.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediphore.assignment.object.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {}