/*
 * Controller.java
 *
 * Created on 10 de octubre de 2007, 21:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

import java.io.*;


/**
 *
 * @author Pablo
 */
public class Controller {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    /** Creates a new instance of Controller */
    public Controller() {
    }
    
     /**Ofrece la personalizacion del tablero de la partida*/
     public boolean tablero_personalizado(){
        
        System.out.println("¿Desea jugar una partida estandar o desea personalizar el tablero?");
        System.out.println("(0=Estandar, 1=Personalizada)");
        int tipo_partida=0;
        
        try {
            tipo_partida = Integer.parseInt(in.readLine());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
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
    
     /**Funcion para pedir al usuario la fila de la ficha solicitada*/
     public int ofrecer_fila(){
        int fila=0;
        try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("FILA: ");
            fila = Integer.parseInt(in.readLine())-1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(fila);
    }
    
     /**Funcion para pedir al usuario la fila de la ficha solicitada*/
     public int ofrecer_columna(){
        int columna=0;
        char columna_letra;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("COLUMNA: ");
           // this.convertir();
           // columna_letra = (char) System.in.read();
            columna = Integer.parseInt(in.readLine())-1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(columna);
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

    /**Esta funcion convierte la columna, introducida en letras por el usuario,
     *a numeros, para la aplicacion*/
     public int convertir(char letra){
         switch(letra){
             case 'A':
             case 'a':  return(0);
             case 'B':
             case 'b':  return(1);
             case 'C':
             case 'c':  return(2);
             case 'D':
             case 'd':  return(3);
             case 'E':
             case 'e':  return(4);
             case 'F':
             case 'f':  return(5);
             case 'G':
             case 'g':  return(6);
             case 'H':
             case 'h':  return(7);
             default: return(8);
         }
                 
     }
     
     public int convertir_int(char letra){
         switch(letra){
             
             case '1':  return(7);             
             case '2':  return(6);
             case '3':  return(5);
             case '4':  return(4);
             case '5':  return(3);
             case '6':  return(2);
             case '7':  return(1);
             case '8':  return(0);
             default: return(8);
         }
                 
     }
     
     
     public int[] pedir_coordenadas_movimiento(){
        
        char coor_cadena[];
        coor_cadena = new char[5];
        int coordenadas[];
        coordenadas = new int[4];
        
        System.out.println("Introduzca las coordenadas del movimiento (formato FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //llamamos a convertir, que pasa de char a entero. Y lo metemos en un array de enteros.
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coor_cadena=in.readLine().toCharArray();
            coordenadas[0]=this.convertir(coor_cadena[0]);
            coordenadas[1]=this.convertir_int(coor_cadena[1]);
            coordenadas[2]=this.convertir(coor_cadena[2]);
            coordenadas[3]=this.convertir_int(coor_cadena[3]);
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     }
     
     public int[] pedir_coordenadas_ficha(){
         
         char coor_cadena[];
         coor_cadena = new char[2];
         int coordenadas[];
         coordenadas = new int[2];
        System.out.println("Introduzca las coordenadas para la ficha (FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //llamamos a convertir, que pasa de char a entero. Y lo metemos en un array de enteros.
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coor_cadena=in.readLine().toCharArray();
            coordenadas[0]=this.convertir(coor_cadena[0]);
            coordenadas[1]=this.convertir_int(coor_cadena[1]);
                      
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     }
     
     public boolean obtener_turno_personalizado(Partida partida){
         boolean turno=false;
         try {
                        
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int turn=in.read();
            
            if(turn==0) turno=false;
            else turno=true;
                      
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         return(turno);
     }
             
             
}