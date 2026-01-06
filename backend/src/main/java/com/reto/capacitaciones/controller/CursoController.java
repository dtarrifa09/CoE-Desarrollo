package com.reto.capacitaciones.controller;

import com.reto.capacitaciones.model.Curso;
import com.reto.capacitaciones.repository.CursoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión del catálogo de cursos.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository cursoRepository;

    /**
     * Inyección por constructor.
     */
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    /**
     * Recupera la lista completa de cursos disponibles.
     */
    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        return ResponseEntity.ok(cursos);
    }

    /**
     * Registra un nuevo curso en el sistema.
     */
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoRepository.save(curso);
        return new ResponseEntity<>(nuevoCurso, HttpStatus.CREATED);
    }

    /**
     * Actualiza un curso existente identificado por su ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Curso> editarCurso(@PathVariable Long id, @RequestBody Curso cursoDetalles) {
        return cursoRepository.findById(id)
                .map(curso -> {
                    // Actualización de campos mediante mapeo manual
                    curso.setNombre(cursoDetalles.getNombre());
                    curso.setModulo(cursoDetalles.getModulo());
                    curso.setDescripcion(cursoDetalles.getDescripcion());

                    Curso cursoActualizado = cursoRepository.save(curso);
                    return ResponseEntity.ok(cursoActualizado);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}