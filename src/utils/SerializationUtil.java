package utils;

import java.io.*;

// Clase utilitaria para serializar y deserializar objetos
public class SerializationUtil {
    // Metodo para guardar un objeto en un archivo
    public static void saveObject(Object obj, String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(obj);
        }
    }

    // Metodo para leer un objeto desde un archivo
    public static Object loadObject(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return ois.readObject();
        }
    }
}
