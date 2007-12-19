/*
 * Main.java
 *
 * Created on 23 de septiembre de 2007, 19:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import model.facade.*;
import model.partida.Game;
import model.partida.Tablero;
import model.user.*;
import model.util.*;
import view.*;

/**
 *
 * @author Pablo
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ 
        boolean mate=false;
        int i=1, filaorigen=0, columnaorigen=0, filadestino=0, columnadestino=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("BIENVENIDO AL AJEDREZ");
        
        MostrarTablero mostrarTableroNegro = new MostrarTableroNegro();
        MostrarTablero mostrarTableroBlanco = new MostrarTableroBlanco();
        
        
        //CasosDeUsoEnNegro instancia= new CasosDeUsoEnNegro();
        //instancia.casosDeUso();
        
        /*Creamos una partida, y llamamos a OBTENER TABLERO, que nos devuelve un 
         tablero, el que asociamos a setTablero de la partida. */
        
        Game game = new Game();
        Tablero tablero = new Tablero();
        /* Le añado los dos observer en un principio es estatico tendremos que ver de que manera creamos los observers dinamicos*/
        // Por cada peticion de observar una partida hay q lanzar algo
        
             
        game.setTablero(tablero);  //Debemos asociar un tablero vacio antes
        game=game.obtener_tablero(game);
        game.addObserver(mostrarTableroNegro);         
        
       
       // mostrarTableroBlanco.update(partida);     
        game.comenzarPartida(game);
       
      
 }
}
