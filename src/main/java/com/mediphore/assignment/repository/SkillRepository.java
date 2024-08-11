package com.mediphore.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediphore.assignment.object.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {}