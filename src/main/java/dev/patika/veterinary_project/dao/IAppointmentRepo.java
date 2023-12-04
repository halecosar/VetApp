package dev.patika.veterinary_project.dao;

import dev.patika.veterinary_project.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepo extends JpaRepository<AppointmentEntity,Long> {
}
