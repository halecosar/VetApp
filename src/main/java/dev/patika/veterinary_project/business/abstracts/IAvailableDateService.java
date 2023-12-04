package dev.patika.veterinary_project.business.abstracts;

import dev.patika.veterinary_project.entities.AvailableDateEntity;
import dev.patika.veterinary_project.entities.CustomerEntity;

import javax.accessibility.AccessibleValue;
import java.util.List;

public interface IAvailableDateService {

    AvailableDateEntity save (AvailableDateEntity availableDate);
    AvailableDateEntity update (AvailableDateEntity availableDate);
    AvailableDateEntity getById(Long id);
    void delete(Long id);
    List<AvailableDateEntity> findAll();
}
