package utils;

import model.StageType;
import java.util.Scanner;

// Clase que maneja la entrada de etapas del torneo
public class StageInputUtil {

    /**
     * Lee el tipo de etapa del torneo desde la entrada del usuario.
     * @return El tipo de etapa seleccionado por el usuario.
     */
    public static StageType readStageType() {
        // Crear un escaner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la etapa del torneo:");

        // Mostrar las etapas disponibles
        for (StageType stage : StageType.values()) {
            System.out.println("- " + stage.name());
        }
        
        StageType selectedStage = null;
        
        // Ciclo para asegurar que el usuario ingrese una etapa valida
        while (selectedStage == null) {
            System.out.print("Ingrese el nombre de la etapa: ");
            String input = scanner.nextLine().trim().toUpperCase();
            // Intentar convertir la entrada del usuario a un tipo de etapa
            try {
                selectedStage = StageType.valueOf(input);
            } catch (IllegalArgumentException e) {
                // Mensaje si la etapa ingresada no es valida
                System.out.println("Etapa invalida. Por favor, ingrese un nombre de etapa valido.");
            }
        }
        // Retorna la etapa seleccionada
        return selectedStage;
    }
}