package com.example.first_app.service;

import com.example.first_app.mapper.DeveloperMapper;
import com.example.first_app.model.Developer;

import com.example.first_app.modelDTO.DeveloperDTO;
import com.example.first_app.repository.DeveloperRepo;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service

public class DeveloperService {

    @Autowired
    DeveloperRepo developerRepo;

    @Autowired
    DeveloperMapper developerMapper;

    public List<DeveloperDTO> getDevelopers() {
        return developerRepo.findAll().stream().map(developerMapper::fromEntityToDTO).toList();
    }

    public DeveloperDTO getDeveloperById(Long Id) {
        return developerMapper.fromEntityToDTO(developerRepo.findById(Id).orElse(new Developer()));
    }

    public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
        Developer savedDeveloper = developerRepo.save(developerMapper.fromDTOToEntity(developerDTO));
        return developerMapper.fromEntityToDTO(savedDeveloper);
    }

    public void updateDeveloper(Developer developer) {
        developerRepo.save(developer);
    }

    public DeveloperDTO deleteDeveloperById(Long Id) {
        Developer deletedDeveloper = developerRepo.findById(Id).orElse(new Developer());
        developerRepo.deleteById(Id);
        return developerMapper.fromEntityToDTO(deletedDeveloper);
    }


}
