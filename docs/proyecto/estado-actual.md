# Estado actual

Actualizado: 19 de octubre de 2026. Se actualiza en cada PR que cierra un sprint; un estado viejo es peor que ninguno.

## Qué existe (heredado, sin verificar)

- `BD_Tramites.sql`: 7 esquemas, unas 25 tablas, procedimientos, triggers, bitácora con hash y consentimiento Ley 81. Modelo anterior: solicitante con cuenta y funcionario del SNM como revisor.
- Java: 9 entidades JPA, un controlador con login y una página HTML, 3 pruebas. Sin capa de servicios. Los procedimientos almacenados no se llaman desde Java.
- CI en GitHub Actions, pruebas Katalon y configuración de SonarQube.

## Qué no existe

Bufete, cartera, poderes, actuaciones, revisor independiente, adaptadores TE/CSS/Registro Público, front rediseñado y logo nuevo.

## Problemas conocidos del código heredado

- Login con contraseñas escritas en el código y comparación en texto plano; sesiones en un mapa en memoria; `@CrossOrigin("*")`; ninguna ruta valida que el recurso sea del usuario.
- Katalon apunta a `localhost:8080` y la app corre en 8081.
- La CI usa JDK 21 y el `pom.xml` declara Java 17.
- La CI llama a SonarQube sin servidor configurado y sin `SONAR_TOKEN`; pendiente de decidir.
- Nada del repo se ha compilado ni probado desde la reestructuración.

## Siguiente

1. Primer PR: levantar la BD, `mvn clean verify` y arranque en 8081.
2. Elegir la modalidad piloto (matrimonio, educación, pensionado, solvencia o visa de turista).
3. Contrato de datos del carril A (BD) y arranque de los cuatro carriles.
