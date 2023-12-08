package com.prueba.xyz.xyzsoftware.controllers;

import com.prueba.xyz.xyzsoftware.entities.Appointment;
import com.prueba.xyz.xyzsoftware.entities.Role;
import com.prueba.xyz.xyzsoftware.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private IRoleService service;

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
    public ResponseEntity save(@RequestBody Role role) {
        try {
            return ResponseEntity.ok(this.service.save(role));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Role role) {
        try {
            this.service.update(id, role);
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
