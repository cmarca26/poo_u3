package utils;

import model.StageType;
import model.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import exceptions.DuplicateTeamException;
import exceptions.EmptyNameException;
import utils.SerializationUtil;

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
            try {
                // Leer el nombre del equipo desde la entrada del usuario
                System.out.print("Equipo " + (i + 1) + ": ");
                name = scanner.nextLine().trim();
                // Validar que el nombre no este vacio
                if (name.isEmpty()) {
                    // Lanzar excepcion si el nombre esta vacio
                    throw new EmptyNameException("El nombre no puede estar vacio. Por favor, ingrese un nombre valido.");
                }
                // Recorrer la lista de equipos para verificar duplicados
                for (Team team : teams) {
                    // Verificar si el nombre ya fue ingresado
                    if (team.getName().equalsIgnoreCase(name)) {
                        // Lanzar excepcion si el nombre ya existe en la lista 
                        throw new DuplicateTeamException("El nombre ya fue ingresado. Por favor, ingrese un nombre unico.");
                    }
                }
                // Si el nombre es valido, crear un nuevo equipo y agregarlo a la lista
                teams.add(new Team(name));
                i++;
            } catch (EmptyNameException e) {
                // Mensaje de error si el nombre esta vacio
                System.out.println(e.getMessage());
            } catch (DuplicateTeamException e) {
                // Mensaje de error si el nombre ya fue ingresado
                System.out.println(e.getMessage());
            } catch (Exception e) {
                // Mensaje de error para cualquier otra excepcion inesperada
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }

        try {
            // Serializar la lista de equipos al finalizar
            SerializationUtil.saveObject(teams, "teams.dat");
        } catch (IOException e) {
            // Mensaje de error si no se pudo guardar la lista de equipos
            System.out.println("No se pudo guardar la lista de equipos serializada.");
        }

        // Retornar la lista de equipos ingresados
        return teams;
    }
}