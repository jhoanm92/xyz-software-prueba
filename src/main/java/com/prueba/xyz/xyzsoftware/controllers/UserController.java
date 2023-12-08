package com.prueba.xyz.xyzsoftware.controllers;

import com.prueba.xyz.xyzsoftware.entities.Role;
import com.prueba.xyz.xyzsoftware.entities.User;
import com.prueba.xyz.xyzsoftware.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService service;
    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(this.service.getAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(this.service.getById(id));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody User user) {
        try {
            return ResponseEntity.ok(this.service.save(user));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody User user) {
        try {
            this.service.update(id, user);
            return ResponseEntity.ok("Registro actualizado");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            this.service.delete(id);
            return ResponseEntity.ok("Registro eliminado");
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
