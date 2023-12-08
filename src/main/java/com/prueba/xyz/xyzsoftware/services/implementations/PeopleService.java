package com.prueba.xyz.xyzsoftware.services.implementations;

import com.prueba.xyz.xyzsoftware.entities.People;
import com.prueba.xyz.xyzsoftware.entities.Role;
import com.prueba.xyz.xyzsoftware.repositories.PeopleRepository;
import com.prueba.xyz.xyzsoftware.services.interfaces.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService implements IPeopleService {

    @Autowired
    private PeopleRepository repository;

    @Override
    public Page<People> getDatatable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<People> getById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public List<People> getAll() {
        return this.repository.findAll();
    }

    @Override
    public People save(People people) {
        people.setCreatedAt(LocalDateTime.now());

        return this.repository.save(people);
    }

    @Override
    public void update(Integer id, People people) throws Exception {
        Optional<People> peopleO = this.repository.findById(id);

        if (peopleO.isEmpty()) throw new Exception("Registro no encontrado");

        People peopleDb = peopleO.get();
        peopleDb.setUpdatedAt(LocalDateTime.now());
        peopleDb.setEmail(people.getEmail());
        peopleDb.setDocumentNumber(people.getDocumentNumber());
        peopleDb.setLastNames(people.getLastNames());
        peopleDb.setNames(people.getNames());
        peopleDb.setPhone(people.getPhone());
        peopleDb.setStatus(people.getStatus());

        this.repository.save(peopleDb);
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<People> peopleO = this.repository.findById(id);

        if (peopleO.isEmpty()) throw new Exception("Registro no encontrado");

        People peopleDb = peopleO.get();
        peopleDb.setDeletedAt(LocalDateTime.now());

        this.repository.save(peopleDb);
    }
}
