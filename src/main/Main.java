package main;

import model.StageType;
import model.Team;
import utils.StageInputUtil;
import utils.TeamInputUtil;
import logic.TournamentDrawUtil;
import logic.TournamentManager;
import java.util.List;
import java.util.Arrays;

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

        // Obtener todas las etapas del torneo
        StageType[] stages = StageType.values();
        // Encontrar el indice de la etapa seleccionada
        int currentStageIndex = Arrays.asList(stages).indexOf(stage);

        // Ciclo principal para avanzar por las etapas del torneo
        while (teams.size() > 1 && currentStageIndex < stages.length) {
            // Obtener la etapa actual
            StageType currentStage = stages[currentStageIndex];

            // Mostrar mensaje de la fase actual
            System.out.println("\n==============================");
            System.out.println("        " + currentStage.name());
            System.out.println("==============================\n");

            // Emparejar partidos para la etapa actual
            List<model.Match> matches = TournamentDrawUtil.drawMatches(teams);
            // Asignar resultados aleatorios a los partidos
            TournamentManager.assignRandomResults(matches);
            // Mostrar partidos y resultados
            TournamentManager.printMatches(matches, currentStage.name());
            // Obtener los equipos ganadores para la siguiente etapa
            teams = TournamentManager.getWinners(matches);
            // Avanzar al siguiente indice de etapa
            currentStageIndex++;
        }

        // Mostrar el campeon del torneo
        if (teams.size() == 1) {
            System.out.println("\nCAMPEON DEL TORNEO: " + teams.get(0).getName());
        }
    }
}