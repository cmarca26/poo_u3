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
│   │   └── TeamInputUtil.java
│   └── logic/
│       ├── TournamentDrawUtil.java
│       └── TournamentManager.java
```

## Clases y Relacion entre Clases
- **Main**: Clase principal que gestiona el flujo del torneo.
- **StageType**: Enum que define las etapas del torneo y la cantidad de equipos en cada una.
- **Team**: Representa un equipo participante.
- **Match**: Representa un partido entre dos equipos y sus resultados.
- **StageInputUtil**: Utilidad para leer la etapa seleccionada por el usuario.
- **TeamInputUtil**: Utilidad para leer los equipos ingresados por el usuario.
- **TournamentDrawUtil**: Realiza el sorteo y emparejamiento de partidos.
- **TournamentManager**: Asigna resultados, determina ganadores y muestra los partidos.

### Relacion entre Clases
- `Main` utiliza las utilidades de `utils` para leer datos y las clases de `logic` para gestionar el torneo.
- `TournamentDrawUtil` y `TournamentManager` trabajan con objetos `Team` y `Match`.
- `StageType` define la estructura del torneo y es usado para controlar el avance de etapas.

## Instrucciones para Clonar el repositorio

1. Abre una terminal o consola de comandos.
2. Ejecuta el siguiente comando:
```bash
   git clone https://github.com/cmarca26/poo_u3.git
```
3. Ingresa a la carpeta del proyecto:

```bash
   cd poo_u3
```

4. Abre el proyecto en tu IDE favorito y compílalo como un proyecto Java estándar.

---

## Notas Adicionales
- El proyecto es educativo y puede ser extendido para agregar mas funcionalidades.
- Los resultados de los partidos son generados aleatoriamente y siempre hay un ganador.
- El flujo del torneo avanza automaticamente por las etapas hasta determinar el campeon.

