package com.reto.capacitaciones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidad que representa a un usuario dentro del sistema (Rockstar).
 */
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    /**
     * Identificador único autoincremental.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario único utilizado para el inicio de sesión.
     */
    @Column(unique = true, nullable = false, length = 50)
    private String username;

    /**
     * Contraseña de acceso.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Nombre completo o alias del Rockstar para visualización en el perfil.
     */
    @Column(nullable = false, length = 100)
    private String nombre;
}