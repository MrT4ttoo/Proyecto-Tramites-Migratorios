# Convenciones de código

- Java 17, paquetes en minúsculas, clases en `PascalCase`, métodos y variables en `camelCase`.
- Tablas y columnas siguen el estilo del DDL: esquema en minúsculas (`snm`) y tabla con mayúscula inicial (`snm.Cliente(cliente_id, ...)`); claves `<entidad>_id`.
- Endpoints en español y en plural, sin verbos en la ruta: `GET /clientes`, `POST /expedientes/{id}/actuaciones`.
- Errores: mensajes comprensibles al usuario, sin trazas ni detalles internos.
- Consultas siempre parametrizadas; nunca concatenar texto del usuario en SQL.
- No hay secretos en el código ni en los logs. No registrar datos personales en logs.
- Una clase, una responsabilidad. Si un controlador pasa de ~150 líneas, extraer a un servicio.
- Todo cambio de comportamiento trae su prueba. `mvn clean verify` debe pasar antes de abrir el PR.
- Comentarios para explicar el porqué, no el qué. Sin menciones a sprints en comentarios.
