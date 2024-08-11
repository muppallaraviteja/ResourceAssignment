package com.mediphore.assignment.Util;

import java.util.stream.Collectors;

import com.mediphore.assignment.object.Resource;
import com.mediphore.assignment.object.ResourceDTO;
import com.mediphore.assignment.object.ResourceDTO.SkillDTO;
import com.mediphore.assignment.object.Skill;

public class ResourceMapper {

  public static ResourceDTO toDTO(Resource resource) {
    ResourceDTO dto = new ResourceDTO();
    dto.setResourceId(resource.getResourceId());
    dto.setResourceName(resource.getResourceName());
    dto.setSkills(resource.getSkills().stream()
        .map(ResourceMapper::toDTO)
        .collect(Collectors.toList()));
    return dto;
  }

  public static SkillDTO toDTO(Skill skill) {
    SkillDTO dto = new SkillDTO();
    dto.setSkillId(skill.getSkillId());
    dto.setSkillName(skill.getSkillName());
    return dto;
  }

}
