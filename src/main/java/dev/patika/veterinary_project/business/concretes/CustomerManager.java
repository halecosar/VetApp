package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.ICustomerService;
import dev.patika.veterinary_project.dao.ICustomerRepo;
import dev.patika.veterinary_project.entities.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements ICustomerService {
    private final ICustomerRepo customerRepo;
    private final EntityManager entityManager;

    public CustomerManager(ICustomerRepo customerRepo, EntityManager entityManager) {
        this.customerRepo = customerRepo;
        this.entityManager = entityManager;
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public CustomerEntity update(CustomerEntity customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public CustomerEntity getById(Long id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.customerRepo.deleteById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public List<CustomerEntity> getFilteredCustomerByName(String name) {
        // JPQL sorgusu ile isme göre filtreleme
        String jpql = "SELECT c FROM CustomerEntity c WHERE c.name ILIKE :customerName";

        Query query = entityManager.createQuery(jpql, CustomerEntity.class);
        query.setParameter("customerName",  "%" + name + "%");

        return query.getResultList();
    }
}
