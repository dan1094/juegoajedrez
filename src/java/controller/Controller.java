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
    
      
     
     
     
     
     /*public static void main(String[] args){ 
       
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
        /**/
        
        
      
 }
             
     
