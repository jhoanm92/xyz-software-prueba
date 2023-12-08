package com.prueba.xyz.xyzsoftware.services.implementations;

import com.prueba.xyz.xyzsoftware.entities.Appointment;
import com.prueba.xyz.xyzsoftware.entities.User;
import com.prueba.xyz.xyzsoftware.repositories.AppointmentRepository;
import com.prueba.xyz.xyzsoftware.services.interfaces.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public Optional<Appointment> getById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Appointment save(Appointment appointment) {
        appointment.setCreatedAt(LocalDateTime.now());

        return this.repository.save(appointment);
    }

    @Override
    public void update(Integer id, Appointment appointment) throws Exception {
        Optional<Appointment> appointmentO = this.repository.findById(id);

        if (appointmentO.isEmpty()) throw new Exception("Registro no encontrado");

        Appointment appointmentDb = appointmentO.get();
        appointmentDb.setUpdatedAt(LocalDateTime.now());
        appointmentDb.setName(appointment.getName());

        this.repository.save(appointmentDb);
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<Appointment> appointmentO = this.repository.findById(id);

        if (appointmentO.isEmpty()) throw new Exception("Registro no encontrado");

        Appointment appointmentDb = appointmentO.get();
        appointmentDb.setDeletedAt(LocalDateTime.now());

        this.repository.save(appointmentDb);
    }
}
