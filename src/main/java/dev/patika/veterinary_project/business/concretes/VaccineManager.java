package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IVaccineService;
import dev.patika.veterinary_project.dao.IVaccineRepo;
import dev.patika.veterinary_project.entities.Vaccine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManager implements IVaccineService {
    private final IVaccineRepo vaccineRepo;

    public VaccineManager(IVaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public Vaccine save(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public Vaccine getById(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.vaccineRepo.deleteById(id);
    }

    @Override
    public List<Vaccine> findAll() {
        return this.vaccineRepo.findAll();
    }
}
