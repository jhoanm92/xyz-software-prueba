package com.prueba.xyz.xyzsoftware.services.implementations;

import com.prueba.xyz.xyzsoftware.entities.Appointment;
import com.prueba.xyz.xyzsoftware.entities.Role;
import com.prueba.xyz.xyzsoftware.repositories.RoleRepository;
import com.prueba.xyz.xyzsoftware.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository repository;
    @Override
    public Optional<Role> getById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public List<Role> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Role save(Role role) {
        role.setCreatedAt(LocalDateTime.now());

        return this.repository.save(role);
    }

    @Override
    public void update(Integer id, Role role) throws Exception {
        Optional<Role> roleO = this.repository.findById(id);

        if (roleO.isEmpty()) throw new Exception("Registro no encontrado");

        Role roleDb = roleO.get();
        roleDb.setUpdatedAt(LocalDateTime.now());
        roleDb.setName(roleDb.getName());

        this.repository.save(roleDb);
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<Role> roleO = this.repository.findById(id);

        if (roleO.isEmpty()) throw new Exception("Registro no encontrado");

        Role roleDb = roleO.get();
        roleDb.setDeletedAt(LocalDateTime.now());

        this.repository.save(roleDb);
    }
}
