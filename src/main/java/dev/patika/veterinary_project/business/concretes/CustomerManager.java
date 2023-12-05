package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.ICustomerService;
import dev.patika.veterinary_project.dao.ICustomerRepo;
import dev.patika.veterinary_project.entities.CustomerEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements ICustomerService {
    private final ICustomerRepo customerRepo;

    public CustomerManager(ICustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
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

    /* @Override
    public List<CustomerEntity> filterCustomerByName(String name) {
        List<CustomerEntity> customerEntities = new ArrayList<>();
        for (CustomerEntity customer : customerEntities) {
            if (customer.getName().equalsIgnoreCase(name)) {
                customerEntities.add(customer);
            }
        }
        return customerEntities;


    }*/


}
