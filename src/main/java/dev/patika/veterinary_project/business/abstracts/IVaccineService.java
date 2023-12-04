package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.VaccineEntity;

import java.util.List;

public interface IVaccineService {

    VaccineEntity save (VaccineEntity vaccine);
    VaccineEntity update (VaccineEntity doctor);
    VaccineEntity getById(Long id);
    void delete(Long id);
    List<VaccineEntity> findAll();
}
