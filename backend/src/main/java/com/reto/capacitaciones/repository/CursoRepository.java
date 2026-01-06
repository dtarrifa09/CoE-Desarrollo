package com.reto.capacitaciones.repository;

import com.reto.capacitaciones.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    // Aquí ya tenemos métodos como save(), findAll(), deleteById().
}
