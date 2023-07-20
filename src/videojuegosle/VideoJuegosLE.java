
package videojuegosle;

import java.util.List;
import java.util.Scanner;




public class VideoJuegosLE {

    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ListaJuegos lista = new ListaJuegos();
        Archivo arc = new Archivo();
        
        
       System.out.println(" ");
        System.out.println("   -----  Menu -----  ");
        System.out.println("   1. Crear juego  ");
        System.out.println("   2. Consultar juego       ");
        System.out.println("   3. Llevar juego         ");
        System.out.println("   4. Devolver juego       ");
        System.out.println("   5. comparar horas estimadas de los juegos        ");
        System.out.println("   6. Eliminar juego  ");
        System.out.println("   7. Top 10 de juegos con mas horas ");
        System.out.println("   8. Cargar juegos del txt ");
        System.out.println("   0. Salir del menu         ");
        System.out.print("     Seleccione opcion: ");
        int op = entrada.nextInt();
        entrada.nextLine();
        System.out.println(" ");

        do {
            switch (op) {
                case 1:
                    Juego nuevoJuego = new Juego();
                    nuevoJuego.crearJuego();
                    lista.addJuego(nuevoJuego);
                    System.out.println("Juego guardado");
                    lista.guardarJuegosRecientesEnArchivo("juegos.txt");
                    break;
                case 2:
                    System.out.print("Ingrese titulo a buscar: ");
                    String titulo = entrada.nextLine().toLowerCase();
                    lista.buscarJuego(titulo);
                    
                    
                    
                    break;
                case 3:
                    System.out.print("Ingrese titulo: ");
                    String titulo2 = entrada.nextLine().toLowerCase();
                    Juego j = new Juego();
                    j = lista.buscarJuego(titulo2);
                    if (j.isEstado()!=true) {
                        System.out.println("El juego actualmente, no se encuentra disponible");
                        break;
                    }else{
                        j.entregarJuego(j);
                    }
                    break;  
                case 4:
                    System.out.print("Ingrese titulo: ");
                    String titulo3 = entrada.nextLine().toLowerCase();
                    Juego j1 = new Juego();
                    j1 = lista.buscarJuego(titulo3);
                    if (j1!=null) {
                        j1.devolverJuego(j1);
                    }else{
                        System.out.println("No se encontro el juego");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese titulo: ");
                    String titulo4 = entrada.nextLine().toLowerCase();
                    Juego j2 = new Juego();
                    j2=lista.buscarJuego(titulo4);
                    if (j2!=null) {
                        Juego j3 = new Juego();
                        System.out.print("Ingrese titulo a comparar: ");
                        String titulo5 = entrada.nextLine().toLowerCase();
                        j3 = lista.buscarJuego(titulo5);
                        if (j3!=null) {
                            j2.compararJuegos(j3);
                        }else{
                            System.out.println("No se encontro juego, verifique e intente nuevamente");
                            break;
                        }
                    }else{
                        System.out.println("No se encontro el juego, verique e intene nuevamente");
                        break;
                    } 
                    break;
                case 6:
                    System.out.print("Ingrese titulo a eliminar: ");
                    String titulo5 = entrada.nextLine().toLowerCase();
                    Juego j4 = new Juego();
                    j4 = lista.buscarJuego(titulo5);
                    if (j4!=null) {
                        lista.deleteJuego(j4);
                    }else{
                        System.out.println("No se encontro el juego, verique e intene nuevamente");
                        break;
                    }
                    break;

                case 7:
                    lista.top10Juegos();
                    break;
                case 8:
                   
                    
            }
            System.out.println(" ");
            System.out.println("   -----  Menu -----  ");
            System.out.println("   1. Crear juego  ");
            System.out.println("   2. Consultar juego       ");
            System.out.println("   3. Llevar juego         ");
            System.out.println("   4. Devolver juego       ");
            System.out.println("   5. comparar horas estimadas de los juegos        ");
            System.out.println("   6. Eliminar juego  ");
            System.out.println("   7. Top 10 de juegos con mas horas ");
            System.out.println("   0. Salir del menu         ");
            System.out.print("     Seleccione opcion: ");
            op = entrada.nextInt();
            entrada.nextLine();
            System.out.println(" ");
        }while (op != 0);
    }
}
    

