package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.Appointment;

import java.util.List;

public interface IAppointmentService {

    Appointment save (Appointment appointment);
    Appointment update (Appointment appointment);
    Appointment getById(Long id);
    void delete(Long id);
    List<Appointment> findAll();
}
