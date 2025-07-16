package main;

import model.StageType;
import model.Team;
import utils.StageInputUtil;
import utils.TeamInputUtil;
import java.util.List;

// Clase principal del programa
public class Main {

    public static void main(String[] args) {
        // Leer la etapa del torneo desde la entrada del usuario
        StageType stage = StageInputUtil.readStageType();
        // Leer la lista de equipos para la etapa seleccionada
        List<Team> teams = TeamInputUtil.readTeamsForStage(stage);

        // Mostrar los equipos ingresados para la etapa
        System.out.println("Equipos ingresados para " + stage.name() + ":");
        for (Team team : teams) {
            // Imprimir el nombre de cada equipo
            System.out.println("- " + team.getName());
        }
    }
}