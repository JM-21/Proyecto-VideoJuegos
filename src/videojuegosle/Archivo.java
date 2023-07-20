
package videojuegosle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Archivo {


    public static void guardarJuegosRecientes(List<Juego> juegos, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i < juegos.size(); i++) {
                Juego juego = juegos.get(i);
                String juegoString = "Juego " + (i + 1) + "\n" + juego.toString() + "\n\n";
                writer.write(juegoString);
            }
            System.out.println("Los juegos recientes se han guardado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los juegos recientes en el archivo: " + nombreArchivo);
            e.printStackTrace();
        }
    }
    
     public static List<Juego> leerJuegosGuardados(String nombreArchivo) {
        List<Juego> juegos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("Juego")) {
                    Juego juego = parsearJuego(linea);
                    juegos.add(juego);
                }
            }

            System.out.println("Se han leído los juegos guardados del archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer los juegos guardados del archivo: " + nombreArchivo);
            e.printStackTrace();
        }

        return juegos;
    }

    private static Juego parsearJuego(String linea) {
        String texto = "disponible"; // Obtienes esta cadena del archivo de texto
        boolean valor = Boolean.valueOf(texto);

        String[] partes = linea.split("\n");
        if (partes.length >= 5) {
            String nombre = partes[1];
            int horasEst = Integer.parseInt(partes[2]);
            texto = partes[3];
            String genero = partes[4];
            String company = partes[5];
            return new Juego(nombre, horasEst,valor,genero,company);
        } else {
        // Si el formato de la línea no es válido, devuelve null o genera una excepción según tu preferencia
        return null;
        // ... Obtener los valores necesarios de 'partes' y crear un objeto Juego ...
      
        
        }
    }
    
    public Juego buscarArJuego(String nombre) {
        List<Juego> juegos = cargarJuegosDesdeArchivo("juegos.txt");

        for (Juego juego : juegos) {
            if (juego.getTitulo().equalsIgnoreCase(nombre)) {
                System.out.println("Juego encontrado:");
                System.out.println(juego.toString());
                return juego;
            }
        }

        System.out.println("No se encontró el juego o no existe");
        return null;
    }
     

    private List<Juego> cargarJuegosDesdeArchivo(String rutaArchivo) {
        List<Juego> juegos = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(rutaArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                Juego juego = parsearJuego(linea);
                if (juego != null) {
                juegos.add(juego);
                }
            }
        } catch (FileNotFoundException e) {
        System.out.println("Error al abrir el archivo: " + e.getMessage());
        }

        return juegos;
    }

}









    

