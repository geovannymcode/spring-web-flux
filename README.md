# 📌 app-webflux

> **Aplicación demo con Spring Boot 3, Spring WebFlux y MongoDB**

![Java](https://img.shields.io/badge/Java-21-blue?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen?style=flat-square)
![WebFlux](https://img.shields.io/badge/Spring%20WebFlux-reactive-orange?style=flat-square)
![MongoDB](https://img.shields.io/badge/Database-MongoDB-green?style=flat-square)

Este es un proyecto de demostración que explora **Spring WebFlux** y la **programación reactiva** en Java con **MongoDB** como base de datos. Es un ejemplo práctico que acompaña el artículo publicado en [geovannycode.com](https://geovannycode.com/introduccion-a-la-programacion-reactiva-y-spring-webflux/).

---

## 🚀 Tecnologías utilizadas
- **Java 21**
- **Spring Boot 3.4.1**
- **Spring WebFlux**
- **MongoDB Reactivo**
- **Project Reactor**
- **Docker Compose** (se inicia automáticamente con la aplicación)
- **JUnit + Reactor Test** (para pruebas)

---

## 📁 Estructura del Proyecto

```plaintext
spring-web-flux/
│── src/main/java/com/goevannycode
│   ├── domain
│   │   ├── Course.java             # Modelo de datos
│   │   ├── CourseRepository.java   # Repositorio reactivo con MongoDB
│   │   ├── CourseService.java      # Lógica de negocio
│   ├── web
│   │   ├── controller
│   │   │   ├── CourseController.java  # Controlador WebFlux
│   │   ├── AppWebfluxApplication.java # Clase principal de la aplicación
│── src/main/resources
│   ├── application.properties       # Configuración de la aplicación
│── test/                             # Pruebas unitarias
│── pom.xml                           # Dependencias y configuración de Maven
│── README.md                         # Documentación del proyecto
```

---

## ⚙️ Configuración del Entorno

Para ejecutar la aplicación, asegúrate de tener instalado:

- **Java 21**
- **Maven 3.8+**
- **Docker** (requerido para la base de datos)

> ⚠️ **Nota**: **MongoDB se inicia automáticamente** con `spring-boot-docker-compose`, por lo que no es necesario ejecutarlo manualmente.

---

## 🚀 Ejecutar la Aplicación

Para compilar y ejecutar el proyecto:

```bash
mvn clean install
mvn spring-boot:run
```

La aplicación se ejecutará en **http://localhost:8080** y MongoDB se iniciará automáticamente en un contenedor Docker.

---

## 🔥 Endpoints

### 🎓 Gestión de Cursos

| Método  | Endpoint          | Descripción                     |
|---------|------------------|---------------------------------|
| `GET`   | `/courses`        | Obtener todos los cursos       |
| `GET`   | `/courses/{id}`   | Obtener un curso por ID        |
| `POST`  | `/courses`        | Crear un nuevo curso           |
| `PUT`   | `/courses/{id}`   | Actualizar un curso existente  |
| `DELETE` | `/courses/{id}`  | Eliminar un curso              |

Ejemplo de **cuerpo de petición (POST/PUT)**:

```json
{
  "name": "Spring WebFlux",
  "category": "Programación Reactiva"
}
```

---

## ✅ Pruebas

Para ejecutar las pruebas unitarias:

```bash
mvn test
```
---

## 📚 Referencias

- 📄 **Artículo:** [Introducción a la Programación Reactiva y Spring WebFlux](https://geovannycode.com/introduccion-a-la-programacion-reactiva-y-spring-webflux/)
- 📖 **Spring WebFlux Documentation:** [Spring Docs](https://docs.spring.io/spring-framework/reference/web/webflux.html)

---

## 🌟 Conéctate conmigo
¡Sígueme para más contenido y proyectos como este!

- Web: [Geovanny Mendoza](https://geovannycode.com/)
- GitHub: [@geovannymcode](https://github.com/geovannymcode)
- Twitter: [@geovannycode](https://x.com/geovannycode)
- LinkedIn: [Geovanny Mendoza](https://www.linkedin.com/in/geovannycode/)
- Bluesky: [Geovanny Mendoza](https://bsky.app/profile/geovannycode.bsky.social)

---

¡Espero que este README documente bien tu proyecto! 🚀🔥