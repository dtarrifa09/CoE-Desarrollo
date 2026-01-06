package com.reto.capacitaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que gestiona la relación entre los Rockstars y sus desafíos técnicos.
 */
@Entity
@Table(name = "progreso")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Progreso {

    /**
     * Identificador único del registro de progreso.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Referencia al usuario que está realizando el curso.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    /**
     * Referencia al curso asociado al progreso.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    /**
     * Estado actual de la capacitación.
     * Valores esperados: "INICIADO" o "COMPLETADO".
     */
    @Column(nullable = false, length = 20)
    private String estado;

}