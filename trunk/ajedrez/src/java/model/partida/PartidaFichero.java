/*
 * PartidaFichero.java
 *
 * Created on 23 de noviembre de 2007, 17:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

import controller.Fide;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Pablo
 */
public class PartidaFichero {
    
    /** Creates a new instance of PartidaFichero */
    public PartidaFichero(Partida partida) {
    }
    
    public String obtenerRuta() {
        System.out.println("Introduzca la ruta del archivo a leer, seguido del nombre del archivo:");
        System.out.println("(Por ejemplo: [c:\\partida.txt]");
        String ruta=null;
         try {
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            ruta=in.readLine();
                        
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     
        
       return(ruta);
    }

    public String[] obtenerCoordenadasFichero(String ruta) throws IOException {
        String coorFicheroFide=null;
        BufferedReader lector=null;
        String[] lista = new String[100];
        try {
            FileReader archivo = new FileReader(ruta);
            lector = new BufferedReader(archivo);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        boolean finfichero=false;
        for(int i=0;i<100&&!finfichero;i++){
            lista[i]=lector.readLine();
            if(lista[i]==null) finfichero=true;
        }
            
        
         
                
        return(lista);
    }

    public Partida jugarPartidaFichero(Partida partida, String ruta) throws IOException{
        
        int linea=0;
        Fide fide = new Fide();
        String[] coorFide = this.obtenerCoordenadasFichero(ruta);
        int[] coorModelo = new int[4];
        int tamano=coorFide.length;
        boolean fin=false;
        for(int i=0;i<tamano-1;i++){
            coorFide=this.obtenerCoordenadasFichero(ruta);
            System.out.println(coorFide);
            coorModelo = fide.de_fide_a_modelo(partida ,coorFide[i]);
            System.out.println(coorModelo);
        //    partida.mover(coorModelo[0],coorModelo[1],coorModelo[2],coorModelo[3],partida.tablero);
        }
        
        return partida;
    }
    
}
