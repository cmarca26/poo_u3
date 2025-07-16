package model;

// Clase que representa un partido en el torneo
public class Match {
    
    // Atributos del partido
    private Team home;
    private Team away;
    private int homeScore;
    private int awayScore;

    // Constructor que inicializa el partido con los equipos locales y visitantes
    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }

    // Metodos para obtener los equipos locales y visitantes
    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    // Metodos para obtener y registrar el resultado del partido del equipo local
    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    // Metodos para obtener y registrar el resultado del partido del equipo visitante
    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
}