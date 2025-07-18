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
            try {
                System.out.print("Ingrese el nombre de la etapa: ");
                // Leer la entrada del usuario y convertirla a mayusculas para evitar problemas de mayusculas/minusculas
                String input = scanner.nextLine().trim().toUpperCase();
                // Verificar si la entrada esta vacia
                if (input.isEmpty()) {
                        System.out.println("La entrada no puede estar vacia. Intente nuevamente.");
                        continue;
                    }
                // Intentar convertir la entrada del usuario a un tipo de etapa
                selectedStage = StageType.valueOf(input);
            } catch (IllegalArgumentException e) {
                // Mensaje si la etapa ingresada no es valida
                System.out.println("Etapa invalida. Por favor, ingrese un nombre de etapa valido.");
            } catch (Exception e) {
                // Mensaje para cualquier otra excepcion inesperada
                System.out.println("Entrada invalida. Intente nuevamente.");
            }
        }
        // Retorna la etapa seleccionada
        return selectedStage;
    }
}