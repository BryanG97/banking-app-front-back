# Aplicación bancaria - evaluación full stack (Angular SpringBoot) - Devsu

## Base de Datos
Base de datos utilizada: **PostgreSQL**

1. Crear una base de datos con el nombre `db_banking`
2. Para restaurar la base de datos, dar clic derecho en la base de datos creada y seleccionar "Restore..."
3. Seleccionar el archivo `BaseDatos.sql` y restaurar la base de datos.

## Frontend (Angular)

### Tecnologías
- **Angular**: Versión 17
- **Node.js**: Requiere versión 18 o superior
- **Package Manager**: npm

### Instalación y Ejecución

1. **Instalar dependencias:**
   ```bash
   npm install
   ```

2. **Levantar la aplicación:**
   ```bash
   ng serve
   ```

3. **Acceder a la aplicación:**
   - Abrir navegador en: `http://localhost:4200`

## Backend (Spring Boot)

### Tecnologías
- **Spring Boot**: Versión 4.0.6
- **Java**: Versión 17
- **Build Tool**: Maven
- **Base de Datos**: PostgreSQL

### Instalación y Ejecución

1. **Requisitos previos:**
   - Java 17 instalado
   - Maven 3.6+ instalado
   - PostgreSQL corriendo con la base de datos `db_banking`

2. **Compilar y ejecutar:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Acceder a la API:**
   - Base URL: `http://localhost:8080`
   - Endpoints disponibles en `http://localhost:8080/api/`

### Configuración
- **Archivo de configuración**: `src/main/resources/application.properties`
- **Base de datos**: Configurada para PostgreSQL en `localhost:5432`
- **Puerto por defecto**: 8080