package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IVaccineService;
import dev.patika.veterinary_project.dao.IVaccineRepo;
import dev.patika.veterinary_project.entities.VaccineEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManager implements IVaccineService {
    private final IVaccineRepo vaccineRepo;

    public VaccineManager(IVaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public VaccineEntity save(VaccineEntity vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public VaccineEntity update(VaccineEntity vaccine) {
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public VaccineEntity getById(Long id) {
        return this.vaccineRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.vaccineRepo.deleteById(id);
    }

    @Override
    public List<VaccineEntity> findAll() {
        return this.vaccineRepo.findAll();
    }
}
