package com.mediphore.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mediphore.assignment.Util.ResourceMapper;
import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.ResourceDTO;
import com.mediphore.assignment.service.ResourceService;

@RestController
public class ResourceController {


  private final ResourceService resourceService;

  public ResourceController(ResourceService resourceService) {
    this.resourceService = resourceService;
  }

  @GetMapping("/resource/name/{name}")
  public ResourceDTO getResourceByName(@PathVariable String name){
    Resource resource =  resourceService.getResourceByName(name);
    return ResourceMapper.toDTO(resource);
  }

}
