package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.DoctorEntity;
import dev.patika.veterinary_project.entities.VaccineEntity;

import java.util.List;

public interface IDoctorService {
    DoctorEntity save (DoctorEntity doctor);
    DoctorEntity update (DoctorEntity doctor);
    DoctorEntity getById(Long id);
    void delete(Long id);
    List<DoctorEntity> findAll();
}
