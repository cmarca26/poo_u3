package exceptions;

// Clase que representa una excepcion para nombres de equipos duplicados
public class DuplicateTeamException extends Exception {
    
    // Constructor que inicializa la excepcion con un mensaje
    public DuplicateTeamException(String message) {
        super(message);
    }
}
