package com.reto.capacitaciones.repository;

import com.reto.capacitaciones.model.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgresoRepository extends JpaRepository<Progreso, Long> {
    List<Progreso> findByUsuarioUsername(String username);
}