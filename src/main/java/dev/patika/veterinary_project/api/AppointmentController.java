package dev.patika.veterinary_project.api;

import dev.patika.veterinary_project.business.abstracts.IAppointmentService;
import dev.patika.veterinary_project.entities.AppointmentEntity;
import dev.patika.veterinary_project.entities.VaccineEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("v1/appointments")
public class AppointmentController {
    private final IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentEntity save(@RequestBody AppointmentEntity appointment) { //entitiy'i gönderdik.
        return this.appointmentService.save(appointment);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentEntity update (@RequestBody AppointmentEntity appointment) {
        return this.appointmentService.update(appointment);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.appointmentService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentEntity getById(@PathVariable("id") Long id) {
        return this.appointmentService.getById(id);
    }
}
