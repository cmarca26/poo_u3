package model;

import java.io.Serializable;

// Clase que representa un equipo en el torneo
public class Team implements Serializable {
    
    // Atributo del equipo
    private String name;

    // Constructor que inicializa el equipo con un nombre
    public Team(String name) {
        this.name = name;
    }

    // Metodos para obtener y registrar el nombre del equipo
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}