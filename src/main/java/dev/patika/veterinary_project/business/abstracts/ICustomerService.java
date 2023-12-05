package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.CustomerEntity;
import dev.patika.veterinary_project.entities.DoctorEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICustomerService {

    CustomerEntity save (CustomerEntity customer);
    CustomerEntity update (CustomerEntity customer);
    CustomerEntity getById(Long id);
    void delete(Long id);
    List<CustomerEntity> findAll();

    public List<CustomerEntity> getFilteredCustomerByName(String name);


}
