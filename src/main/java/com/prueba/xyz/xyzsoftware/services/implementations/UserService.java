package com.prueba.xyz.xyzsoftware.services.implementations;

import com.prueba.xyz.xyzsoftware.entities.User;
import com.prueba.xyz.xyzsoftware.repositories.UserRepository;
import com.prueba.xyz.xyzsoftware.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Optional<User> getById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User save(User user) {
        user.setCreatedAt(LocalDateTime.now());

        return this.repository.save(user);
    }

    @Override
    public void update(Integer id, User user) throws Exception {
        Optional<User> userO = this.repository.findById(id);

        if (userO.isEmpty()) throw new Exception("Registro no encontrado");

        User userDb = userO.get();
        userDb.setUpdatedAt(LocalDateTime.now());
        userDb.setPassword(user.getPassword());
        userDb.setAppointment(user.getAppointment());
        userDb.setRole(user.getRole());
        userDb.setUsername(user.getUsername());

        this.repository.save(userDb);
    }

    @Override
    public void delete(Integer id) throws Exception {
        Optional<User> userO = this.repository.findById(id);

        if (userO.isEmpty()) throw new Exception("Registro no encontrado");

        User userDb = userO.get();
        userDb.setDeletedAt(LocalDateTime.now());

        this.repository.save(userDb);
    }
}
