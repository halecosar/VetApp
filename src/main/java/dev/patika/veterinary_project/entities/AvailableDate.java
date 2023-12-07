package dev.patika.veterinary_project.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "available_dates")
public class AvailableDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "av_date_id")
    private Long id;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "av_date")
    @Temporal(TemporalType.DATE)
    //@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate availableDateDate;

    @ManyToOne
    @JoinColumn(name = "availabledate_doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor;
}
