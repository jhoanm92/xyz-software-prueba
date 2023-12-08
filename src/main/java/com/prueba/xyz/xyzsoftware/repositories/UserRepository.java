package com.prueba.xyz.xyzsoftware.repositories;

import com.prueba.xyz.xyzsoftware.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
