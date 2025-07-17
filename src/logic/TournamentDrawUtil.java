package logic;

import model.Team;
import model.Match;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Clase que realiza el sorteo de partidos en el torneo
public class TournamentDrawUtil {

    /**
     * Metodo que realiza el sorteo de partidos entre los equipos
     * @param teams Lista de equipos que participaran en la etapa del torneo
     * @return Lista de partidos sorteados
     */
    public static List<Match> drawMatches(List<Team> teams) {
        // Crear una copia de la lista y mezclar los equipos de forma aleatoria
        List<Team> shuffledTeams = new ArrayList<>(teams);
        Collections.shuffle(shuffledTeams, new Random());
        
        // Lista para almacenar los partidos generados
        List<Match> matches = new ArrayList<>();

        // Llamar al metodo recursivo para emparejar los equipos
        drawRecursive(shuffledTeams, matches);

        // Retornar la lista de partidos
        return matches;
    }

    /**
     * Metodo recursivo que empareja los equipos para crear partidos
     * @param teams Lista de equipos restantes a emparejar
     * @param matches Lista de partidos generados hasta el momento
     */
    private static void drawRecursive(List<Team> teams, List<Match> matches) {
        // Si hay menos de dos equipos, no se puede crear un partido
        if (teams.size() < 2) return;

        // Seleccionar el primer equipo como local
        Team home = teams.remove(0);
        Team away = null;

        // Buscar un equipo diferente para evitar que juegue contra si mismo
        for (int i = 0; i < teams.size(); i++) {
            if (!teams.get(i).equals(home)) {
                away = teams.remove(i);
                break;
            }
        }

        // Si se encontro un equipo visitante, crear el partido
        if (away != null) {
            matches.add(new Match(home, away));
        }

        // Llamar recursivamente para emparejar los equipos restantes
        drawRecursive(teams, matches);
    }
}