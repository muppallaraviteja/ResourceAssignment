package com.mediphore.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediphore.assignment.object.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {}