package model;

// Clase que representa los tipos de etapas en un torneo
public enum StageType {

    // Etapas del torneo con el numero de equipos que participan en cada una
    OCTAVOS(16),
    CUARTOS(8),
    SEMIFINALES(4),
    FINAL(2);

    // Atributo que almacena el numero de equipos en la etapa
    private final int teamCount;

    // Constructor que inicializa el tipo de etapa con el numero de equipos
    StageType(int teamCount) {
        this.teamCount = teamCount;
    }

    // Metodo para obtener el numero de equipos que participan en la etapa
    public int getTeamCount() {
        return teamCount;
    }
}