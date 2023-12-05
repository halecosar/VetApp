package dev.patika.veterinary_project.api;

import dev.patika.veterinary_project.business.abstracts.IDoctorService;
import dev.patika.veterinary_project.entities.AnimalEntity;
import dev.patika.veterinary_project.entities.DoctorEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/v1/doctors") public class DoctorController {
    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorEntity save(@RequestBody DoctorEntity doctor) { //entitiy'i gönderdik.
        return this.doctorService.save(doctor);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public DoctorEntity update (@RequestBody DoctorEntity doctor) {
        return this.doctorService.update(doctor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.doctorService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorEntity getById(@PathVariable("id") Long id) {
        return this.doctorService.getById(id);
    }
}

