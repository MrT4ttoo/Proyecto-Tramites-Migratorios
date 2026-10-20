# Plataforma de Trámites Migratorios

Gestión de cartera para abogados y bufetes migratorios en Panamá. El abogado gestiona sus clientes y prepara sus expedientes; el migrante no necesita cuenta y el SNM conserva la presentación y la decisión oficial.

Proyecto del curso Tópicos Especiales I (Caso 2). El alcance, el modelo objetivo y el backlog están en [`docs/Reestructuración/`](docs/Reestructuración/). El índice de toda la documentación está en [`docs/INDEX.md`](docs/INDEX.md).

## Stack

Spring Boot 3.2.3 · Java 17 · Spring Data JPA · PostgreSQL 15 (Docker) · Maven · Katalon, SQLMap y SonarQube para las pruebas de calidad y seguridad.

## Cómo levantarlo

Requisitos: JDK 17 o superior, Maven y Docker.

1. Crear el archivo de credenciales (no se sube a Git):

   ```bash
   cp .env.example .env
   ```

   Edita `.env` y define `POSTGRES_PASSWORD`.

2. Levantar la base de datos. Docker ejecuta `BD_Tramites.sql` solo si el volumen está vacío; para recrearla usa `docker compose down -v` y luego `docker compose up -d`.

   ```bash
   docker compose up -d
   ```

3. Arrancar la aplicación (puerto 8081):

   ```bash
   mvn spring-boot:run
   ```

4. Ejecutar las pruebas (usan H2 en memoria, no necesitan Docker):

   ```bash
   mvn clean verify
   ```

## Estructura

```
BD_Tramites.sql     esquema y datos base de PostgreSQL
docker-compose.yml  base de datos local
src/                código Java (organizado por feature) y pruebas
katalon-tests/      pruebas funcionales de interfaz
security-scans/     configuración de SonarQube y escaneos
docs/               documentación (ver docs/INDEX.md)
```

## Contribuir

Trabajamos con ramas cortas desde `main`, un pull request por tarjeta y revisión de otra persona antes de unir. Las reglas completas estarán en `docs/proyecto/convenciones-git.md`.
