package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.VaccineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVaccineRepo extends JpaRepository<VaccineEntity,Long> {
}
