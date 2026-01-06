package com.reto.capacitaciones;

import com.reto.capacitaciones.model.Curso;
import com.reto.capacitaciones.model.Usuario;
import com.reto.capacitaciones.repository.CursoRepository;
import com.reto.capacitaciones.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CursoRepository repository, UsuarioRepository userRepo) {
		return args -> {
			// Solo insertamos si la base de datos está vacía
			if (repository.count() == 0) {
				repository.save(new Curso(null, "Dominando Angular Material",
						"Creación de interfaces profesionales y responsivas.", "Fullstack", "badge_angular.png"));
				repository.save(new Curso(null, "Java Spring Boot Expert",
						"Arquitectura de microservicios y persistencia con JPA.", "Fullstack", "badge_java.png"));

				// Módulo: APIs e Integraciones
				repository.save(new Curso(null, "Diseño de APIs RESTful",
						"Buenas prácticas, verbos HTTP y seguridad con JWT.", "APIs e Integraciones", "badge_api.png"));
				repository.save(
						new Curso(null, "Mensajería con RabbitMQ", "Comunicación asíncrona entre sistemas complejos.",
								"APIs e Integraciones", "badge_message.png"));

				// Módulo: Cloud
				repository.save(new Curso(null, "AWS Cloud Practitioner", "Fundamentos de la nube, EC2, S3 y RDS.",
						"Cloud", "badge_aws.png"));
				repository.save(new Curso(null, "Docker & Kubernetes",
						"Despliegue de contenedores y orquestación a escala.", "Cloud", "badge_docker.png"));

				// Módulo: Data Engineer
				repository.save(new Curso(null, "Fundamentos de Big Data",
						"Procesamiento de grandes volúmenes de datos con Spark.", "Data Engineer", "badge_data.png"));
				repository.save(new Curso(null, "Modelado de Datos SQL",
						"Optimización de consultas y diseño de esquemas en PostgreSQL.", "Data Engineer",
						"badge_db.png"));
				System.out.println("¡Datos de prueba insertados con éxito!");
			}
			if (userRepo.count() == 0) {
				userRepo.save(new Usuario(null, "admin", "1234", "Desarrollador Junior"));
				System.out.println("¡Usuario de prueba creado: admin/1234!");
			}
		};
	}
}