package dev.patika.veterinary_project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @Column(name = "appointment_date")
    @Temporal(TemporalType.DATE)
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "appointment_animal_id", referencedColumnName = "animal_id")
    private AnimalEntity animalEntity;

    @ManyToOne
    @JoinColumn(name = "appointment_doctor_id", referencedColumnName = "doctor_id")
    private DoctorEntity doctorEntity;
}
