package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAnimalService;
import dev.patika.veterinary_project.dao.IAnimalRepo;
import dev.patika.veterinary_project.entities.AnimalEntity;
import dev.patika.veterinary_project.entities.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalManager implements IAnimalService {
    private final IAnimalRepo animalRepo;
    private final EntityManager entityManager;

    public AnimalManager(IAnimalRepo animalRepo, EntityManager entityManager) {
        this.animalRepo = animalRepo;
        this.entityManager = entityManager;
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

    @Override
    public List<AnimalEntity> getFilteredAnimalByName(String name) {
        // JPQL sorgusu ile isme göre filtreleme
        String jpql = "SELECT a FROM AnimalEntity a WHERE a.name ILIKE :animalName";

        Query query = entityManager.createQuery(jpql, CustomerEntity.class);
        query.setParameter("animalName",  "%" + name + "%");

        return query.getResultList();
    }


   


}
