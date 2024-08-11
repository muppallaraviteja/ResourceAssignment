package com.mediphore.assignment.object;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long projectId;
  private String projectName;
  private Date startDate;
  private Date endDate;

  @OneToMany(mappedBy = "project")
  private List<Task> tasks;
}