package utils;

import model.StageType;
import model.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase que maneja la entrada de equipos para una etapa del torneo
public class TeamInputUtil {

    /**
     * Lee los equipos para una etapa del torneo desde la entrada del usuario.
     * @param stage El tipo de etapa para la cual se ingresaran los equipos.
     * @return Una lista de equipos ingresados por el usuario.
     */
    public static List<Team> readTeamsForStage(StageType stage) {

        // Crear un escaner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Crear una lista para almacenar los equipos
        List<Team> teams = new ArrayList<>();        
        // Asignar la cantidad de equipos que se deben ingresar segun la etapa
        int count = stage.getTeamCount();

        System.out.println("Ingrese " + count + " nombres de equipos para " + stage.name() + ":");

        // Asegurarse de que el usuario ingrese la cantidad correcta de equipos
        for (int i = 0; i < count; i++) {
            String name;

            // Ciclo hasta que se ingrese un nombre de equipo no vacio
            do {
                System.out.print("Equipo " + (i + 1) + ": ");
                name = scanner.nextLine().trim();
                // Verificar si el nombre esta vacio
                if (name.isEmpty()) {
                    System.out.println("El nombre no puede estar vacio. Por favor, ingrese un nombre de equipo valido.");
                }
            } while (name.isEmpty());

            // Crear un nuevo equipo y agregarlo a la lista
            teams.add(new Team(name));
        }
        // Retorna la lista de equipos ingresados
        return teams;
    }
}