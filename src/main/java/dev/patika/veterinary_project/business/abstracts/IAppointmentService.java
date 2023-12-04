package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.AppointmentEntity;
import dev.patika.veterinary_project.entities.AvailableDateEntity;

import java.util.List;

public interface IAppointmentService {

    AppointmentEntity save (AppointmentEntity appointment);
    AppointmentEntity update (AppointmentEntity appointment);
    AppointmentEntity getById(Long id);
    void delete(Long id);
    List<AppointmentEntity> findAll();
}
