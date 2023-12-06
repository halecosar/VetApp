package dev.patika.veterinary_project.api;

import dev.patika.veterinary_project.business.abstracts.IVaccineService;
import dev.patika.veterinary_project.entities.Vaccine;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("v1/vaccines")
public class VaccineController {
    private final IVaccineService vaccineService;

    public VaccineController(IVaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Vaccine save(@RequestBody Vaccine vaccine) { //entitiy'i gönderdik.
        return this.vaccineService.save(vaccine);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine update (@RequestBody Vaccine vaccine) {
        return this.vaccineService.update(vaccine);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.vaccineService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vaccine getById(@PathVariable("id") Long id) {
        return this.vaccineService.getById(id);
    }
}
