package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvailableDateRepo extends JpaRepository<AvailableDate,Long> {
}
