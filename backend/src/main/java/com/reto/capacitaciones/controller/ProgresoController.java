package com.reto.capacitaciones.controller;

import com.reto.capacitaciones.model.Progreso;
import com.reto.capacitaciones.model.Usuario;
import com.reto.capacitaciones.model.Curso;
import com.reto.capacitaciones.repository.ProgresoRepository;
import com.reto.capacitaciones.repository.UsuarioRepository;
import com.reto.capacitaciones.repository.CursoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST encargado de gestionar el ciclo de vida del aprendizaje.
 */
@RestController
@RequestMapping("/api/progreso")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgresoController {

    private final ProgresoRepository progresoRepository;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    /**
     * Inyección de dependencias mediante constructor.
     */
    public ProgresoController(ProgresoRepository progresoRepository,
            UsuarioRepository usuarioRepository,
            CursoRepository cursoRepository) {
        this.progresoRepository = progresoRepository;
        this.usuarioRepository = usuarioRepository;
        this.cursoRepository = cursoRepository;
    }

    /**
     * Registra el inicio de un curso para un usuario específico.
     */
    @PostMapping("/iniciar")
    public ResponseEntity<Progreso> iniciarCurso(@RequestParam String username, @RequestParam Long cursoId) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Verificación de integridad: Evitar duplicar el inicio de un mismo curso
        List<Progreso> historial = progresoRepository.findByUsuarioUsername(username);
        boolean yaIniciado = historial.stream()
                .anyMatch(p -> p.getCurso().getId().equals(cursoId));

        if (yaIniciado) {
            return ResponseEntity.badRequest().build();
        }

        Progreso progreso = new Progreso();
        progreso.setUsuario(usuario);
        progreso.setCurso(curso);
        progreso.setEstado("INICIADO");

        return ResponseEntity.ok(progresoRepository.save(progreso));
    }

    /**
     * Marca un curso como completado.
     */
    @PostMapping("/completar")
    public ResponseEntity<?> completarCurso(@RequestParam String username, @RequestParam Long cursoId) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Búsqueda de progreso previo para actualización de estado
        List<Progreso> historial = progresoRepository.findByUsuarioUsername(username);
        Progreso progresoExistente = historial.stream()
                .filter(p -> p.getCurso().getId().equals(cursoId) && "INICIADO".equals(p.getEstado()))
                .findFirst()
                .orElse(null);

        if (progresoExistente != null) {
            // Caso: El usuario ya había iniciado el curso, procedemos a actualizarlo
            progresoExistente.setEstado("COMPLETADO");
            return ResponseEntity.ok(progresoRepository.save(progresoExistente));
        } else {
            // Caso: Registro directo como completado (sin inicio previo registrado)
            Progreso nuevoProgreso = new Progreso();
            nuevoProgreso.setUsuario(usuario);
            nuevoProgreso.setCurso(curso);
            nuevoProgreso.setEstado("COMPLETADO");
            return ResponseEntity.ok(progresoRepository.save(nuevoProgreso));
        }
    }

    /**
     * Obtiene el historial completo de actividades de un usuario.
     */
    @GetMapping("/usuario/{username}")
    public ResponseEntity<List<Progreso>> obtenerProgresoUsuario(@PathVariable String username) {
        List<Progreso> historial = progresoRepository.findByUsuarioUsername(username);
        return ResponseEntity.ok(historial);
    }
}