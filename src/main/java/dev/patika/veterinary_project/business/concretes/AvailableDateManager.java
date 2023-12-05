package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAvailableDateService;
import dev.patika.veterinary_project.dao.IAvailableDateRepo;
import dev.patika.veterinary_project.entities.AvailableDateEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final IAvailableDateRepo availableDateRepo;

    public AvailableDateManager(IAvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }

    @Override
    public AvailableDateEntity save(AvailableDateEntity availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public AvailableDateEntity update(AvailableDateEntity availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public AvailableDateEntity getById(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.availableDateRepo.deleteById(id);
    }

    @Override
    public List<AvailableDateEntity> findAll() {
        return this.availableDateRepo.findAll();
    }
}
