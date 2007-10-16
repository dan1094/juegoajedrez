/*
 * Tablero.java
 *
 * Created on 19 de septiembre de 2007, 13:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

//import com.sun.xml.ws.security.opt.impl.crypto.SSBData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Pablo
 */
public class Tablero {
    
    protected int id_tablero; //numero de tablero
    protected Casilla tablero[][];
 
        
    /** Creates a new instance of Tablero */
    public Tablero() {        
    }
    
    /**Crea una tablero con los atributos especificados*/
    public Tablero(int id){
        this.id_tablero=id;
        tablero = new Casilla[8][8];
        }
    
    /**Coloca las fichas en sus posiciones iniciales*/
    public Tablero inicializar_tablero_estandar(Tablero tablero){
        
        int i=0,j=0;
        int id_ficha = 0;
        
        //CREAMOS LAS FICHAS BLANCAS. (sus ids iran del 0 al 15)
        Ficha peon_b_1 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_2 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_3 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_4 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_5 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_6 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_7 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_8 = new Peon(id_ficha,false);      id_ficha++;
        Ficha tor_b_1 = new Torre(id_ficha,false);      id_ficha++;
        Ficha tor_b_2 = new Torre(id_ficha,false);      id_ficha++;
        Ficha cab_b_1 = new Caballo(id_ficha,false);    id_ficha++;
        Ficha cab_b_2 = new Caballo(id_ficha,false);    id_ficha++;
        Ficha alf_b_1 = new Alfil(id_ficha,false);      id_ficha++;
        Ficha alf_b_2 = new Alfil(id_ficha,false);      id_ficha++;
        Ficha reina_b = new Reina(id_ficha,false);      id_ficha++;
        Ficha rey_b = new Rey(id_ficha,false);          id_ficha++;

        //CREAMOS LAS FICHAS NEGRAS (ids del 16 al 31) 
        Ficha peon_n_1 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_2 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_3 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_4 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_5 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_6 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_7 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_8 = new Peon(id_ficha,true);       id_ficha++;
        Ficha tor_n_1 = new Torre(id_ficha,true);       id_ficha++;
        Ficha tor_n_2 = new Torre(id_ficha,true);       id_ficha++;
        Ficha cab_n_1 = new Caballo(id_ficha,true);     id_ficha++;
        Ficha cab_n_2 = new Caballo(id_ficha,true);     id_ficha++;
        Ficha alf_n_1 = new Alfil(id_ficha,true);       id_ficha++;
        Ficha alf_n_2 = new Alfil(id_ficha,true);       id_ficha++;
        Ficha reina_n = new Reina(id_ficha,true);       id_ficha++;
        Ficha rey_n = new Rey(id_ficha,true);
          
        
        //CREA LAS INSTANCIAS CASILLAS DEL TABLERO
        Casilla cas;
        int m=0,n=0,id=0;
        int id_casilla= 0;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(id_casilla,null,m,n);
                id_casilla++;
            }
        
        
        //Asociamos las fichas a sus posiciones en el tablero.
        tablero.tablero[0][2].setFicha(alf_n_1);
        tablero.tablero[0][5].setFicha(alf_n_2);
        tablero.tablero[7][2].setFicha(alf_b_1);
        tablero.tablero[7][5].setFicha(alf_b_2);
        
        tablero.tablero[0][0].setFicha(tor_n_1);
        tablero.tablero[0][7].setFicha(tor_n_2);
        tablero.tablero[7][0].setFicha(tor_b_1);
        tablero.tablero[7][7].setFicha(tor_b_2);
        
        tablero.tablero[0][3].setFicha(reina_n);
        tablero.tablero[7][3].setFicha(reina_b);
        
        tablero.tablero[0][1].setFicha(cab_n_1);
        tablero.tablero[0][6].setFicha(cab_n_2);
        tablero.tablero[7][1].setFicha(cab_b_1);
        tablero.tablero[7][6].setFicha(cab_b_1);
        
        tablero.tablero[6][0].setFicha(peon_b_1);
        tablero.tablero[6][1].setFicha(peon_b_1);
        tablero.tablero[6][2].setFicha(peon_b_1);
        tablero.tablero[6][3].setFicha(peon_b_1);
        tablero.tablero[6][4].setFicha(peon_b_1);
        tablero.tablero[6][5].setFicha(peon_b_1);
        tablero.tablero[6][6].setFicha(peon_b_1);
        tablero.tablero[6][7].setFicha(peon_b_1);
        tablero.tablero[1][0].setFicha(peon_n_1);
        tablero.tablero[1][1].setFicha(peon_n_1);
        tablero.tablero[1][2].setFicha(peon_n_1);
        tablero.tablero[1][3].setFicha(peon_n_1);
        tablero.tablero[1][4].setFicha(peon_n_1);
        tablero.tablero[1][5].setFicha(peon_n_1);
        tablero.tablero[1][6].setFicha(peon_n_1);
        tablero.tablero[1][7].setFicha(peon_n_1);
        
        tablero.tablero[0][4].setFicha(rey_n);
        tablero.tablero[7][4].setFicha(rey_b);
       
        return(tablero);  
    }
    /**Crea un tablero como indique el usuario*/
    public Tablero inicializar_tablero_personalizado(Tablero tablero){
        
        int filaorigen=0, columnaorigen=0, filadestino=0, columnadestino=0;
        int opcion_ficha=0, fila=0, columna=0, id=0;
        boolean cumple_reglas=false, color=false;
               
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("PERSONALIZACION DEL TABLERO");
        do{
            opcion_ficha=this.ofrecer_ficha();
            color=this.pedir_color();
            fila=this.ofrecer_fila();
            columna=this.ofrecer_columna();
            Ficha ficha = crear_ficha(opcion_ficha,color,id);
            tablero.tablero[fila][columna].setFicha(ficha);
        }while((opcion_ficha!=0)&&(!cumple_reglas));
        
        return(tablero);
    }
    
    
    /**Busca la casilla solicitada en el tablero, si no la encuentra devuelve null*/
    public Casilla getCasilla(int fila, int columna){
        
        return(tablero[fila][columna]);
    }
    
    public void setCasilla(Casilla casilla, int fila, int columna){
        tablero[fila][columna]=casilla;
    }
    
    
    public boolean dentro_tablero(int fila, int columna){
        if((fila>=0)&&(fila<=7)&&(columna<=7)&&(columna>=0)) 
            return(true);
        else return(false);
    }
    
    //A PARTIR DE AQUI DEBERIA IR EN CONTROLLER, NO?
    
    
    public int ofrecer_ficha(){
        
        int opcion=0;
        System.out.println("¿Que ficha desea introducir? (0 para ninguna mas)");
        try {
        
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1.- REY");
            System.out.println("2.- REINA");
            System.out.println("3.- TORRE");
            System.out.println("4.- CABALLO");
            System.out.println("5.- ALFIL");
            System.out.println("6.- PEON");
            opcion = Integer.parseInt(in.readLine());
            
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
            System.out.println("FILA");
            fila = Integer.parseInt(in.readLine())-1;
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return(fila);
    }
    
    /**Funcion para pedir al usuario la fila de la ficha solicitada*/
    public int ofrecer_columna(){
        
        int columna=0;
        
        try {
        
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("COLUMNA");
            columna = Integer.parseInt(in.readLine())-1;
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return(columna);
    }
    
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
        }
        if(color==0) return(false);
        else return(true);
    }
    
    public Ficha crear_ficha(int opcion, boolean color, int id){
        Ficha ficha;
        switch(opcion){
            case 1:return(ficha = new Rey(id,color));
            case 2:return(ficha = new Reina(id,color));
            case 3:return(ficha = new Torre(id,color));
            case 4:return(ficha = new Caballo(id,color));
            case 5:return(ficha = new Alfil(id,color));
            case 6:return(ficha = new Peon(id,color));
            default: return(null);
        }
        
        
    }
  
}
