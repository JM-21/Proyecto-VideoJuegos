
package videojuegosle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ListaJuegos {
    private Juego head;
    private int size;

    public ListaJuegos(Juego head, int size) {
        this.head = null;
        this.size = 0;
    }

    public ListaJuegos() {
    }

    public Juego getHead() {
        return head;
    }

    public void setHead(Juego head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ListaJuegos{" + "head=" + head + ", size=" + size + '}';
    }
    
    
    public void guardarJuegosRecientesEnArchivo(String nombreArchivo) {
        Archivo arc = new Archivo();
        List<Juego> juegosRecientes = obtenerJuegosRecientes();
        arc.guardarJuegosRecientes(juegosRecientes, nombreArchivo);
    }

    private List<Juego> obtenerJuegosRecientes() {
        List<Juego> juegosRecientes = new ArrayList<>();
        Juego jAct = head;
        int contador = 0;

        while (jAct != null && contador < 10) {
            juegosRecientes.add(jAct.obtenerJuego());
            jAct = jAct.obtenerSiguiente();
            contador++;
        }

        return juegosRecientes;
    }

    
    public Juego obtenerJuegoAnterior(Juego j){
        Juego jAct = head;
        Juego jAnt = null;
        
        while(jAct !=null && jAnt != j){
            jAnt = jAct;
            jAct = jAct.obtenerSiguiente();
        }
        return jAnt;
    }
    
    public boolean listaVacia(){
        if (head == null) {
            return true;
        }
        return false;
    }
    
    public void addJuego(Juego n){
        if (head == null) {
            head = n;
        }else{
            Juego temp = head;
            head = n;
            n.enlazarSiguiente(temp);
        }
        size++;
    }
    
   
    public void deleteJuego(Juego jEliminar){
        if(listaVacia()){
        }else{
            if (jEliminar == head) {
                head = jEliminar.obtenerSiguiente();
            }else{
                Juego temp = new Juego();
                Juego jAct = head;
                temp = obtenerJuegoAnterior(jEliminar);
                while(jAct != null && jAct !=jEliminar){
                    temp = jAct;
                    jAct = jAct.obtenerSiguiente();
                }
                temp.enlazarSiguiente(jEliminar.obtenerSiguiente()); 
            }
            
            System.out.println("Juego eliminado exitsamente");
            jEliminar = null;
            
        }
            
        size--;
    }
    
    public Juego obtenerJuego(int index){
        Juego temp = head;
        int contador = 0;
        while(contador < index){
            temp = temp.obtenerSiguiente();
            contador++;
        }
        return temp.obtenerJuego();
    }
    
    public Juego buscarJuego(String nombre){
        if (listaVacia()) {
            return null;
        }
        Juego nJuego = head;
        while(nJuego!= null){
            if (nJuego.getTitulo().equalsIgnoreCase(nombre)) {
                System.out.println("Juego encontrado");
                System.out.println(" ");
                System.out.println(nJuego.obtenerJuego().toString());
                System.out.println(" ");
                return nJuego;
                
            }
            nJuego = nJuego.obtenerSiguiente();
        }
        System.out.println("No se encontro juego o no exixte");
        return null;
    }
    
    public void top10Juegos(){
        if (listaVacia() || head.obtenerSiguiente() == null) {
            return;
        }
        Juego j = head;
        System.out.println("Top Juegos con mas horas: ");
        int i = 1;
        for(i=1;i<10 && j!= null; i++){
            Juego jMax = j;
            Juego jMin = j.obtenerSiguiente();
            while(jMin!=null){
                if (jMin.getHorasEst() > jMax.getHorasEst()) {
                    jMax = jMin ;
                }
                jMin = jMin.obtenerSiguiente();
            }
            if (j != jMax) {
                intercambioJuegos(j,jMax);
            }
            
            System.out.println(  i + "\n" + jMax.obtenerJuego().toString());
            System.out.println(" ");
            j = j.obtenerSiguiente();
        }
    }
    
    private void intercambioJuegos(Juego j1, Juego j2){
        int horasEst = j1.getHorasEst();
        j1.setHorasEst(j2.getHorasEst());
        j2.setHorasEst(horasEst);
    }
}
    
    
    
    

