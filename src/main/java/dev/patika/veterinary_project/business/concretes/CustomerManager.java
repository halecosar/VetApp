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
        Customer checkCustomer = getById(customer.getId());
        if (checkCustomer!=null){
        return this.customerRepo.save(customer);}
        else {
            throw new RuntimeException(customer.getId() + " id’li kayıt sistemde bulunamadı.");
        }
    }

    @Override
    public Customer getById(Long id) {
        return this.customerRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        Customer checkCustomer = getById(id);
        if (checkCustomer!=null){
        this.customerRepo.deleteById(id);}
        else {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        }
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
