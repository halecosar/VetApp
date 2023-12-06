package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAppointmentService;
import dev.patika.veterinary_project.dao.IAppointmentRepo;
import dev.patika.veterinary_project.entities.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {
    private final IAppointmentRepo appointmentRepo;

    public AppointmentManager(IAppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Appointment save(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment getById(Long id) {
        return this.appointmentRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.appointmentRepo.deleteById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }
}
