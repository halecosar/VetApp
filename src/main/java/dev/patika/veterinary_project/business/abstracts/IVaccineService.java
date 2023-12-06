package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.Vaccine;

import java.util.List;

public interface IVaccineService {

    Vaccine save (Vaccine vaccine);
    Vaccine update (Vaccine vaccine);
    Vaccine getById(Long id);
    void delete(Long id);
    List<Vaccine> findAll();
}
