package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.AnimalEntity;
import dev.patika.veterinary_project.entities.AppointmentEntity;

import java.util.List;

public interface IAnimalService {

    AnimalEntity save (AnimalEntity animal);
    AnimalEntity update (AnimalEntity animal);
    AnimalEntity getById(Long id);
    void delete(Long id);
    List<AnimalEntity> findAll();
}
