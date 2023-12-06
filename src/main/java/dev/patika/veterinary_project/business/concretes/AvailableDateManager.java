package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAvailableDateService;
import dev.patika.veterinary_project.dao.IAvailableDateRepo;
import dev.patika.veterinary_project.entities.AvailableDate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailableDateManager implements IAvailableDateService {
    private final IAvailableDateRepo availableDateRepo;

    public AvailableDateManager(IAvailableDateRepo availableDateRepo) {
        this.availableDateRepo = availableDateRepo;
    }

    @Override
    public AvailableDate save(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public AvailableDate update(AvailableDate availableDate) {
        return this.availableDateRepo.save(availableDate);
    }

    @Override
    public AvailableDate getById(Long id) {
        return this.availableDateRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.availableDateRepo.deleteById(id);
    }

    @Override
    public List<AvailableDate> findAll() {
        return this.availableDateRepo.findAll();
    }
}
