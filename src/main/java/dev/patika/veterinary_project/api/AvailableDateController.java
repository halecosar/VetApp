package dev.patika.veterinary_project.api;

import dev.patika.veterinary_project.business.abstracts.IAvailableDateService;
import dev.patika.veterinary_project.entities.AppointmentEntity;
import dev.patika.veterinary_project.entities.AvailableDateEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("v1/availabledates") public class AvailableDateController {
    private final IAvailableDateService availableDateService;

    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDateEntity save(@RequestBody AvailableDateEntity availableDate) { //entitiy'i gönderdik.
        return this.availableDateService.save(availableDate);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateEntity update (@RequestBody AvailableDateEntity availableDate) {
        return this.availableDateService.update(availableDate);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.availableDateService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDateEntity getById(@PathVariable("id") Long id) {
        return this.availableDateService.getById(id);
    }
}

