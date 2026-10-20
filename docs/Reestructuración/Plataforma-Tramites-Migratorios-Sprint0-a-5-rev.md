PLATAFORMA DE TRÁMITES MIGRATORIOS Gestión de cartera para abogados y bufetes · Panamá

TÓPICOS ESPECIALES I · CASO 2 · ESPECIFICACIÓN ACTUALIZADA

# Plataformade Trámites Migratorios

Documento descriptivo actualizado del Caso 2. Organización hipotética desde el Sprint 0 hasta el Sprint 5, con los diagramas alineados al abogado como actor principal y una especificación para orientar el siguiente desarrollo.

B2B · BUFETES DE ABOGADOS SPRING BOOT · JPA POSTGRESQL TE · CSS · REGISTRO PÚBLICO LEY 81 DE 2019

ACTOR PRINCIPAL PROBLEMA QUE ATIENDE CORTE DEL DOCUMENTO

|Abogado con clientes|Preparación lenta,|Sprint 5 como punto de|
|---|---|---|
|asignados|documentos repetidos y comprobaciones manuales|planificación y revisión del alcance|

### 6 16 12 175

sprints documentados (0–5) sprints en el plan global diagramas del modelo objetivo historias en el backlog anexo

CURSO CORTE VERSIÓN D O C U M E N TA L Tópicos Especiales I Especificación al Sprint 5 17 de octubre de 2026

CONTENIDO Trámites Migratorios · Especificación al Sprint 5

## Contenido

Especificación del Caso 2 al corte del Sprint 5: producto, modelo objetivo, datos, integración, seguridad y cierre.

PRODUCTO Y ALCANCE

|Decisión de producto y estado||Caso 2 y resultado que se busca||
|---|---|---|---|
||03||04|
|Alcance del corte en Sprint 5|05|Organización de los sprints 0 al 5|06|
|Roles y matriz de acceso|08|Decisiones que unifican los diagramas|09|
|Modelo objetivo del producto|10|Arquitectura existente y objetivo|13|
|Modelo de datos objetivo|14|Flujos de datos|21|
|Verificaciones con entidades|23|Transición del modelo heredado|24|
|Contrato de operaciones|25|Seguridad y privacidad|27|
|Calidad y medición|28|||
|Backlog y cierre del corte Referencias y condiciones|29|Trazabilidad de las correcciones|30|

0011 Quién contrata, quién trabaja y cómo leer el 0022 Problema, respuesta del producto y beneficio a avance medir

0033 0044 Núcleo prioritario y modalidades Secuencia, evidencia y relación con el Sprint 0

0055 0066 Permisos por rol, bufete y relación Reglas D01 a D07

MODELO OBJETIVO

0077 0088 Contexto, casos de uso y estados Copia local revisada frente al diseño

0099 1100 Conceptual, físico, clases y representación DFD de nivel 1 y nivel 2 de la cartera

INTEGRACIÓN, SEGURIDAD Y CALIDAD

1111 1122 TE, CSS y Registro Público Del modelo anterior al modelo B2B

1133 1144 Cartera, revisión y reglas transaccionales Lo que debe demostrar el backend

1155 Herramientas y aporte al Caso 2

CIERRE

1166 1177 175 historias y orden de entrega Figuras corregidas y reglas relacionadas

118831 Fuentes, normas y pendientes

El abogado gestiona su cartera de clientes; el migrante no necesita una cuenta y el SNM **“** conserva la presentación y la decisión oficial.

Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026

|0 011||01 · DECISIÓN DE PRODUCTO Y ESTADO DECISIÓN DE PRODUCTO|Quién contrata, quién trabaja y cómo leer el avance del proyecto. El bufete contrata; su personal prepara; el SNM decide presentación y decisión oficial por sus canales.|Decisión de producto y lectura del estado El bufete contrata el servicio; su personal autorizado prepara los expedientes. Cada abogado trabaja sobre su cartera de clientes. El migrante aporta sus datos y documentos, sin necesitar cuenta. El SNM conserva la|Trámites Migratorios · Especificación al Sprint 5|
|---|---|---|---|---|---|
||Bufete personal.|Contrata el servicio B2B y organiza a su|Abogado Gestiona su cartera, prepara y registra actuaciones. Cómo interpretar el estado del proyecto funcionalidades al Sprint 6 se sustituye por un corte documental en Sprint 5.|Cliente migrante Entrega datos y documentos; no tiene cuenta. El documento separa la evidencia del avance y el diseño del producto. La numeración anterior que atribuía|SNM Presentación y decisión oficial fuera del portal.|
||REPORTADO|mostrada en el tablero|Información expresada por el equipo o Sprint 3 figura terminado; Sprint 4 aparece en proceso y Sprint 5 contiene tareas de backlog.|EXISTENTE revisada seguimiento local.|Capacidad identificada en la copia local Portal HTML/CSS/JavaScript, formularios, borradores, carga real de archivos, revisión interna y|
||PROPUESTO|Diseño o regla que debe guiar la implementación entidad.|Cartera por abogado, autorizaciones por relación, representación separada y revisor independiente. Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|PENDIENTE demostrada para uso real. Los diagramas nuevos representan el modelo objetivo del corte Sprint 5. No se rotulan como esquema físico ya desplegado. Los datos de muestra y una respuesta local no se presentan como información oficial de una Versión documental: 17 de octubre de 2026. Esta entrega actualiza la especificación y sus diagramas; no declara construido el producto final ni incorpora la propuesta al backend operativo.|Dependencia o capacidad todavía no Acceso autorizado a TE/CSS/RP, pruebas de aceptación de esos servicios y cierre de seguridad 03|
|||> 50 000|extranjeros afectados · cifra del caso de clase Del problema a la evidencia esperada RESPUESTA DEL PRODUCTO||3 a 8 meses trámites de residencia · cifra del caso de clase EVIDENCIA ESPERADA|
||PROBLEMA repetidos|Documentos|Repositorio por cliente y reutilización autorizada RESPUESTA DEL PRODUCTO||Un documento vigente se vincula a otro caso del mismo cliente sin otra carga. EVIDENCIA ESPERADA|
||PROBLEMA|Validaciones manuales|Comprobación de datos aplicables mediante TE, CSS y RP RESPUESTA DEL PRODUCTO||Se identifica el requisito, la entidad, los campos mínimos y el resultado con su origen. EVIDENCIA ESPERADA|
||PROBLEMA|Casos dispersos|Cartera, responsable, pendientes y actuaciones RESPUESTA DEL PRODUCTO||El abogado encuentra a sus clientes y los casos que tiene a cargo. EVIDENCIA ESPERADA|
||PROBLEMA sensibles|Datos personales BENEFICIO A MEDIR|Finalidad, acceso por relación y datos mínimos Tiempo de preparación y subsanaciones evitables preparados y reducir trabajo previo repetido. Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|El beneficio a medir es el tiempo de preparación y las subsanaciones evitables. La plataforma no controla cuánto tarda el SNM en decidir un trámite. La contribución al Caso 2 consiste en entregar expedientes mejor|No basta conocer un RUEX o UUID para acceder a un expediente. 04|

|0|03 3 01 05|NÚCLEO PRIORITARIO Cartera del abogado Comprobaciones TE/CSS/RP|03 · ALCANCE DEL CORTE EN SPRINT 5 Modalidades ya identificadas|Alcance del corte en Sprint 5 Siete elementos que forman el núcleo del corte 02 Ficha del cliente sin cuenta Revisión 06 independiente|Qué entra en el núcleo, qué modalidades existen y dónde se detiene el alcance. 03 07|Expedientes por modalidad|Trámites Migratorios · Especificación al Sprint 5 04 Campos y adjuntos pertinentes Seguimiento registrado por el abogado|
|---|---|---|---|---|---|---|---|
|ESTADO|||MODALIDADES|||SITUACIÓN DOCUMENTAL||
||IDENTIFICADA|||Matrimonio, educación, jubilado o pensionado, solvencia económica por plazo fijo y visa de turista||presenta como residencia.|Cinco modalidades presentes en el catálogo local. Son formularios de preparación y deben contrastarse con sus fichas oficiales vigentes. La visa de turista no se|
||AMPLIACIÓN||factor forman la evolución comercial. FUERA DEL NÚCLEO información bancaria.|Dependiente de residente permanente y personal contratado en el Área Panamá Pacífico Límite para evitar ampliar el alcance sin control MEDUCA y SBP quedan fuera del núcleo; no se asume acceso a matrícula, depósitos ni Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|Primero se valida un recorrido completo con una modalidad piloto. Licencias anuales, invitaciones y segundo|formularios ya desarrollados. CONEXIÓN CON EL SNM|Dos categorías adicionales mencionadas en el PDF de referencia. Permanecen como ampliación; no se declaran La conexión electrónica con el SNM requiere una decisión y autorización futuras. 05|

04 · ORGANIZACIÓN DE LOS SPRINTS 0 AL 5 Trámites Migratorios · Especificación al Sprint 5

#### Organización hipotética de los sprints 0 al 5

Una secuencia de proyecto con la evidencia o condición de cada corte.

La secuencia siguiente organiza información trabajada en una narrativa de proyecto. Los sprints 0 a 2 son una propuesta de orden, no un historial demostrado. No se añaden horas, responsables, porcentajes ni entregas retrospectivas.

ENFOQUE DE LA SECUENCIA EVIDENCIA O CONDICIÓN DEL CORTE 0 Comprender Caso 2 y delimitar el HIPOTÉTICO problema, actor y objetivo Organización hipotética basada en el enunciado y la orientación B2B acordada.

ENFOQUE DE LA SECUENCIA EVIDENCIA O CONDICIÓN DEL CORTE 1 Describir clientes, expedientes y recorrido HIPOTÉTICO básico de preparación Organización hipotética a partir de las pantallas y del flujo discutido.

ENFOQUE DE LA SECUENCIA EVIDENCIA O CONDICIÓN DEL CORTE 2 Ordenar requisitos, arquitectura inicial y HIPOTÉTICO backlog Organización hipotética; no se atribuyen componentes terminados a este sprint.

ENFOQUE DE LA SECUENCIA EVIDENCIA O CONDICIÓN DEL CORTE 3 Persistencia PostgreSQL y Spring Data JPA, REPORTADO · TERMINADO logo y revisión de persistencia El tablero reporta estas tareas terminadas y el README del repositorio registra SonarQube aprobado, SQLMap sin inyecciones y casos Katalon TC01–TC05.

ENFOQUE DE LA SECUENCIA EVIDENCIA O CONDICIÓN DEL CORTE 4 Mejorar Front-End, habilitar documentos y REPORTADO · EN PROCESO formularios específicos Son las tres tarjetas mostradas en proceso. Se conserva esa condición reportada.

ENFOQUE DE LA SECUENCIA EVIDENCIA O CONDICIÓN DEL CORTE 5 Reorientar cartera del abogado, modelo de PENDIENTE · BACKLOG datos y validadores de campos El tablero muestra BD y validadores en backlog. Esta revisión define sus reglas y diagramas, sin darlos por implementados.

04 · ORGANIZACIÓN DE LOS SPRINTS 0 AL 5 Trámites Migratorios · Especificación al Sprint 5

##### Plan global informado

El plan global informado comprende 16 sprints. Esta versión desarrolla únicamente el corte 0–5; el backlog final conserva trabajo posterior sin adjudicarlo a un sprint todavía 16 no planificado. SPRINTS

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 Corte 0–5 desarrollado en esta versión Backlog final: trabajo posterior sin sprint asignado

##### Relación con el Sprint 0 entregado

El documento del Sprint 0 (revisión del 3 de septiembre de 2026) definió lo siguiente.

DEFINIÓ DEFINIÓ El problema del Caso 2 El marco legal Decreto Ley 3 de 2008 y Ley 81 de 2019.

DEFINIÓ DEFINIÓ El equipo Scrum Las historias HU**‐**01 a HU**‐**05 Con el solicitante extranjero como actor.

ESTA VERSIÓN CONSERVA Y REORIENTA Ese problema.El actor principal al abogado del La consulta booleana coincide / nobufete coincide. De solicitante extranjero a abogado del bufete. La Definición de Terminado: compilación Java, SonarQube, SQLMap y Katalon Studio.

CAMBIO DE ACTOR PRINCIPAL

SPRINT 0 · 3 DE SEPTIEMBRE DE 2026 CORTE SPRINT 5 · ESTA VERSIÓN Solicitante extranjero Abogado del bufete Historias HU-01 a HU-05 175 historias en el backlog anexo

La correspondencia entre las historias anteriores y las nuevas tarjetas figura en el anexo del backlog.

05 · ROLES Y MATRIZ DE ACCESO Trámites Migratorios · Especificación al Sprint 5

### Roles y matriz de acceso

Quién puede consultar, preparar, asignar, aprobar y actuar sobre cada expediente.

PRINCIPIO DE PERMISOS Los permisos combinan rol, pertenencia al bufete y relación con el cliente o expediente. El término socio no crea un rol adicional. La administración de la plataforma no concede acceso ordinario a los expedientes.

Pertenencia al Relación con el Rol+ + =Permiso bufete cliente o expediente

|OPERACIÓN|ADMINISTRADOR DEL BUFETE|ABOGADO|ASISTENTE|REVISOR|AUDITOR|
|---|---|---|---|---|---|
|Consultar cartera|Su bufete|Su cartera y casos asignados|Clientes delegados|Casos de revisión asignados|Indicadores minimizados|
|Preparar borrador|Según permiso interno|Caso a su cargo|Delegación vigente|Sin edición ordinaria|No|
|Asignar titular o responsable|Sí, con motivo|Solo facultad expresamente delegada|No|No|No|
|Registrar poder|Personal autorizado|Representación de su cliente|Según delegación|No aprobar el propio|No|
|Revisar y aprobar|Solo si es revisor autorizado e independiente|Solo si es revisor autorizado e independiente|No|Caso asignado e independiente|No|
|Registrar actuación|Solo si también es abogado responsable facultado|Responsable con poder vigente|No|No por ser revisor|No|

Permitido Condicionado Alcance acotado Restringido No

Ser administrador no acredita idoneidad profesional. Si el despacho tiene una sola persona, se requiere El revisor debe ser distinto del abogado responsable y definir un segundo revisor; no se introduce una de quien preparó la versión. excepción silenciosa de autoaprobación.

|0|06 6 CÓDIGO|06 · DECISIONES QUE UNIFICAN LOS DIAGRAMAS diagramas REGLA DE DISEÑO|Decisiones que unifican todos los Siete reglas de diseño, D01 a D07, y la consecuencia de cada una.|Trámites Migratorios · Especificación al Sprint 5 CONSECUENCIA|
|---|---|---|---|---|
|||Cliente con cliente_id interno y||La cartera existe antes del primer expediente;|
||D01|abogado_titular_id Expediente con cliente, bufete y abogado||el RUEX oficial puede estar vacío. El responsable inicial normalmente es el titular;|
||D02|responsable Asignación y representación son relaciones||cambios e historial son explícitos. Tener un cliente asignado no prueba poder; un|
||D03 D04|distintas Borrador con poder pendiente; actuación con poder vigente Revisor independiente, asignado y del||poder tampoco abre toda la cartera. Se permite preparar sin frenar el trabajo; se bloquea la actuación representativa no habilitada. Se rechaza la autoaprobación también en el|
||D05|mismo bufete Respuesta booleana nullable y estado||servidor. Sin conexión o sin referencia no se convierte|
||D06 D07 por qué.|técnico explícito Versiones e historial de evidencia y parámetros Historial de asignaciones. El historial de asignaciones registra quién cambió una responsabilidad, cuándo y Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026||en No coincide. Una respuesta anterior no valida datos modificados; una subsanación conserva su origen. Una sola fuente de verdad. El dato vigente del cliente o del caso determina la responsabilidad actual; el historial no constituye una tercera fuente de verdad concurrente. 09|

07 · MODELO OBJETIVO · CORTE DOCUMENTAL SPRINT 5 Trámites Migratorios · Especificación al Sprint 5

### Modelo objetivo del producto

Contexto, casos de uso y recorrido del expediente con el abogado como actor principal.

##### Contexto del producto

##### TE · CSS · Registro Público

Verificación mínima propuesta Acceso institucional pendiente

contratación / consulta / personal coincidencia

gestión autorizada

Servicio Nacional de Migración

Presentación por canal oficial Decisión fuera del portal

datos y presentación poder externa relación operativa externa pendiente o por canal oficial

Figura 5.1 Las líneas discontinuas distinguen relaciones externas pendientes o realizadas por canales oficiales. No representan una

conexión operativa. El proveedor gestiona el servicio sin consultar ordinariamente el contenido de las carteras.

##### Relación operativa Entidades SNM externo

|Bufete, abogado y cliente|TE, CSS y Registro Público:|La presentación y la decisión|
|---|---|---|
|trabajan dentro de la plataforma|verificación mínima propuesta;|ocurren por el canal oficial, fuera|
|con permisos por relación.|acceso pendiente.|del portal.|

||||07 · MODELO OBJETIVO · CORTE DOCUMENTAL SPRINT 5|Casos de uso con el abogado como actor principal|||Trámites Migratorios||· Especificación al Sprint 5|
|---|---|---|---|---|---|---|---|---|---|
|A Ab bo A As siis Figura 6.1|og ga ad do o p stte en ntte e d de Abogado principal CU01 a CU07: de consultar la cartera a registrar un poder.|prriin nc ciip pa all elle eg ga ad do o|legal. El SNM no inicia sesión en este portal.|Portal B2B de preparación y gestión de casos CU01 Consultar mi cartera CU02 Gestionar cliente CU03 Preparar borrador CU04 Adjuntar por requisito CU05 Verificar TE CSS RP CU06 Registrar actuación CU07 Registrar poder Límite del portal Asistente delegado CU03, CU04 y CU07, con delegación del abogado. Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|Cada línea une un actor con un caso de uso Casos de uso de esta edición. Los actores están fuera del límite del portal. La asistencia exige delegación; la revisión exige independencia. Registrar un poder es distinto de decidir su aceptación. Asignar cartera no concede representación permisos.|CU08 Asignar cartera CU09 Administrar permisos CU10 Revisar documentos CU11 Decidir representación Administrador CU08 y CU09: asignar cartera y administrar|Revisor|A Ad dm miin niis R Re ev iin nd de ep pe en independiente CU10 y CU11: revisar documentos y decidir representación.|sttrra ad do orr viis so orr nd diie en ntte e 11|

07 · MODELO OBJETIVO · CORTE DOCUMENTAL SPRINT 5 Trámites Migratorios · Especificación al Sprint 5

Recorrido y estados sin confundir al SNM

remitir aprobar completo internamente

preparar nueva versión observar requisito poder / canal oficial

abrir corrección

Fase interna Corrección interna Seguimiento externo ante SNM

Figura 8.1 La fase interna y el seguimiento externo son atributos separados. Una cita futura puede anotarse en un expediente

presentado. No se usa Rechazado para confundir observación interna con una resolución desfavorable de la autoridad.

|ESTADO DE ORIGEN|TRANSICIÓN|ESTADO DE DESTINO|
|---|---|---|
|Borrador|remitir completo|En revisión interna|
|En revisión interna|aprobar internamente|Listo para presentar|
|En revisión interna|observar requisito|Requiere subsanación|
|Requiere subsanación|abrir corrección|Nuevo borrador vinculado|
|Nuevo borrador vinculado|preparar nueva versión|Borrador|
|Listo para presentar|poder / canal oficial|Seguimiento ante SNM|

Atributos separados Cita futura Sin «Rechazado» La fase interna y el seguimiento Una cita futura puede anotarse No se usa Rechazado para externo son atributos separados. en un expediente presentado. confundir observación interna con una resolución desfavorable de la autoridad.

08 · ARQUITECTURA EXISTENTE Y OBJETIVO Trámites Migratorios · Especificación al Sprint 5

### Arquitectura existente y arquitectura objetivo

Copia local revisada frente al diseño que orienta el siguiente desarrollo.

DISEÑO QUE ORIENTA EL COMPONENTE EXISTENTE COPIA LOCAL REVISADA OBJETIVO SIGUIENTE DESARROLLO

|HTML, CSS y JavaScript servidos con la|Conservar la base visual con menú lateral|
|---|---|
|aplicación|y vistas distintas: Inicio, Clientes, Expedientes y Documentos.|

Interfaz

Servicios de cartera, expedientes,

|Java con Spring Boot; JPA y consultas|representación, documentos, verificación|
|---|---|
|JDBC en el portal|y seguimiento con autorización por recurso.|

Servidor

|PostgreSQL; extensiones portal V1 y V2;|Modelo unificado por cliente_id y bufete;|
|---|---|
|adjuntos BYTEA|decidir almacenamiento documental antes de cambiarlo.|

Persistencia

Adaptadores TE/CSS/RP con contrato, Comparación local y marcas Sin conexión minimización, origen, errores y vigencia. institucional Verificación No hay acceso autorizado disponible.

React, Flyway, SSE, almacenamiento

|No se confirma el conjunto tecnológico|externo y todas las escrituras por|
|---|---|
|atribuido al Sprint 6|procedimientos no se dan por implantados.|

Evolución

ARQUITECTURA OBJETIVO

Modular y coherente con la base disponible La arquitectura objetivo sigue siendo modular y coherente con la base disponible. La selección de herramientas de calidad conserva Java, Katalon, SQLMap y SonarQube. No se impone una reescritura del Front-End para lograr cartera y verificaciones.

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

### Modelo de datos objetivo

Cartera, representación y evidencia: entidades, relaciones y claves del modelo conceptual, físico y de clases.

##### Modelo conceptual de cartera y representación

|1 bufete : N clientes||1 bufete : N usuar ios 1 titular :|responsable / revisor|
|---|---|---|---|
|||N clientes||
|1 cliente : 0..N poderes||1 cliente : 0..N ca sos|1 caso : N requisitos|

1 actor : N cambios

1 caso :

0..N actos
requisito verificable

Figura 11.1 Cada cliente tiene un titular actual; cada expediente tiene un responsable actual y un revisor distinto. Ambos abogados

pertenecen al bufete del recurso. La representación vincula además al abogado habilitado. El documento tiene identificador propio; SHA-256 es su huella, no su identidad de negocio.

Titular y responsable Bufete del recurso Huella del documento

|Cada cliente tiene un titular|Ambos abogados pertenecen al|El documento tiene identificador|
|---|---|---|
|actual; cada expediente tiene|bufete del recurso. La|propio;|
|un responsable actual y un revisor distinto.|representación vincula además al abogado habilitado.|su identidad de negocio.|

SHA-256 es su huella, no

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

Modelo físico objetivo de cartera y expedientes

1:N

1:N FK titular actor del del cliente cambio

responsable / 1 : 0..N revisor

1 : 0..N

Figura 11.2 FK compuestas obligatorias: Cliente(bufete_id, abogado_titular_id) → Miembro; Expediente(bufete_id, cliente_id) →

Cliente; Expediente(bufete_id, responsable_id o revisor_id) → Miembro. Una FK no verifica por sí sola el rol profesional: el servicio comprueba rol, actividad y permiso. responsable_id representa abogado_responsable_id.

FK compuestas obligatorias Rol profesional Una FK no verifica por sí sola el rol

|Cliente(bufete_id,|abogado_titular_id)|||
|---|---|---|---|
|→ Miembro||||
|Expediente(bufete_id, → Cliente|cliente_id)|||
|Expediente(bufete_id,|responsable_id|o revisor_id)||
|→ Miembro|||responsable_id abogado_responsable_id.|

profesional: el servicio comprueba rol, actividad y permiso.

Nombre de campo representa

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

Modelo físico objetivo de evidencia y comprobaciones

<u>1 versión :</u> N requisitos

0..N comprobaciones vínculo de evidencia
1 consulta : N intentos finalidad autorizada

Figura 11.3 Modelo propuesto, no inventario de tablas ya desplegadas. La revisión de concurrencia, la versión del formulario y la

política aplicable son conceptos distintos. Al editar parámetros, la consulta vigente se invalida y su historial permanece. Las referencias se expresan por cliente_id, no por una cuenta del migrante.

##### Conceptos distintos Consulta vigente Referencias

|La revisión de concurrencia, la|Al editar parámetros, la consulta|Las referencias se expresan por|
|---|---|---|
|versión del formulario y la política|vigente se invalida y su historial||
|aplicable son conceptos distintos.|permanece.|del migrante.|

cliente_id, no por una cuenta

Modelo propuesto. No es un inventario de tablas ya desplegadas.

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

##### Clases del dominio con responsabilidades claras

1 : 0..1 vigente 1:N 1:N 1 actor : N cambios

1 : 0..N 1 : 0..N

1 : 0..N 1 caso : N requisitos N : 1 entidad vínculo por requisito

1 : 0..N

Figura 11.4 Las multiplicidades se expresan por relación. Cliente tiene un titular Miembro; Expediente un responsable y un revisor

Miembro distinto. Representación enlaza Cliente y abogado. Asignación y Actuación son clases distintas; la licencia pertenece al Bufete y no al migrante. No se incluye un funcionario del SNM como revisor de la aplicación.

##### Titular y revisor Clases distintas Multiplicidades

|Cliente tiene un titular Miembro;|Asignación y Actuación son|Las multiplicidades se expresan|
|---|---|---|
|Expediente un responsable y un revisor Miembro distinto. Representación enlaza Cliente|clases distintas; la licencia pertenece al Bufete y no al migrante.|por relación.|

y abogado.

Fuera del modelo. No se incluye un funcionario del SNM como revisor de la aplicación.

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

##### Representación separada de titularidad y cuenta

1 cliente :

0..N N poderes :
poderes 1 abogado

1 titular actual evidencia del poder

revisión con trazabilidad

relación entre entidades (cardinalidad en la etiqueta)

Figura 11.5 EN_REVISION no impide preparar el borrador. Actuar exige asignación operativa, facultad profesional y representación

aprobada, vigente y no revocada para el alcance. Una casilla de autorización no sustituye el poder ni la evidencia de tratamiento de datos. No existe Cliente.usuario_id como cuenta de acceso en el modelo objetivo.

REGLA DE REPRESENTACIÓN Actuar exige tres condiciones

1 Asignación operativa 2 Facultad profesional 3 Representación aprobada, vigente y no revocada para el alcance

EN_REVISION La casilla no basta Sin cuenta de cliente EN_REVISION no impide

|Una casilla de|No existe|
|---|---|
|autorización no sustituye||
|el poder ni la evidencia de|como cuenta de acceso|
|tratamiento de datos.|en el modelo objetivo.|

preparar el borrador. Cliente.usuario_id

|ENTIDAD DE ORIGEN||RELACIÓN||ENTIDAD DE DESTINO|
|---|---|---|---|---|
|Cliente|→ 1 cliente : 0..N poderes||→|Representación|
|Representación|→ N poderes : 1 abogado||→|Abogado del bufete|
|Cliente|→|1 titular actual|→|Titularidad de cartera|
|Representación|→ evidencia del poder||→|Documento del poder|
|Documento del poder|→ revisión con trazabilidad||→|Decisión independiente|

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

DFD de registro y decisión de representación

datos y archivo registro referenciado EN_REVISION

<u>poder / decisión</u>

decisión evento de fundamentada decisión

entidad externa proceso almacén de datos flujo de datos flujo en ambos sentidos

Figura 11.6 En el proceso 9.0, los subprocesos 9.1 y 9.2 operan con sesión, bufete y relación autorizados. D1 devuelve el estado de

representación al proceso y este devuelve el resultado al solicitante autorizado. La cartera se resuelve en el proceso 3.0, no dentro del poder. El proveedor no decide poderes de clientes por administrar una licencia.

Sesión, bufete y relación D1 devuelve el estado En el proceso 9.0, los subprocesos D1 devuelve el estado de representación al

9.1 y 9.2 operan con sesión, bufete y proceso y este devuelve el resultado al relación autorizados. solicitante autorizado. La cartera va aparte Licencia no es poder La cartera se resuelve en el proceso 3.0, no El proveedor no decide poderes de clientes por dentro del poder. administrar una licencia.

|ORIGEN||FLUJO||DESTINO|
|---|---|---|---|---|
|Abogado o asistente|→ datos y archivo referenciado||→|9.1 Registrar representación|
|9.1 Registrar representación|→ registro EN_REVISION||→|D1 Representaciones|
|D1 Representaciones|↔ poder / decisión||↔|9.2 Resolver revisión|
|Revisor independiente|→ decisión fundamentada||→|9.2 Resolver revisión|
|9.2 Resolver revisión|→ evento de decisión||→|D2 Auditoría|

09 · MODELO DE DATOS Trámites Migratorios · Especificación al Sprint 5

##### Capa organizativa unificada

0..1 vigente : 1 bufete 1:N
1:N

1 : 0..N 1 : 0..N

<u>delegación específica</u> 1 : 0..N 1 : 0..N

relación entre entidades (cardinalidad en la etiqueta)

Figura 11.7 El bufete tiene clientes (1:N) y la titularidad del cliente enlaza a su miembro abogado. La licencia no crea facultad

profesional. Las actuaciones y las asignaciones enlazan al actor del mismo bufete. Una delegación revocada no habilita nuevas consultas, descargas ni edición.

|ENTIDAD DE ORIGEN|RELACIÓN|ENTIDAD DE DESTINO|
|---|---|---|
|Licencia del bufete|0..1 vigente : 1 bufete|Bufete|
|Bufete|1:N|Miembro|
|Bufete|1:N|Expediente|
|Cliente|1 : 0..N|Expediente|
|Expediente|1 : 0..N|Asignación histórica|
|Cliente|1 : 0..N|Representación|
|Expediente|1 : 0..N|Actuación ante el SNM|
|Expediente|delegación específica|Delegación|

La licencia no crea facultad profesional. Una delegación revocada no habilita nuevas consultas, descargas ni edición.

10 · FLUJOS DE DATOS Trámites Migratorios · Especificación al Sprint 5

### Flujos de datos

Nivel 1 del producto B2B y desglose de la cartera del abogado.

DFD de nivel 1 del producto B2B

solicitud / registro / resultado consulta

requisitos aplicables

consulta / registro / respuesta consulta

resultado aplicable

decisión evidencia / independiente decisión

entidad externa proceso almacén flujo ambos sentidos externo, sin acceso

Figura 13.1 Las respuestas de las entidades vuelven a 4.0 y los resultados autorizados se muestran al abogado. La

presentación/resolución oficial sigue fuera del portal. Sesión, roles, representación y auditoría son controles transversales; no se presume una cola, SSE ni notificación institucional ya construidos.

Retorno a 4.0 Fuera del portal Sin presunciones

|Las respuestas de las|La|No se presume una cola,|
|---|---|---|
|entidades vuelven a 4.0 y|presentación/resolución|SSE ni notificación|
|los resultados autorizados|oficial sigue fuera|institucional ya|
|se muestran al abogado.|del portal.|construidos.|

Controles transversales. Sesión, roles, representación y auditoría son controles transversales. SESIÓN ROLES REPRESENTACIÓN AUDITORÍA

10 · FLUJOS DE DATOS Trámites Migratorios · Especificación al Sprint 5

DFD de nivel 2 de la cartera del abogado

criterios / consulta / cartera relación

<u>cliente del mismo bufete</u>

asignación cambio / motivada historial

responsable vigente

datos / caso / resultado actuación

entidad externa subproceso de 3.0 almacén de datos flujo de datos ambos sentidos

Figura 13.2 Desglose de 3.0: 3.1 devuelve al abogado solo la cartera autorizada. 3.2 no otorga representación legal; el poder se

verifica por separado. 3.3 devuelve el estado del caso. Los datos de sesión y permisos se aplican antes de cada lectura o cambio, incluidos archivos y acceso directo por identificador.

|o cambio, incluidos archivos y acceso directo por identificador.|||
|---|---|---|
|3.1 devuelve al abogado|3.2 no otorga|3.3 devuelve el estado|
|solo la cartera autorizada.|representación legal; el|del caso.|

3.1 Consultar 3.2 Asignar 3.3 Mantener
poder se verifica por separado.

Desglose de 3.0. Los datos de sesión y permisos se aplican antes de cada lectura o cambio, incluidos archivos y acceso directo por identificador.

11 · VERIFICACIONES TE/CSS/RP Trámites Migratorios · Especificación al Sprint 5

### Verificaciones con TE, CSS y Registro Público

Hecho verificable previsto y límite de esta especificación para cada entidad prioritaria.

##### Tribunal Electoral Caja de Seguro Registro Público

Social HECHO VERIFICABLE PREVISTO HECHO VERIFICABLE PREVISTO HECHO VERIFICABLE PREVISTO

|Identidad civil panameña o||Inscripción o vínculo registral|
|---|---|---|
|vínculo civil pertinente, como|Relación laboral, afiliación o|pertinente con una finca,|
|el cónyuge de una modalidad|condición aplicable al requisito de|sociedad u otra entidad requerida|
|de matrimonio|la modalidad||
|No se afirma que TE valide|No se consulta por defecto en||
|cualquier pasaporte extranjero.|todos los formularios. No se|Existencia de inscripción no|
|Los campos exactos dependen|presume acceso al historial|equivale a propiedad ni valida|
|del contrato autorizado.|completo de cuotas.|reservas de hotel.|

LÍMITE DE ESTA ESPECIFICACIÓN LÍMITE DE ESTA ESPECIFICACIÓN LÍMITE DE ESTA ESPECIFICACIÓN

##### Flujo objetivo de una verificación

1 3

|2|4|5|
|---|---|---|
|autorización y|adaptador de la|respuesta con|
|relación vigentes|entidad|origen, fecha, referencia y versión de datos|

requisito aplicable parámetros mínimos

No se transmite un expediente completo para comprobar un solo campo.

##### Interpretación de la respuesta

RESPUESTA COINCIDE ESTADO VISIBLE

|Respuesta afirmativa válida|true|Coincide|
|---|---|---|
|Respuesta negativa válida|false|No coincide|
|Sin contrato, error, espera o sin referencia|null|Estado técnico explícito|
|Archivo recibido pendiente de decisión||En revisión documental|

NO ES RESPUESTA DE ENTIDAD

El equipo confirmó que no dispone de acceso autorizado. Las pruebas simuladas deben etiquetarse como tales y no demostrar una conexión oficial. La comprobación manual exige fuente, referencia y actor y conserva un origen distinto de la respuesta electrónica.

|112|12 · TRANSICIÓN DEL MODELO 2 B2B|Objeto objetivo y cambio requerido||Correspondencia y cambio requerido para cada objeto del modelo objetivo.||Transición del modelo heredado al modelo||Trámites Migratorios · Especificación al Sprint 5|
|---|---|---|---|---|---|---|---|---|
||OBJETO OBJETIVO Cliente|Usar|cliente_id migrante.|CORRESPONDENCIA Y CAMBIO REQUERIDO|||como identidad interna. RUEX es dato oficial opcional. heredado identifica al registrador o vínculo técnico; no una cuenta de acceso del|usuario_id|
||Cartera|Añadir||abogado_titular_id||pertenece a un abogado aunque no tenga expediente.||obligatorio y un historial de titularidad. El cliente nuevo|
||Expediente||Vincular responsable_id|bufete_id y||del portal equivale al concepto|cliente_id; mantener un abogado responsable actual.|abogado_responsable_id.|
||Revisión|||personas coincidan con el revisor.|||Vincular revisor asignado e identificar quién preparó la versión. Rechazar que esas||
||Representación||separado.||||Incorporar abogado, cliente, evidencia, facultades, alcance, vigencia y revocación por||
||Evidencia e integración|||||resultados al cambiar sus parámetros, manteniendo historial.|Conservar versiones de formulario, documentos, consultas e intentos. Invalidar||
||Versiones de migración||||||||
|revisada.|V1 · V2 Extensiones del portal presentes en la copia ENCONTRADAS claves o relaciones. aprobaciones.|V1–V13 Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|Secuencia Flyway que describía el PDF. NO ENCONTRADA||La copia revisada contiene extensiones portal V1 y V2; no se encontró la secuencia Flyway V1–V13 que describía el PDF. V14 es una referencia de la propuesta externa, no una migración existente. La siguiente El modelo físico de estas láminas es una meta de diseño. La transición debe preservar los datos y retirar gradualmente los vínculos heredados, sin duplicar personas ni inventar RUEX, integrantes, poderes o|V14 externa. NO EXISTENTE versión debe numerarse según el repositorio real, con respaldo y ensayo de restauración antes de cambiar|Referencia de la propuesta|Siguiente Se numera según el repositorio real. POR DEFINIR 24|

13 · CONTRATO DE OPERACIONES Trámites Migratorios · Especificación al Sprint 5

### Contrato propuesto de cartera y revisión

Operaciones que necesita el backend, con su entrada principal y la autorización exigida.

Las rutas expresan las operaciones que necesita el backend. Deben conciliarse con las rutas existentes antes de programar; no se presentan como endpoints ya disponibles.

|3|7|Por conciliar|
|---|---|---|
|lecturas GET|escrituras POST|con las rutas existentes antes de programar|

10 operaciones propuestas

|OPERACIÓN PROPUESTA|ENTRADA PRINCIPAL|AUTORIZACIÓN Y RESULTADO EXIGIDO|
|---|---|---|
|GET /cartera|Cliente, fase, seguimiento, vencimiento|Filtrar primero por bufete y relación; luego aplicar criterios.|
|GET /clientes/{id}|Identificador interno|Solo titular, responsable relacionado o facultad explícita.|
|POST /clientes/{id}/titular|Abogado destino, motivo, revisión|Administrador autorizado; mismo bufete, rol válido e historial.|
|POST /clientes/{id}/delegaciones|Asistente, alcance, vigencia|Concesión y revocación auditadas; sin acceso global al despacho.|
|POST /expedientes/{id}/responsable|Abogado destino, motivo, revisión|Actualiza el caso; no transfiere toda la cartera del cliente.|
|POST /expedientes/{id}/revisor|Revisor y revisión|Mismo bufete, distinto del responsable y del preparador.|
|POST /expedientes/{id}/vencimiento|Fecha, motivo, revisión|Cambio autorizado, conservando trazabilidad.|
|POST /expedientes/{id}/verificaciones|Requisito y revisión de parámetros|Autorización para la finalidad, campos permitidos y origen del resultado.|
|POST /expedientes/{id}/actuaciones|Tipo, fecha, referencia, revisión|Responsable facultado; poder vigente y transición válida.|
|GET /documentos/{id}|Documento o vínculo autorizado|Misma protección por cliente/caso que el detalle y el listado.|

||13 · REGLAS TRANSACCIONALES procedimientos almacenados.|Procedimientos y reglas transaccionales según la decisión técnica del equipo. No se declara que todas las escrituras actuales pasen por|El diseño admite implementar las operaciones en servicios Java transaccionales o en rutinas de PostgreSQL,|Trámites Migratorios · Especificación al Sprint 5|
|---|---|---|---|---|
|11|AsignarResponsable COMPROBACIONES ANTES DE CONFIRMAR Actor autorizado, caso del bufete, abogado activo, revisor distinto, versión vigente EVIDENCIA QUE CONSERVA Responsable anterior y nuevo, actor, fecha y motivo.||2 2|ConsultarCartera COMPROBACIONES ANTES DE CONFIRMAR Sesión, bufete, titularidad, responsabilidad o delegación vigente EVIDENCIA QUE CONSERVA Resultado filtrado por relación, fase y vencimiento; sin revelar existencia ajena.|
|3 3|RegistrarActuacion COMPROBACIONES ANTES DE CONFIRMAR Responsable, idoneidad acreditada, poder aprobado y vigente, fase y cronología EVIDENCIA QUE CONSERVA Hecho, fecha, referencia, registrador y nuevo estado informado.||4 4|DecidirRevision COMPROBACIONES ANTES DE CONFIRMAR Revisor asignado independiente y versión remitida EVIDENCIA QUE CONSERVA Requisito, documento, decisión, motivo y autor.|
|5 5|AplicarVerificacion COMPROBACIONES ANTES DE CONFIRMAR de datos aún vigente Los nombres comprueba antes de aplicarse.|Consulta correspondiente al requisito y a la revisión sp_AsignarResponsable y externa, no como rutinas ya implementadas. Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|sp_RegistrarActuacion No se mantiene un bloqueo de base durante una llamada a una entidad; una respuesta atrasada se|EVIDENCIA QUE CONSERVA Estado técnico, origen, coincidencia y referencia mínima. se conservan como contratos de la propuesta 26|

14 · SEGURIDAD Y PRIVACIDAD Trámites Migratorios · Especificación al Sprint 5

### Seguridad y privacidad que debe demostrar el backend

Ocho situaciones de prueba y el resultado exigido para cada una.

SITUACIÓN DE PRUEBA RESULTADO EXIGIDO

|Abogado A intenta abrir un cliente de B en el||Denegación salvo una facultad explícita; el|
|---|---|---|
|mismo bufete||filtrado visual no basta.|
|Se cambia un UUID o RUEX para descargar||La descarga no entrega el contenido ni|
|un archivo ajeno||revela información del otro recurso.|
|Un identificador enlaza cliente y abogado de||Claves compuestas y validación de servicio|
|diferentes bufetes||rechazan el vínculo.|
|Un asistente no tiene delegación o esta se||Se deniega el siguiente acceso, incluida la|
|revoca||descarga y la consulta de campos.|
|El responsable intenta aprobar su propia||La decisión es rechazada en el servidor,|
|versión||aunque la petición no use la interfaz.|
|Poder pendiente, vencido o revocado||Se permite la preparación autorizada, pero no la actuación representativa.|
|Entidad no responde o falta contrato||registra el estado técnico sin falso negativo.|
|Se editaron datos después de consultar||La respuesta anterior no habilita la aprobación de la nueva revisión.|
|RLS es una barrera de aislamiento propuesta, que|El mínimo de datos también se aplica a logs,||
|debe probarse con un rol de ejecución sin privilegios que la eludan y contexto limitado a la transacción. No se declara activa ni probada por dibujarla.|auditorías, exportaciones y conservación.||
|Un booleano o un hash por sí solos no garantizan|La idoneidad profesional se acredita por su fuente; no||
|cumplimiento de protección de datos. Se requieren|se deduce del rol o del cargo de administrador.||

coincide permanece desconocido; se 7

finalidad, legitimación aplicable, permisos, evidencia y medidas de seguridad.

|115 5|15 · CALIDAD Y MEDICIÓN|Calidad y medición del aporte al Caso 2 Herramientas o evidencia dentro del trabajo acordado e indicadores que deben medirse. Herramienta o evidencia · uso dentro del trabajo acordado|Trámites Migratorios · Especificación al Sprint 5|
|---|---|---|---|
||Java Implementación del servidor y conservación de la regresión ya existente, sin atribuir nuevas pruebas a sprints pasados.||Katalon Recorridos reproducibles: cartera, formulario, documentos, revisión y acceso denegado.|
||SQLMap Evaluación de inyección en un entorno de prueba autorizado; no contra entidades reales.||SonarQube Revisión estática y tratamiento de hallazgos según los criterios de aceptación del equipo.|
||SE CONSERVA||NO ES OBLIGATORIO|
|JUnit|JUnit ya forma parte de la base de pruebas Java y puede conservarse para regresión; no se agrega como sustituto de la fila acordada. Indicador · definición que debe medirse|ZAP|Playwright Lighthouse Vitest ZAP, Playwright, Lighthouse, Vitest y otros componentes del PDF anterior no se presentan como una nueva obligación ni como resultados realizados.|
||Tiempo de preparación Tiempo entre hitos internos de apertura y remisión; registrar pausas y método antes de comparar.||Subsanaciones Casos observados y número de observaciones por requisito, distinguiendo ambos conteos.|
||Reutilización Cargas evitadas mediante vínculos autorizados a evidencia vigente del mismo cliente. met.LineaBase mediciones. Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|se conserva como concepto de medición mencionado en la propuesta: periodo, muestra y método. No se atribuyen ahorros, porcentajes ni disminuciones del tiempo de resolución del SNM sin|Comprobaciones Resultados válidos, negativos, indisponibles y simulados, sin mezclarlos. 28|

|116 6|16 · BACKLOG Y CIERRE 175|HISTORIAS ATÓMICAS Recorrido para priorizar|Orden de recorrido para priorizar y condición de avance de cada paso. Título Descripción|Backlog y cierre del corte documental El anexo Product-Backlog-Abogados (Word) incluye 175 historias atómicas, un glosario y la correspondencia con las historias anteriores. Cada tarjeta tiene título, descripción, aceptación, prioridad, etapa y estado inicial Por validar. Las capturas orientan el formato de tarjetas; no aportan estimaciones individuales de esfuerzo. Aceptación Prioridad|Trámites Migratorios · Especificación al Sprint 5 Etapa Estado inicial: Por validar|
|---|---|---|---|---|---|
|1 2||permisos|RECORRIDO PARA PRIORIZAR Titular del cliente, responsable del caso y RECORRIDO PARA PRIORIZAR Borrador de una modalidad piloto y evidencia necesaria||CONDICIÓN DE AVANCE Un cliente existe antes de su primer caso y otro abogado no lo abre sin autorización. CONDICIÓN DE AVANCE Los campos cambian con la modalidad, el borrador persiste y el adjunto queda En revisión.|
|3||estados|RECORRIDO PARA PRIORIZAR Contrato mínimo TE/CSS/RP y manejo de||CONDICIÓN DE AVANCE La falta de acceso oficial se declara; una simulación no se confunde con respuesta real.|
|4||expediente|RECORRIDO PARA PRIORIZAR Revisor, poder y seguimiento del||CONDICIÓN DE AVANCE No hay autoaprobación y la actuación exige facultad vigente.|
|5||operación|RECORRIDO PARA PRIORIZAR Seguridad, pruebas, mediciones y||CONDICIÓN DE AVANCE Se exige evidencia reproducible antes de afirmar aptitud para datos reales.|
|Después||ampliaciones|RECORRIDO PARA PRIORIZAR Licencia, invitaciones, segundo factor y Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|El corte solicitado es una especificación coherente al Sprint 5. El backlog cubre el producto final para no perder la ruta, pero no implica desarrollar ahora las 175 historias ni completarlas en este incremento.|CONDICIÓN DE AVANCE Se planifica con la capacidad restante; no se promete para el Sprint 5. 29|

17 · TRAZABILIDAD Trámites Migratorios · Especificación al Sprint 5

### Trazabilidad de las correcciones principales

Figura de referencia, corrección aplicada en esta edición y regla o contrato relacionado.

|FIGURA DE REFERENCIA|CORRECCIÓN APLICADA EN ESTA EDICIÓN||REGLA O CONTRATO RELACIONADO|
|---|---|---|---|
|5.1 Contexto|Abogado principal, cliente sin cuenta, entidades y SNM externo||Alcance B2B y contratos de integración pendientes.|
|6.1 Casos de uso|Cartera y verificación explícitas; asistencia y revisión separadas||D01, D05 y permisos por relación.|
|Conceptual 11.1|Bufete, titular, responsable, representación y actuaciones||D01–D04; evitar tres fuentes de responsabilidad.|
|Físico 11.2 y 11.3|cliente_id, claves de bufete, versiones, evidencia e intentos||Transición preservando datos; no se afirma una V14 existente.|
|Clases UML 11.4|Clases organizativas y operaciones del personal del despacho||Sin funcionario SNM como revisor del portal.|
|Representación 11.5|Cliente separado de cuenta y titularidad||Poder con alcance y vigencia, distinto de la asignación.|
|DFD 9.0 11.6|Registro y decisión separados, con evidencia y auditoría||Preparación posible con poder pendiente.|
|11.7 Organización|Propagación del mismo modelo a todos los objetos||Pertenencia al bufete y actores de los cambios.|
|13.1 y nueva 13.2|Cartera desglosada y verificaciones prioritarias TE/CSS/RP||Consulta por abogado, estado y vencimiento.|

Las figuras de estados y arquitectura también se corrigen. Toda lámina nueva se identifica como objetivo del corte documental, evitando que convivan un sistema B2B propuesto y un modelo antiguo rotulado como terminado.

|118 8|18 · REFERENCIAS Y CONDICIONES||Referencias y condiciones por confirmar|Fuentes del alcance, normas de contexto y condiciones que afectan la siguiente implementación.||Trámites Migratorios · Especificación al Sprint 5|
|---|---|---|---|---|---|---|
||Fuentes del alcance 1 2 octubre de 2026; capturas de los sprints 3, 4 y 5; 4 6 2026); 8 2008 requiere su ficha y regulación específica vigente. Texto oficial publicado por el SNM.|PDF Plataforma-Tramites-Migratorios_AlcanceRedefinido de 40 páginas; informe de revisión de diagramas del 17 de documento del Sprint 0 (3 de septiembre de lectura estática de la copia local del repositorio. Decreto Ley No. 3 de 22 de febrero de La norma de creación se denomina Decreto Ley No. 3 de 22 de febrero de 2008. Se usa como contexto del Servicio Nacional de Migración; cada modalidad||3 5 7 por ANTAI|análisis externo aportado; indicaciones del equipo de desarrollo; README y hoja de ruta del Sprint 3; decisión de minimización del diseño, no una certificación de cumplimiento. y|Ley 81 de 26 de marzo de 2019 La Ley 81 de 26 de marzo de 2019 regula protección de datos personales. La respuesta booleana es una Legislación publicada explicación institucional.|
||Condiciones pendientes||||||
||CONDICIÓN PENDIENTE|ESTADO|||POR QUÉ AFECTA LA SIGUIENTE IMPLEMENTACIÓN||
||Validación académica del enfoque B2B|PENDIENTE|||Confirmar que el aporte medido en preparación y subsanaciones mantiene la respuesta al Caso 2.||
||Acceso autorizado de TE/CSS/RP Fichas de las modalidades y validación profesional|PENDIENTE PENDIENTE||acceso.|Definir servicio disponible, campos mínimos, finalidad, convertir todo campo en una consulta externa.|contrato y condiciones de uso. Hoy no se dispone de ese Precisar reglas, montos y vigencias sin inventar requisitos ni|
|equipo|Asignación de roles y capacidad del|PENDIENTE Plataforma de Trámites Migratorios · Especificación al Sprint 5 · 17 de octubre de 2026|||Planificar las historias posteriores y garantizar revisión independiente con personas habilitadas.|31|
