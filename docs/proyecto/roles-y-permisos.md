# Roles y permisos

El permiso es la combinación de rol, pertenencia al bufete y relación con el cliente o expediente. «Socio» no crea un rol. La administración de la plataforma no concede acceso ordinario a los expedientes.

| Operación | Administrador del bufete | Abogado | Asistente | Revisor | Auditor |
|---|---|---|---|---|---|
| Consultar cartera | Su bufete | Su cartera y casos asignados | Clientes delegados | Casos de revisión asignados | Indicadores minimizados |
| Preparar borrador | Según permiso interno | Caso a su cargo | Delegación vigente | Sin edición ordinaria | No |
| Asignar titular o responsable | Sí, con motivo | Solo con facultad delegada | No | No | No |
| Registrar poder | Personal autorizado | Representación de su cliente | Según delegación | No aprobar el propio | No |
| Revisar y aprobar | Solo si es revisor autorizado e independiente | Solo si es revisor autorizado e independiente | No | Caso asignado e independiente | No |
| Registrar actuación | Solo si también es abogado responsable facultado | Responsable con poder vigente | No | No por ser revisor | No |

## Notas

- Ser administrador no acredita idoneidad profesional.
- El revisor debe ser distinto del abogado responsable y de quien preparó la versión.
- Si el despacho tiene una sola persona, hay que definir un segundo revisor; no hay excepción silenciosa de autoaprobación. Los datos de ejemplo deben incluir al menos dos abogados.
- Toda consulta filtra por bufete y por relación; el servidor valida, no el front.
