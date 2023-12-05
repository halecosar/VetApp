package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.AnimalEntity;
import dev.patika.veterinary_project.entities.AppointmentEntity;
import dev.patika.veterinary_project.entities.CustomerEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAnimalService {

    AnimalEntity save (AnimalEntity animal);
    AnimalEntity update (AnimalEntity animal);
    AnimalEntity getById(Long id);
    void delete(Long id);
    List<AnimalEntity> findAll();
    public List<AnimalEntity> getFilteredAnimalByName(String name);



}
