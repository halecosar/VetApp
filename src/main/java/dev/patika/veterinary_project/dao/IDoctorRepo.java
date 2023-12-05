package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepo extends JpaRepository<DoctorEntity,Long> {
}
