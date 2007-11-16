/*
 * Controller.java
 *
 * Created on 10 de octubre de 2007, 21:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;


import java.io.*;
import java.util.ArrayList;
import model.facade.*;
import model.partida.*;
import model.user.*;
import model.util.*;




/**
 *
 * @author Pablo
 */
public class Controller {
    
    private ArrayList misObservers = new ArrayList();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     
    /** Creates a new instance of Controller */
    public Controller() {
    }
    public void comenzar(Partida partida)
    {
    
    
    
        //Declaro un array, donde meteremos las coordenadas, una vez pasadas de FIDE a enteros
        int coordenadas[] = new int[4];
        Fide fide= new Fide();
        
        System.out.println("COMIENZO DE LA PARTIDA");
        System.out.print("El turno es de las: ");
        if(partida.getTurno()) System.out.println("NEGRAS");
        else System.out.println("BLANCAS");
        do{
           do{
            coordenadas = fide.de_fide_a_modelo(partida,this.pedir_coordenadas_movimiento());
            }while(coordenadas==null);
           
            int filaorigen=coordenadas[1];
            int columnaorigen=coordenadas[0];
            int filadestino=coordenadas[3];
            int columnadestino=coordenadas[2];
            
            boolean movida=partida.mover(filaorigen,columnaorigen,filadestino,columnadestino,partida.getTablero());
            if(movida)
            { 
              //Para comprobar que ha movido, miramos lo que hay ahora en la casilla destino.
              Ficha ficha=partida.getTablero().getCasilla(filadestino,columnadestino).getFicha();
              System.out.print("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
              if(ficha.getColor()) System.out.println("negro.");
              else System.out.println("blanco.");
             /* if(partida.getTablero().tablero[filadestino][columnadestino].getFicha().getTipo_ficha().equalsIgnoreCase("rey"))
                 {
                 //Si lo movido es un rey, ya no puede enrocar.
                 //de que color es?
                 if(ficha.getColor()==false) 
                   partida.setBlanco_puede_enrocar(false);
                 else partida.setNegro_puede_enrocar(false);
                 }*/
             } 
        }while(!partida.fin_partida());
        
    }
       
     
     
    
     
    
    
     

     public String pedir_coordenadas_movimiento(){
        
        String coordenadas="";
        System.out.println("Introduzca las coordenadas del movimiento (formato FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //y llamamos a "de_fide_a_modelo", de la clase FIDE.
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coordenadas=in.readLine();
                      
                        
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     }
     
     
     
     public static void main(String[] args){ 
       
        boolean mate=false;
        int i=1, filaorigen=0, columnaorigen=0, filadestino=0, columnadestino=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Controller controller=null;
        
        System.out.println("BIENVENIDO AL AJEDREZ");
        
        System.out.println("Inicializando Partida....");
        Partida partida =  new Partida();
        System.out.println("Partida Inicializada");
        System.out.println("Creando un tablero vacio......");
        Tablero tablero = new Tablero(0);
        System.out.println("Tablero inicializado vacio");
        System.out.println("Asociando el tablero a la partida...");
        partida.setTablero(tablero);  //Debemos asociar un tablero vacio antes
        System.out.println("Tablero asociado...........");
        partida.obtener_tablero(); 
        System.out.println("Comienzo de la partida.......");
        controller.comenzar(partida);
        
        //CasosDeUsoEnNegro instancia= new CasosDeUsoEnNegro();
        //instancia.casosDeUso();
        
        /*Creamos una partida, y llamamos a OBTENER TABLERO, que nos devuelve un 
         tablero, el que asociamos a setTablero de la partida. */
        
       
        
        //
        
        
        
      
 }
             
     
}