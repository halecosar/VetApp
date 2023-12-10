package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAnimalService;
import dev.patika.veterinary_project.dao.IAnimalRepo;
import dev.patika.veterinary_project.entities.Animal;
import dev.patika.veterinary_project.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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
    // "Tüm yeni veri kaydetme işlemlerinde zaten var olan bir verinin kaydedilmediği kontrol edilmelidir." Hayvan için unique bir değer olmadığı için. (Aynı özelliklerde aynı hayvan olabilir).
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal update(Animal animal) {
        Animal checkAnimal = getById(animal.getId());
        if (checkAnimal != null) {
            return this.animalRepo.save(animal);
        } else {
            throw new RuntimeException(animal.getId() + " id’li kayıt sistemde bulunamadı.");
        }
    }

    @Override
    public Animal getById(Long id) {
        return this.animalRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        Animal checkAnimal = getById(id);
        if (checkAnimal!=null){
            this.animalRepo.deleteById(id);
        }
        else{
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        }

    }


    @Override
    public List<Animal> findAll() {
        return this.animalRepo.findAll();
    }

    @Override
    public List<Animal> getFilteredAnimalByName(String name) {
        // JPQL sorgusu ile isme göre filtreleme
        String jpql = "SELECT a FROM Animal a WHERE a.name ILIKE :animalName";

        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("animalName", "%" + name + "%");

        return query.getResultList();
    }

    @Override
    public List<Animal> getAnimalsByCustomerId(Long customerId) {

        String jpql = "SELECT a FROM Animal a WHERE a.customer.id = :customer_id";

        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customer_id", customerId);

        return query.getResultList();
    }


}
