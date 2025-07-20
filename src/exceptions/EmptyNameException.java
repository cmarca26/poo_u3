package exceptions;

// Clase que representa una excepcion para nombres de equipos vacios
public class EmptyNameException extends Exception {
    
    // Constructor que inicializa la excepcion con un mensaje
    public EmptyNameException(String message) {
        super(message);
    }
}
