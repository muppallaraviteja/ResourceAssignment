package com.mediphore.assignment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediphore.assignment.object.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
  public Optional<Resource> findByResourceName(String name);
}