package com.prueba.xyz.xyzsoftware.repositories;

import com.prueba.xyz.xyzsoftware.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
