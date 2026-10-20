# AGENTS.md

Plataforma B2B para que abogados y bufetes preparen expedientes migratorios en Panamá. Proyecto del curso Tópicos Especiales I (Caso 2). Este archivo es la fuente única de contexto para cualquier IA o persona nueva en el repo.

## Qué es el producto

- Actor principal: el abogado del bufete. Gestiona su cartera de clientes y prepara expedientes.
- El migrante no tiene cuenta. El SNM presenta y decide por sus canales oficiales; el portal no envía nada al SNM.
- Verificaciones mínimas con TE, CSS y Registro Público. No hay acceso autorizado hoy: los adaptadores son simulados y deben estar etiquetados como simulación, nunca como respuesta oficial.
- Marco legal: Decreto Ley 3 de 2008 y Ley 81 de 2019 (datos mínimos, consentimiento previo).

## Stack

Spring Boot 3.2.3, Java 17, Spring Data JPA, PostgreSQL 15 (Docker), Maven. Calidad: Katalon, SQLMap y SonarQube. Marco de trabajo: Scrum.

## Cómo correrlo

1. `cp .env.example .env` y define `POSTGRES_PASSWORD`.
2. `docker compose up -d` (carga `BD_Tramites.sql` solo con el volumen vacío; para recrear: `docker compose down -v`).
3. `mvn spring-boot:run` (puerto 8081). Pruebas: `mvn clean verify` (usa H2).

## Estructura

Código en `src/main/java/pa/gob/migracion/tramites/`, organizado por feature (`core`, `features/*`, `integraciones`, `shared`). Detalle en `docs/proyecto/arquitectura.md`. Documentos: `docs/INDEX.md`.

## Reglas de trabajo

- Git: ramas cortas desde `main`, un PR por tarjeta, revisión de otra persona, squash. Ver `docs/proyecto/convenciones-git.md`.
- Código: ver `docs/proyecto/convenciones-codigo.md`.
- Las siete reglas de diseño D01 a D07 están en `docs/proyecto/reglas-D01-D07.md` y no se rompen.
- Una tarjeta solo pasa a Terminado si compila, pasa SonarQube y SQLMap, y su flujo se corrobora con Katalon.

## Qué no hacer

- No subir secretos: `.env` está en `.gitignore`.
- No empujar directo a `main` ni forzar push.
- No tocar `pom.xml`, `application.properties`, `BD_Tramites.sql` ni este archivo en un PR de feature; van en un PR propio y corto.
- No inventar estado: lo vigente está en `docs/proyecto/estado-actual.md`. Si un documento contradice a otro, avisar antes de actuar.
- No mencionar ni crear sprints anteriores a la reestructuración.

## Orden de lectura para una IA

`AGENTS.md`, `docs/INDEX.md`, `docs/proyecto/estado-actual.md` y solo lo que la tarea necesite. El backlog (175 historias) no se carga entero: se consulta por tarjeta.
