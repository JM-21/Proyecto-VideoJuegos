
package videojuegosle;

import java.util.Scanner;


public class Juego {
    private String titulo;
    private int horasEst;
    private boolean estado;
    private String genero;
    private String compañia;
    private Juego puntero;

    public Juego(String titulo, int horasEst, boolean estado, String genero, String compañia) {
        this.titulo = titulo;
        this.horasEst = horasEst;
        this.estado = estado;
        this.genero = genero;
        this.compañia = compañia;
        this.puntero = null;
    }

    public Juego() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEst() {
        return horasEst;
    }

    public void setHorasEst(int horasEst) {
        this.horasEst = horasEst;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    public Juego getPuntero() {
        return puntero;
    }

    public void setPuntero(Juego puntero) {
        this.puntero = puntero;
    }

    @Override
    public String toString() {
        String estadoString = estado ? "disponible" : "no disponible";
        return  "Titulo: " + titulo + "\n Horas estimadas: " + horasEst + "\n Estado: " + estadoString + "\n Genero: " + genero + "\n Company: " + compañia;
    }
    
    public Juego obtenerSiguiente(){
        return puntero;
    }
    
    public void enlazarSiguiente(Juego n){
        puntero = n;
    }
    
    
    
    public Juego obtenerJuego(){
        return this;
    }
    public Juego crearJuego(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese nombre del Juego: ");
        this.titulo = entrada.nextLine().toLowerCase();
        System.out.print("Ingrese horas estimadas de juego: ");
        this.horasEst = entrada.nextInt();
        entrada.nextLine();
        while (!String.valueOf(horasEst).matches("[0-9]+")) {
            System.out.print("Ingrese horas estimadas de juego validas: ");
            this.horasEst = entrada.nextInt();
            entrada.nextLine();
        }    
        this.estado = true;
        System.out.print("Ingrese genero del juego: ");
        this.genero = entrada.nextLine().toLowerCase();
        System.out.print("Ingrese compañia a la cual pertenece el juego: ");
        this.compañia = entrada.nextLine().toLowerCase();
        return this;
    
    }
    public void entregarJuego(Juego juego){
        Scanner entrada = new Scanner(System.in);
        System.out.println(" " );
        System.out.println("Se llevara el juego?");
        String confi = entrada.nextLine().toLowerCase();
        if(confi.equals("si")){
            juego.setEstado(false);
            System.out.println("Gracias por su compra");
           
        }else{
            System.out.println("Confirmacion equivocada, intente nuevamente");
        }
        
    }
    
    public void devolverJuego(Juego juego){
        Scanner entrada = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Devolver juego ?");
        String confi = entrada.nextLine().toLowerCase();
        if(confi.equals("si")){
            juego.setEstado(true);
            System.out.println("Juego devuelto");
        }else{
            System.out.println("Confirmacion equivocada, intente nuevamente");
        }             
    }
    
    public int compararJuegos (Juego juego){
       int dif = this.getHorasEst() - juego.getHorasEst(); 
        System.out.println("La diferencia entre los juegos es de: " + dif + " horas");
       return Math.abs(dif);
    }
}
