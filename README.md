# Proyecto: Simulador de Torneo de Futbol

## Autor
- Nombre: Carlos Marca
- Estudiante de segundo ciclo de la carrera de Ingeniería de Software
- **Universidad Politécnica Salesiana**

## Descripcion
Este proyecto es una aplicacion en Java que simula un torneo de futbol por etapas (octavos, cuartos, semifinales y final). Permite al usuario ingresar los equipos participantes, realiza el sorteo de partidos, asigna resultados aleatorios y muestra el avance de los equipos hasta determinar el campeon.

## Estructura del Proyecto
```
poo_u3/
├── src/
│   ├── main/
│   │   └── Main.java
│   ├── model/
│   │   ├── Match.java
│   │   ├── StageType.java
│   │   └── Team.java
│   ├── utils/
│   │   ├── StageInputUtil.java
│   │   ├── TeamInputUtil.java
│   │   ├── SerializationUtil.java
│   |___exceptions/
│   │   ├── DuplicateTeamException.java
│   │   └── EmptyNameException.java
│   └── logic/
│       ├── TournamentDrawUtil.java
│       └── TournamentManager.java
```

## Clases y Relacion entre Clases
- **Main**: Clase principal que gestiona el flujo del torneo y el registro del proceso.
- **StageType**: Enum que define las etapas del torneo y la cantidad de equipos en cada una.
- **Team**: Representa un equipo participante (serializable).
- **Match**: Representa un partido entre dos equipos y sus resultados (serializable).
- **StageInputUtil**: Utilidad para leer la etapa seleccionada por el usuario.
- **TeamInputUtil**: Utilidad para leer los equipos ingresados por el usuario, valida duplicados y nombres vacios, y serializa la lista de equipos.
- **SerializationUtil**: Utilidad para guardar y leer objetos serializados (como la lista de equipos).
- **DuplicateTeamException** y **EmptyNameException**: Excepciones personalizadas para validar la entrada de equipos.
- **TournamentDrawUtil**: Realiza el sorteo y emparejamiento de partidos.
- **TournamentManager**: Asigna resultados, determina ganadores y muestra los partidos.


### Relacion entre Clases
- `Main` utiliza las utilidades de `utils` para leer datos, serializar equipos, manejar excepciones y registrar el proceso, y las clases de `logic` para gestionar el torneo.
- `TournamentDrawUtil` y `TournamentManager` trabajan con objetos `Team` y `Match`.
- `StageType` define la estructura del torneo y es usado para controlar el avance de etapas.

## Instrucciones para Clonar y Ejecutar el Proyecto

1. Abre una terminal o consola de comandos.
2. Ejecuta el siguiente comando:
   ```bash
   git clone https://github.com/cmarca26/poo_u3.git
   cd poo_u3
   ```
3. Abre el proyecto en tu IDE favorito y compílalo como un proyecto Java estándar.
4. Ejecuta la clase principal `Main` para iniciar el simulador.

## Caracteristicas Avanzadas
- El proceso de entrada y resultados se registra y puede ser serializado para su posterior recuperacion.
- Se valida que los nombres de equipos no esten vacios ni duplicados usando excepciones personalizadas.
- La lista de equipos se guarda automaticamente en el archivo `teams.dat` usando serializacion.

---

## Notas Adicionales
- El proyecto es educativo y puede ser extendido para agregar mas funcionalidades.
- Los resultados de los partidos son generados aleatoriamente y siempre hay un ganador.
- El flujo del torneo avanza automaticamente por las etapas hasta determinar el campeon.

