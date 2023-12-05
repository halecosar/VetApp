package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnimalRepo extends JpaRepository<AnimalEntity,Long> {
}
