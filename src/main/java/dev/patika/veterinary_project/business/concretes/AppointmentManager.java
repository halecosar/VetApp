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

import java.time.LocalTime;
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
    //Randevu kaydı oluştururken doktorun girilen tarihte müsait günü olup olmadığı eğer ki müsait günü varsa randevu kayıtlarında girilen saatte başka bir randevusu olup olmadığı kontrol edilmelidir.
    public Appointment save(Appointment appointment) {
        LocalTime appointmentTime = appointment.getAppointmentDate().toLocalTime();
        if (appointmentTime.getMinute() != 0 || appointmentTime.getSecond() != 0) {
            throw new RuntimeException("Randevu sadece tam saatlerde alınabilir."); //Hayvanların her türlü muayenesi için doktorlardan uygun tarihlerde ve saatlerde randevu oluşturulmalıdır. Her doktor için sadece saat başı randevu oluşturulabilir. Bir muayenenin sabit olarak bir saat süreceğini kabul edin.
        }
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
        Appointment checkAppointment = getById(appointment.getId());
        if (checkAppointment!=null){
        return this.appointmentRepo.save(appointment);}
        else {
            throw new RuntimeException(appointment.getId() + " id’li kayıt sistemde bulunamadı.");
        }
    }

    @Override
    public Appointment getById(Long id) {
        return this.appointmentRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        Appointment checkAppoitment = getById(id);
        if (checkAppoitment!= null){
            this.appointmentRepo.deleteById(id);
        }
        else   throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");

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

        if (appointmentFilterByDoctorDTO.getEndDate().isAfter(appointmentFilterByDoctorDTO.getStartDate())) {
            return query.getResultList();
        } else {
            throw new RuntimeException("Giridiğiniz aralıktaki bitiş tarihi  başlangıç tarihinden küçük olamaz.");
        }


    }

    @Override
    public List<Appointment> filterbyAnimal(AppointmentFilterByAnimalDTO appointmentFilterByAnimalDTO) {
        String queryString = "SELECT a FROM Appointment a WHERE a.animal.id = :animal_id AND a.appointmentDate >= :startDate AND a.appointmentDate <= :endDate";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("animal_id", appointmentFilterByAnimalDTO.getAnimalId());
        query.setParameter("startDate", appointmentFilterByAnimalDTO.getStartDate());
        query.setParameter("endDate", appointmentFilterByAnimalDTO.getEndDate());
        if (appointmentFilterByAnimalDTO.getEndDate().isAfter(appointmentFilterByAnimalDTO.getStartDate())) {
            return query.getResultList();
        } else {
            throw new RuntimeException("Giridiğiniz aralıktaki bitiş tarihi  başlangıç tarihinden küçük olamaz.");
        }

    }

}

