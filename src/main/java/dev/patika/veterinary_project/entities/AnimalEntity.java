package dev.patika.veterinary_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "animals")
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "animal_name")
    private String name;

    @Column(name = "species")
    private String species;

    @Column(name = "breed")
    private String breed;

    @Column(name = "gender")
    private String gender;

    @Column(name = "color")
    private String color;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private LocalDate dateofBirth;

    @OneToMany(mappedBy = "animal")
    @JsonIgnore
    private List<VaccineEntity> vaccineEntities;

    @OneToMany (mappedBy = "animal")
    @JsonIgnore
    private List<AppointmentEntity> appointmentEntities;

    @ManyToOne
    @JoinColumn(name = "animal_customer_id", referencedColumnName = "customer_id")
    private CustomerEntity customerEntity;

}
