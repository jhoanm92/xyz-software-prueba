package com.prueba.xyz.xyzsoftware.services.interfaces;

import com.prueba.xyz.xyzsoftware.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> getById(Integer id);
    List<User> getAll();
    User save(User user);
    void update(Integer id, User user) throws Exception;
    void delete(Integer id) throws Exception;
}
