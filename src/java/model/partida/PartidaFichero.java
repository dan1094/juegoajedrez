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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *
 * @author Pablo
 */
public class PartidaFichero {
    
    /** Creates a new instance of PartidaFichero */
    public PartidaFichero(Game game) {
        
    }
    
    public String obtenerRuta() {
        
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

    public Game jugarPartidaFichero(Game game, String[] movimientos) throws IOException{
        
        Fide fide = new Fide();
        int[] coor = new int[4];
        boolean fin=false;
        
        for(int i=0;(i<100);i++){
            System.out.println(i+".-"+movimientos[i]);
            coor=fide.de_fide_a_modelo(game,movimientos[i]);
            //aqui habria que ir llamando a MOVER
                    
        }
        
        return game;
    }
    
    public void escrituraPartida(FileOutputStream fout, Game game){
        Ficha ficha;
        String fichaString;
        try{
		    //RECORRE EL TABLERO, COMPROBANDO SI LA ESTA OCUPADA
                    //Y SI ESTA OCUPADA, GUARDA LA FICHA, Y SINO, ESCRIBE "V".
                    for(int i=0;i<8;i++){
                        for(int j=0;j<8;j++){
                            if(game.tablero.tablero[i][j].getOcupada()){
                                ficha=game.tablero.tablero[i][j].getFicha();
                                fichaString=asociarFicha(ficha);
                                new PrintStream(fout).println(fichaString);
                            }else new PrintStream(fout).println ("V");
                        }
		    }
                    new PrintStream(fout).println(game.getTurno());
                    fout.close();
		
        }catch (IOException e){}
		
    }
    
    public Game aperturaPartida(String fichero){
        Game game = new Game();
        
        try {
            FileReader archivo = new FileReader(fichero);
            BufferedReader lector = new BufferedReader(archivo);
            game=this.obtenerPiezas(lector);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return(game);
    }
    
    public Game obtenerPiezas(BufferedReader lector){
        String linea="";
        Game game = new Game();
        Tablero tablero = new Tablero();
        tablero=tablero.vacio();
        game.setTablero(tablero);
        Ficha ficha;
               
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                try{
                    linea=lector.readLine();
                    ficha=asociarString(linea);
                    System.out.print("TABLERO["+i+"]["+i+"]=");
                    System.out.println(game.tablero.tablero[i][j].getOcupada());
                    game.tablero.tablero[i][j].setFicha(ficha);

                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        //Este trozo es para guardar el turno
        try {
            linea=lector.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if(linea.equals("false")) game.setTurno(false);
        else if(linea.equals("true")) game.setTurno(true);
    return(game);
    }
    
    
    public String asociarFicha(Ficha ficha){
        String fichaString;
        
       if(ficha.getTipo_ficha().equals("torre")){
            if(ficha.getColor()) fichaString="TN";
            else fichaString="TB";
       }else if(ficha.getTipo_ficha().equals("caballo")){
            if(ficha.getColor()) fichaString="CN";
            else fichaString="CB";
       }else if(ficha.getTipo_ficha().equals("alfil")){
            if(ficha.getColor()) fichaString="AN";
            else fichaString="AB";
       }else if(ficha.getTipo_ficha().equals("dama")){
            if(ficha.getColor()) fichaString="DN";
            else fichaString="DB";
       }else if(ficha.getTipo_ficha().equals("rey")){
           if(ficha.getColor()) fichaString="RN";
            else fichaString="RB";
       }else if(ficha.getTipo_ficha().equals("peon")){
           if(ficha.getColor()) fichaString="PN";
            else fichaString="PB";
       }else fichaString="";
        
    return(fichaString);
    }

    private Ficha asociarString(String linea) {
        Ficha ficha=null;
        System.out.println("LINEA LEIDA:"+linea);
        
        if(linea.equals("PB")){
            ficha=new Peon(false);
        }else if(linea.equals("PN")){
            ficha=new Peon(true);
        }else if(linea.equals("TB")){
            ficha=new Torre(false);
        }else if(linea.equals("TN")){
            ficha=new Torre(true);
        }else if(linea.equals("CB")){
            ficha=new Caballo(false);
        }else if(linea.equals("CN")){
            ficha=new Caballo(true);
        }else if(linea.equals("AB")){
            ficha=new Alfil(false);
        }else if(linea.equals("AN")){
            ficha=new Alfil(true);
        }else if(linea.equals("DB")){
            ficha=new Dama(false);
        }else if(linea.equals("DN")){
            ficha=new Dama(true);
        }else if(linea.equals("RB")){
            ficha=new Rey(false);
        }else if(linea.equals("RN")){
            ficha=new Rey(true);
        }else if(linea.equals("V")) ficha=null;
               
        return ficha;
    }
    

}