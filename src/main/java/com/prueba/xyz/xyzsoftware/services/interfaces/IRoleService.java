package com.prueba.xyz.xyzsoftware.services.interfaces;

import com.prueba.xyz.xyzsoftware.entities.People;
import com.prueba.xyz.xyzsoftware.entities.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    Optional<Role> getById(Integer id);
    List<Role> getAll();
    Role save(Role role);
    void update(Integer id, Role role) throws Exception;
    void delete(Integer id) throws Exception;
}
