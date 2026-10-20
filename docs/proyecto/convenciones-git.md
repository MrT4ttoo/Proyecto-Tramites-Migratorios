# Convenciones de Git

## Ramas

Cortas, desde `main` actualizada, una por tarjeta y por persona. Se borran al unir.

| Prefijo | Uso |
|---|---|
| `feature/HU-004-consultar-cartera` | Una historia del backlog |
| `fix/...` | Corrección de un error |
| `docs/...` | Solo documentación |
| `chore/...` | Mantenimiento sin cambio funcional |

## Commits

Conventional Commits en español: `feat(cartera): registrar cliente sin RUEX`, `fix(login): ...`, `docs: ...`.

## Pull requests

- Pequeños, con una sola idea, y enlazan su issue (`Closes #12`).
- Usan la plantilla de `.github/pull_request_template.md`.
- Al menos un revisor distinto del autor y CI en verde. Se unen con squash.
- Los archivos compartidos (`pom.xml`, `application.properties`, `BD_Tramites.sql`, `AGENTS.md`) se cambian en un PR propio.

## Sprints

- Una issue por historia (HU-xxx), etiquetas por carril (`bd`, `backend`, `front`, `docs`) y un milestone por sprint.
- Cierre: tag anotado `sprint-N` sobre `main`, un GitHub Release, `docs/sprints/sprint-N/` y `estado-actual.md` actualizado.
- Un tag es una foto inmutable; no se usan ramas de sprint. Para corregir un sprint cerrado: `release/sprint-N` desde su tag.
- No se etiqueta nada que no esté hecho.
