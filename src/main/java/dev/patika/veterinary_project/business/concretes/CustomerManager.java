package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.ICustomerService;
import dev.patika.veterinary_project.dao.ICustomerRepo;
import dev.patika.veterinary_project.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.repository.query.Param;
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
    public Customer save(Customer customer) {
        List<Customer> customers = customerRepo.checkCustomerInfo(customer.getMail(), customer.getPhone());
        if (customers.size() > 0) {
            throw new RuntimeException("Bu bilgilere sahip müşteri daha önce eklendi.");
        } else {
            return this.customerRepo.save(customer);
        }
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepo.findAll();
    }

    @Override
    public List<Customer> getFilteredCustomerByName(String name) {
        // JPQL sorgusu ile isme göre filtreleme
        String jpql = "SELECT c FROM CustomerEntity c WHERE c.name ILIKE :customerName";

        Query query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("customerName", "%" + name + "%");

        return query.getResultList();
    }
}
