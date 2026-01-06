package com.reto.capacitaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa la entidad de un Curso dentro del sistema.
 */
@Entity
@Table(name = "cursos")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    /**
     * Identificador único autoincremental de la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre descriptivo del curso o desafío técnico.
     */
    @Column(nullable = false, length = 100)
    private String nombre;

    /**
     * Detalle sobre los objetivos y contenido del curso.
     */
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    /**
     * Categoría tecnológica a la que pertenece (Ej: Cloud, Fullstack, APIs).
     */
    @Column(nullable = false, length = 50)
    private String modulo;

    /**
     * Nombre o ruta del recurso visual que representa la insignia al completar el
     * curso.
     */
    @Column(name = "imagen_insignia")
    private String imagenInsignia;
}