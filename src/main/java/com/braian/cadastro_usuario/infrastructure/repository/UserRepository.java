package com.braian.cadastro_usuario.infrastructure.repository;

import com.braian.cadastro_usuario.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
