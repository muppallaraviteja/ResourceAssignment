package com.mediphore.assignment.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mediphore.assignment.object.Resource;

@SpringBootTest
public class ResourceRepositoryTest {

  @Autowired
  private ResourceRepository resourceRepository;

  @Test
  public void testFindByResourceName() {
    // Given
    Resource resource = new Resource();
    resource.setResourceName("TestResource");
    resourceRepository.save(resource);

    // When
    Optional<Resource> foundResource = resourceRepository.findByResourceName("TestResource");

    // Then
    assertTrue(foundResource.isPresent());
    assertEquals("TestResource", foundResource.get().getResourceName());
  }
}
