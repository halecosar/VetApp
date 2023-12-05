package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAnimalService;
import dev.patika.veterinary_project.dao.IAnimalRepo;
import dev.patika.veterinary_project.entities.AnimalEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {
    private final IAnimalRepo animalRepo;

    public AnimalManager(IAnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public AnimalEntity save(AnimalEntity animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public AnimalEntity update(AnimalEntity animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public AnimalEntity getById(Long id) {
        return this.animalRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
this.animalRepo.deleteById(id);
    }

    @Override
    public List<AnimalEntity> findAll() {
        return this.animalRepo.findAll();
    }
}
