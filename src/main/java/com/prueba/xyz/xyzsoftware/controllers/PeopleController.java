package com.prueba.xyz.xyzsoftware.controllers;

import com.prueba.xyz.xyzsoftware.entities.People;
import com.prueba.xyz.xyzsoftware.services.interfaces.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    private IPeopleService service;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(this.service.getAll());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("datatable")
    public ResponseEntity getDatatable() {
        try {
            return ResponseEntity.ok(this.service.getDatatable(PageRequest.of(1, 10)));
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
    public ResponseEntity save(@RequestBody People people) {
        try {
            return ResponseEntity.ok(this.service.save(people));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody People people) {
        try {
            this.service.update(id, people);
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
