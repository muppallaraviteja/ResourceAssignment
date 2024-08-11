package com.mediphore.assignment.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mediphore.assignment.exception.ResourceNotFoundException;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.repository.ResourceRepository;


@Service
public class ResourceService {

  private final ResourceRepository resourceRepository;


  public ResourceService(ResourceRepository resourceRepository) {
    this.resourceRepository = resourceRepository;
  }

  public Resource getResourceByName(String name){
    Optional<Resource> resource =  resourceRepository.findByResourceName(name);
    if(resource.isEmpty())
      throw new ResourceNotFoundException(String.format("Resource with name %s not found ",name));
    return resource.get();
  }
}
