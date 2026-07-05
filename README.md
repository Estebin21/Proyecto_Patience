# Proyecto Patience

Sistema de gestión médica básica para el consultorio **MedCare**, desarrollado con
**OpenXava**. Permite gestionar pacientes, médicos, citas, diagnósticos e historial
clínico desde una aplicación web sencilla.

Proyecto académico de la asignatura **ISWZ3207 — Validación y Verificación de Software**,
Facultad de Ingenierías y Ciencias Aplicadas, Universidad de Las Américas (UDLA).

## Equipo — Grupo 6
- Sebastián Almeida
- Tomás López
- Esteban Narváez
- Jessica Olalla
- Tomás Ontaneda

**Docente:** Carlos Balladares

## Funcionalidades
- Registro y consulta de **pacientes** (con algoritmo de validación de cédula ecuatoriana).
- Registro y gestión de **médicos**.
- Creación y administración de **citas** médicas.
- Registro de **diagnósticos** asociados a las citas.
- Consulta del **historial clínico** del paciente.
- Control de acceso por roles: **Administrador** y **Médico**.

## Stack técnico
| Componente | Tecnología |
|---|---|
| Framework (Time-to-Market) | OpenXava 7.7.1 |
| Lenguaje / JDK | Java — Eclipse Temurin JDK 11 |
| Persistencia | JPA (Jakarta / javax.persistence) + Hibernate |
| Base de datos | HSQLDB embebida (desarrollo) |
| Servidor | Apache Tomcat (embebido) |
| Gestor de dependencias | Maven |
| IDE | IntelliJ IDEA |

## Cómo ejecutar
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Estebin21/Proyecto_Patience.git
   ```
2. Abrir el proyecto en IntelliJ IDEA (con **JDK 11** configurado).
3. Ejecutar la aplicación con Maven (goal `install` / clase de arranque de OpenXava).
4. Abrir en el navegador:
   ```
   http://localhost:8080/Patience
   ```
5. Iniciar sesión con el usuario por defecto de OpenXava:
   - **Usuario:** `admin`
   - **Contraseña:** `admin`

## Estructura del proyecto
```
src/main/java/com/patience/Patience/model/
├── Paciente.java        # Entidad + validarCedula(), calcularEdad(), clasificarPaciente()
├── Medico.java
├── Usuario.java
├── Cita.java
├── Diagnostico.java
├── Genero.java          # enum
├── EstadoCita.java      # enum
├── Rol.java             # enum
└── PruebaCajaBlanca.java # prueba de caja blanca del algoritmo validarCedula()
```

## Pruebas
El proyecto incluye pruebas de **caja blanca** sobre el algoritmo `validarCedula()`.
Para ejecutarlas, correr la clase `PruebaCajaBlanca` (imprime en consola los casos
CB-01 a CB-05 con cobertura de sentencia y decisión al 100%). Las pruebas de caja negra
(casos de uso, partición de equivalencia, valores límite y funcionales QA) se documentan
en los entregables.

## Documentos entregables
Los documentos del proyecto (SRS, casos de uso, arquitectura C4, diseño de clases y base
de datos, informe final de pruebas) se encuentran en la carpeta `/Entregables` de este
repositorio.

## Estado del proyecto
Versión funcional para fines académicos. Las pruebas de caja negra detectaron defectos
conocidos pendientes de corrección (validación de formato de correo y de fecha futura en
citas), documentados en el informe final. No apto para producción sin esas correcciones.
