package com.prueba.xyz.xyzsoftware.repositories;

import com.prueba.xyz.xyzsoftware.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
