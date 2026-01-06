package com.reto.capacitaciones.repository;

import com.reto.capacitaciones.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio de persistencia para la entidad Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Localiza un usuario basándose en sus credenciales completas.
     */
    Optional<Usuario> findByUsernameAndPassword(String username, String password);

    /**
     * Recupera un usuario a partir de su identificador de nombre de usuario.
     */
    Optional<Usuario> findByUsername(String username);
}