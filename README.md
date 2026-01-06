# Escuela de Rock - Learning Management System (LMS)

¡Bienvenido al Centro de Excelencia Rockstar! Este proyecto es una aplicación Fullstack robusta diseñada para gestionar el aprendizaje de estudiantes de música y tecnología. Combina una interfaz visual impactante con una arquitectura sólida y segura.

## Características Destacadas

### Perfil del Estudiante (Rockstar)

- **Insignias Dinámicas:** Visualización de logros completados con iconos y colores personalizados por categoría (Cloud, Fullstack, APIs, etc.).
- **Contador de Logros:** Seguimiento en tiempo real de los cursos finalizados integrado con el historial del usuario.
- **UX Fluida:** Navegación optimizada para transicionar entre el catálogo de cursos y el perfil personal.

### Administración Avanzada

- **Gestión de Catálogo (CRUD):** Implementación completa para crear y editar cursos sin salir de la vista de perfil.
- **Modales Inteligentes:** Uso de `MatDialog` para formularios de edición y creación, manteniendo el contexto del usuario.
- **Consola de Edición:** Lista maestra con alineación profesional, iconos temáticos y feedback instantáneo mediante `MatSnackBar`.

### Seguridad y Robustez

- **Protección de Rutas (AuthGuard):** Validación a nivel de Router para impedir el acceso no autorizado a rutas privadas (/perfil, /cursos) mediante la URL.
- **Persistencia de Sesión:** Manejo de estado de usuario mediante `localStorage`.
- **CORS Policy:** Configuración global en el backend para permitir una comunicación segura y fluida entre el cliente y el servidor.

---

## Stack Tecnológico

### **Frontend**

- **Angular 19** (Componentes Standalone).
- **Angular Material** (UI Components: Dialogs, Menus, Lists, Snacks).
- **TypeScript** (Tipado fuerte para evitar errores en tiempo de ejecución).
- **Flexbox & CSS3** (Diseño Dark Mode personalizado).

### **Backend**

- **Java 17 / Spring Boot** (API RESTful).
- **Spring Data JPA** (Persistencia y mapeo de entidades).
- **H2 Database** (Base de datos relacional en memoria).
- **Maven** (Gestión de dependencias).

---

## Instalación y Despliegue

### 1. Clonar el repositorio

```bash
# Clona el repositorio
git clone https://github.com/dtarrifa09/CoE-Desarrollo.git

# Entra en la carpeta del proyecto
cd nombre-de-tu-proyecto
```

### 2. Requisitos

- **Node.js** (v18+)
- **JDK 17**
- **Maven**

### 3. Configuración del Backend (Spring Boot)

1. Diríjase a la carpeta del servidor: `cd backend-rockstar`
2. Compile el proyecto: `mvn clean install`
3. Inicie el servidor: `mvn spring-boot:run`
4. La API se ejecutará en: `http://localhost:8080/api/cursos`

### 4. Configuración del Frontend (Angular)

1. Diríjase a la carpeta del cliente: `cd frontend-rockstar`
2. Instale las dependencias: `npm install`
3. Inicie la aplicación: `ng serve`
4. Acceda desde el navegador: `http://localhost:4200`

---

## Estructura de Seguridad Implementada

- `src/app/guards/auth.guard.ts`: Valida la existencia de una sesión activa antes de cargar componentes sensibles.
- `src/app/app.routes.ts`: Definición de rutas protegidas mediante la propiedad `canActivate`.
- `WebConfig.java`: Configuración de CORS en Spring Boot para autorizar métodos GET, POST, PUT y DELETE.

---

## Autor

**Desarrollador**
_Diego Andres Tarrifa Valencia_
