# Arquitectura

## Paquetes (por feature)

Raíz: `src/main/java/pa/gob/migracion/tramites/`.

```
core/            configuración transversal (seguridad, inicialización)
features/
  auditoria/     consentimiento y bitácora
  expediente/    expedientes, requisitos y versiones
  tramites/      trámites, documentos, usuarios
integraciones/   adaptadores TE, CSS y Registro Público (hoy simulados)
shared/          modelos comunes (roles)
```

Cada feature se organiza en `controller/`, `service/`, `repository/` y `dto/`. Hoy no existe `service/`: la lógica vive en el controlador y debe moverse a servicios.

## Capas

- `controller`: recibe la petición, valida la forma y delega. Sin lógica de negocio ni HTML.
- `service`: reglas de negocio y autorización por recurso (bufete, titular, responsable). Una transacción por operación.
- `repository`: acceso a datos con Spring Data JPA y consultas parametrizadas.
- `dto`: hoy las entidades JPA viven en `dto/`; las respuestas de la API deben ser objetos propios, no entidades.

## Datos

- PostgreSQL con esquemas `snm`, `seg`, `cat`, `priv`, `ext`, `aud`, `met`. `ddl-auto=none`: el esquema lo define `BD_Tramites.sql`, no Hibernate.
- Los cambios de modelo van en un script aditivo (p. ej. `02_B2B_cartera.sql`) sin editar el base. Decidir el almacenamiento documental antes de cambiar los adjuntos (hoy `BYTEA`).

## Seguridad

- Toda lectura filtra por bufete y por relación con el cliente o expediente. Conocer un RUEX o UUID no basta para acceder.
- Contraseñas con bcrypt; ninguna en el código. Credenciales de BD en `.env`.
- Verificaciones con entidades: respuesta booleana, datos mínimos, con consentimiento y sin copiar datos de la entidad.

## Front

HTML, CSS y JavaScript servidos por la aplicación, con menú lateral y vistas Inicio, Clientes, Expedientes y Documentos. Lo rediseña un compañero; no se impone una reescritura.
