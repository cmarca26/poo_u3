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

        int i = 0;
        // Ciclo para ingresar los equipos hasta que se alcance la cantidad requerida
        while (i < count) {
            String name;
            boolean isDuplicate;
            try {
                System.out.print("Equipo " + (i + 1) + ": ");
                // Leer el nombre del equipo desde la entrada del usuario
                name = scanner.nextLine().trim();
                isDuplicate = false;
                // Verificar si el nombre esta vacio o si ya fue ingresado
                if (name.isEmpty()) {
                    System.out.println("El nombre no puede estar vacio. Por favor, ingrese un nombre valido.");
                    continue;
                }
                // Verificar si el nombre ya fue ingresado
                for (Team team : teams) {
                    // Comparar el nombre del equipo ingresado con los nombres ya existentes
                    if (team.getName().equalsIgnoreCase(name)) {
                        System.out.println("El nombre ya fue ingresado. Por favor, ingrese un nombre unico.");
                        isDuplicate = true;
                        break;
                    }
                }
                // Si el nombre es un duplicado, continuar al siguiente ciclo
                if (isDuplicate) {
                    continue;
                }
                // Crear un nuevo equipo con el nombre ingresado y agregarlo a la lista
                teams.add(new Team(name));
                i++;
            } catch (Exception e) {
                // Mensaje para cualquier excepcion inesperada
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }

        // Verificar si la cantidad de equipos ingresados coincide con la cantidad esperada
        if (teams.size() != count) {
            System.out.println("La cantidad de equipos ingresados no coincide con la etapa. Se esperaban " + count + ".");
        }

        // Retorna la lista de equipos ingresados
        return teams;
    }
}