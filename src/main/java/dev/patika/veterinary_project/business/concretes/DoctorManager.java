package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IDoctorService;
import dev.patika.veterinary_project.dao.IDoctorRepo;
import dev.patika.veterinary_project.entities.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorManager implements IDoctorService {
    private final IDoctorRepo doctorRepo;

    public DoctorManager(IDoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.doctorRepo.deleteById(id);
    }

    @Override
    public List<Doctor> findAll() {
        return this.doctorRepo.findAll();
    }
}
