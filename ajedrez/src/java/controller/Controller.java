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
        
        
        System.out.println("COMIENZO DE LA PARTIDA");
        System.out.print("El turno es de las: ");
        if(partida.getTurno()) System.out.println("NEGRAS");
        else System.out.println("BLANCAS");
        do{
           
           //coordenadas = partida.getTablero().fide.de_fide_a_modelo(partida,this.pedir_coordenadas_movimiento()); //XQ tablero tiene un atributo FIDE???
           
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
       
     /**Ofrece la personalizacion del tablero de la partida*/
     public boolean tablero_personalizado(){
        int tipo_partida=0;
        do
        {
            System.out.println("Introduzca el tipo de partida que desea empezar");
            System.out.println("0 .- Partida Estandar");
            System.out.println("1 .- Partida Personalizada");
            
            try{
                tipo_partida = Integer.parseInt(in.readLine());
            }catch(NumberFormatException ex){
                
                System.out.println("Caracter invalido");
                
            }catch(IOException ex){
                
                System.out.println("Caracter invalido");
            }
            
        
        }while((tipo_partida!=0)&&(tipo_partida!=1));
        
        if(tipo_partida==0) return(false);
        else return(true);
    }
     
     /**Ofrece al usuario las fichas que quiere para crear el tablero*/
     public int ofrecer_ficha(){
        
        int opcion=0;
        System.out.println("¿Que ficha desea introducir? (0 para ninguna mas)");
        try {
        
          do{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("1.- REY");
                System.out.println("2.- REINA");
                System.out.println("3.- TORRE");
                System.out.println("4.- CABALLO");
                System.out.println("5.- ALFIL");
                System.out.println("6.- PEON");
                opcion = Integer.parseInt(in.readLine());
          }while((opcion<0)||(opcion>6));
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return(opcion);
    }
    
     
     /**Pide al usuario el color de la deseado de la ficha*/
     public boolean pedir_color(){
        int columna=0, color=0;
        System.out.println("¿Que color?");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("(0-Blanco, 1-Negro)");
            color = Integer.parseInt(in.readLine());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }if(color==0) return(false);
        else return(true);
    }
    
     /**Ofrece al usuario el cambio de ficha al coronar un peon*/
     public int ofrecer_cambio_ficha(){
         int eleccion;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
          try {
            System.out.println("Ha coronado un peon. ¿Que ficha desea obtener?");
            System.out.println("1.- Reina");
            System.out.println("2.- Torre");
            System.out.println("3.- Alfil");
            System.out.println("4.- Caballo");
            //Leemos el numero
            eleccion = Integer.parseInt(in.readLine());
            return(eleccion);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la ficha.");
        } finally {
            return(0);
        }
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
     
     public String pedir_coordenadas_ficha(){
         
        
        String coordenadas="";
        
        System.out.println("Introduzca las coordenadas (FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //llamamos a convertir_columna, que pasa de char a entero. Y lo metemos en un array de enteros.
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coordenadas=in.readLine();
            
                      
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     }
     
     public boolean obtener_turno_personalizado(Partida partida){
         boolean turno=false;
         int turn=2; //Igual a cero, para asegurarnos de que entra a leer.
         do{
             try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                turn=in.read();
            
                if(turn==0) turno=false;
                else turno=true;
                      
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         
         }while((turn<0)&&(turn>1));
         
         return(turno);
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