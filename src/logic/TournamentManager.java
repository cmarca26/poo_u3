package logic;

import model.Match;
import model.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Clase que administra el torneo y los resultados
public class TournamentManager {

    // Constante para el minimo de goles
    private static final int MIN_GOALS = 0;
    // Constante para el maximo de goles
    private static final int MAX_GOALS = 5;
    // Objeto Random para generar resultados aleatorios
    private static final Random random = new Random();

    /**
     * Metodo que asigna resultados aleatorios asegurando que haya un ganador
     * @param matches Lista de partidos a los cuales se les asignaran resultados
     */
    public static void assignRandomResults(List<Match> matches) {
        for (Match match : matches) {
            int homeGoals, awayGoals;
            // Ciclo para evitar empate
            do {
                homeGoals = random.nextInt(MAX_GOALS + 1);
                awayGoals = random.nextInt(MAX_GOALS + 1);
            } while (homeGoals == awayGoals); // No se permite empate

            // Asignar los goles a cada equipo
            match.setHomeScore(homeGoals);
            match.setAwayScore(awayGoals);
        }
    }

    /**
     * Metodo que devuelve los ganadores de los partidos
     * @param matches Lista de partidos con sus resultados
     * @return Lista de equipos ganadores
     */
    public static List<Team> getWinners(List<Match> matches) {
        List<Team> winners = new ArrayList<>();
        for (Match match : matches) {
            // Si el equipo local tiene mas goles, es el ganador
            if (match.getHomeScore() > match.getAwayScore()) {
                winners.add(match.getHome());
            } else {
                // Si no, el ganador es el visitante
                winners.add(match.getAway());
            }
        }
        // Retorna la lista de ganadores
        return winners;
    }

    /**
     * Muestra los partidos y resultados de una etapa del torneo
     * @param matches Lista de partidos con sus resultados
     * @param stageName Nombre de la etapa del torneo
     */
    public static void printMatches(List<Match> matches, String stageName) {
        System.out.println("\nEncuentros de " + stageName + ":");
        int i = 1;
        for (Match match : matches) {
            // Imprimir el nombre de los equipos y el resultado
            System.out.println(i + ". " + match.getHome().getName() + " vs " + match.getAway().getName() +
                " | Resultado: " + match.getHomeScore() + " - " + match.getAwayScore());
            i++;
        }
    }
}