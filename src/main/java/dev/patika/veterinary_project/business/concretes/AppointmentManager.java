package dev.patika.veterinary_project.business.concretes;

import dev.patika.veterinary_project.business.abstracts.IAppointmentService;
import dev.patika.veterinary_project.dao.IAppointmentRepo;
import dev.patika.veterinary_project.dto.request.AnimalVaccineDTO;
import dev.patika.veterinary_project.dto.request.AppointmentFilterByAnimalDTO;
import dev.patika.veterinary_project.dto.request.AppointmentFilterByDoctorDTO;
import dev.patika.veterinary_project.entities.Animal;
import dev.patika.veterinary_project.entities.Appointment;
import dev.patika.veterinary_project.entities.AvailableDate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {
    private final IAppointmentRepo appointmentRepo;
    private final EntityManager entityManager;

    public AppointmentManager(IAppointmentRepo appointmentRepo, EntityManager entityManager) {
        this.appointmentRepo = appointmentRepo;
        this.entityManager = entityManager;
    }

    @Override
    public Appointment save(Appointment appointment) {
        List<AvailableDate> availableDates = checkAvailableDatesByDoctor(appointment);
        if (availableDates.size() != 0) {
            List<Appointment> appointments = checkAppointmentsDatesByDoctor(appointment);
            if (appointments.size() == 0) {
                return this.appointmentRepo.save(appointment);
            } else {
                throw new RuntimeException("Doktorun bu satte başka bir randevusu mevcuttur");
            }
        } else {
            throw new RuntimeException("Doktorun girilen gün için müsaitliği bulunmamaktadır.");
        }
    }

    @Override
    public Appointment update(Appointment appointment) {
        return this.appointmentRepo.save(appointment);
    }

    @Override
    public Appointment getById(Long id) {
        return this.appointmentRepo.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        this.appointmentRepo.deleteById(id);
    }

    @Override
    public List<Appointment> findAll() {
        return this.appointmentRepo.findAll();
    }


    public List<AvailableDate> checkAvailableDatesByDoctor(Appointment appointment) {
        String queryString = "SELECT a FROM AvailableDate a WHERE a.doctor.id = :doctor_id AND a.availableDateDate = :available_date";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", appointment.getDoctor().getId());
        query.setParameter("available_date", appointment.getAppointmentDate().toLocalDate());

        return query.getResultList();
    }

    public List<Appointment> checkAppointmentsDatesByDoctor(Appointment appointment) {
        String queryString = "SELECT a FROM Appointment a WHERE a.doctor.id = :doctor_id AND a.appointmentDate = :appointmentDate";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", appointment.getDoctor().getId());
        query.setParameter("appointmentDate", appointment.getAppointmentDate());

        return query.getResultList();
    }

    @Override
    public List<Appointment> filterbyDoctor(AppointmentFilterByDoctorDTO appointmentFilterByDoctorDTO) {
        String queryString = "SELECT a FROM Appointment a WHERE a.doctor.id = :doctor_id AND a.appointmentDate >= :startDate AND a.appointmentDate <= :endDate";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("doctor_id", appointmentFilterByDoctorDTO.getDoctorId());
        query.setParameter("startDate", appointmentFilterByDoctorDTO.getStartDate());
        query.setParameter("endDate", appointmentFilterByDoctorDTO.getEndDate());

        return query.getResultList();
    }

    @Override
    public List<Appointment> filterbyAnimal(AppointmentFilterByAnimalDTO appointmentFilterByAnimalDTO) {
            String queryString = "SELECT a FROM Appointment a WHERE a.animal.id = :animal_id AND a.appointmentDate >= :startDate AND a.appointmentDate <= :endDate";
            Query query = entityManager.createQuery(queryString);
            query.setParameter("animal_id", appointmentFilterByAnimalDTO.getAnimalId());
            query.setParameter("startDate", appointmentFilterByAnimalDTO.getStartDate());
            query.setParameter("endDate", appointmentFilterByAnimalDTO.getEndDate());

            return query.getResultList();
        }

    }

