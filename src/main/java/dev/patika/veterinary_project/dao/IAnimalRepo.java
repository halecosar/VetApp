package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepo extends JpaRepository<Animal,Long> {
}
