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

@Table(name = "available_dates")
public class AvailableDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "av_date_id")
    private Long id;

    @Column(name = "av_date")
    @Temporal(TemporalType.DATE)
    private LocalDateTime availableDateDate;

    @ManyToOne
    @JoinColumn(name = "availabledate_doctor_id", referencedColumnName = "doctor_id")
    private DoctorEntity doctorEntity;
}
