package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAppointmentService;
import dev.patika.veterinary_project.dao.IAppointmentRepo;
import dev.patika.veterinary_project.entities.AppointmentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {
    private final IAppointmentRepo appointmentRepo;

    public AppointmentManager(IAppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public AppointmentEntity save(AppointmentEntity appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public AppointmentEntity update(AppointmentEntity appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public AppointmentEntity getById(Long id) {
        return this.appointmentRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.appointmentRepo.deleteById(id);
    }

    @Override
    public List<AppointmentEntity> findAll() {
        return this.appointmentRepo.findAll();
    }
}
