package com.prueba.xyz.xyzsoftware.services.interfaces;

import com.prueba.xyz.xyzsoftware.entities.Appointment;
import com.prueba.xyz.xyzsoftware.entities.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface IPeopleService {
    Page<People> getDatatable(Pageable pageable);
    Optional<People> getById(Integer id);
    List<People> getAll();
    People save(People people);
    void update(Integer id, People people) throws Exception;
    void delete(Integer id) throws Exception;
}
