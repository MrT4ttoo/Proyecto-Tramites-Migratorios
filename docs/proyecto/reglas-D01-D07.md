# Reglas de diseño D01 a D07

Fuente: la especificación al Sprint 5 en `docs/Reestructuración/`. Si algo aquí contradice a la especificación, vale la especificación.

| Regla | Qué exige | Estado en el código heredado |
|---|---|---|
| D01 | Cliente con `cliente_id` interno y `abogado_titular_id`. El RUEX oficial es opcional: la cartera existe antes del primer expediente. | No cumple: `snm.Extranjero` usa `ruex` como llave y exige usuario. |
| D02 | Expediente con cliente, bufete y responsable. El responsable inicial suele ser el titular; los cambios y su historial son explícitos. | No cumple: tiene `ruex` y `funcionario_id`. |
| D03 | Asignación y representación son relaciones distintas. Tener un cliente asignado no prueba poder, y un poder tampoco abre toda la cartera. | No existe. |
| D04 | El borrador se prepara con poder pendiente; la actuación representativa exige poder aprobado y vigente. | Parcial: faltan las actuaciones. |
| D05 | Revisor independiente, asignado y del mismo bufete. Distinto del responsable y de quien preparó la versión. Se valida en el servidor; no hay autoaprobación. | Parcial: valida rol, no independencia. |
| D06 | Respuesta booleana nullable y estado técnico explícito. Sin conexión o sin referencia no se convierte en «No coincide». | Cumple: conservar. |
| D07 | Versiones e historial de evidencia y parámetros. Una respuesta anterior no valida datos modificados. | Parcial: faltan versión de formulario e invalidación al editar. |

## Principios derivados

- Una sola fuente de verdad: el dato vigente del cliente o del caso determina la responsabilidad actual; el historial no es una fuente concurrente.
- «Coincide» y «No coincide» son respuestas válidas. Una respuesta desconocida tiene `coincide` nulo. Un documento recibido queda «En revisión».
- Sin acceso institucional autorizado, los conectores quedan «Sin conexión».
- Registrar una presentación no equivale a enviarla al SNM.
