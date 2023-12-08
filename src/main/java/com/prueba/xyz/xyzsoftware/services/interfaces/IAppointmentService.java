package com.prueba.xyz.xyzsoftware.services.interfaces;

import com.prueba.xyz.xyzsoftware.entities.Appointment;

import java.util.List;
import java.util.Optional;

public interface IAppointmentService {
    Optional<Appointment> getById(Integer id);
    List<Appointment> getAll();
    Appointment save(Appointment appointment);
    void update(Integer id, Appointment appointment) throws Exception;
    void delete(Integer id) throws Exception;
}
