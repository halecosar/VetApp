package dev.patika.veterinary_project.api;

import dev.patika.veterinary_project.business.abstracts.ICustomerService;
import dev.patika.veterinary_project.entities.CustomerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerEntity save(@RequestBody CustomerEntity customer) { //entitiy'i gönderdik.
        return this.customerService.save(customer);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public CustomerEntity update (@RequestBody CustomerEntity customer) {
        return this.customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.customerService.delete(id);
    }

    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerEntity getById(@PathVariable("id") Long id) {
        return this.customerService.getById(id);
    }

    @GetMapping("/getFilteredCustomerByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerEntity> getFilteredCustomerByName(@PathVariable("name") String name) {
        return this.customerService.getFilteredCustomerByName(name);
    }
}

