package dev.patika.veterinary_project.api;

import dev.patika.veterinary_project.business.abstracts.IAnimalService;
import dev.patika.veterinary_project.entities.AnimalEntity;
import dev.patika.veterinary_project.entities.CustomerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final IAnimalService iAnimalService;

    public AnimalController(IAnimalService iAnimalService) {
        this.iAnimalService = iAnimalService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalEntity save(@RequestBody AnimalEntity animal) { //entitiy'i gönderdik.
        return this.iAnimalService.save(animal);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AnimalEntity update (@RequestBody AnimalEntity animal) {
        return this.iAnimalService.update(animal);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.iAnimalService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalEntity getById(@PathVariable("id") Long id) {
        return this.iAnimalService.getById(id);
    }
}

