package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends JpaRepository<CustomerEntity,Long> {
}
