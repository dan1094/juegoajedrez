/*
 * Tablero.java
 *
 * Created on 19 de septiembre de 2007, 13:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

//import com.sun.xml.ws.security.opt.impl.crypto.SSBData;

import controller.Fide;
import controller.TableroFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.util.LogManager;

/**
 *
 * @author Pablo
 */
public class Tablero {
    
    protected int id_tablero; //numero de tablero
    public Casilla tablero[][];
    protected Fide fide;
    
    /** Creates a new instance of Tablero */
    public Tablero() {
        tablero = new Casilla[8][8];
    }
    
    /**Crea una tablero con los atributos especificados*/
    public Tablero(int id){
        this.id_tablero=id;
        tablero = new Casilla[8][8];
        }
    
    public Casilla[][] getTablero(){
        return(this.tablero);
    }
    
    public void setTablero(Casilla[][] tablero){
        this.tablero=tablero;
    }
    
    /**Coloca las fichas en sus posiciones iniciales*/
    public Tablero inicializar_tablero_estandar(Game game){
        
        
        int i=0,j=0;
        System.out.println("Creando las fichas");
    //    LogManager.getLogManager().info("Creando las fichas");
        //CREAMOS LAS FICHAS BLANCAS. (sus ids iran del 0 al 15)

//        Ficha peon_b_1 = new Peon(false);
//        Ficha peon_b_2 = new Peon(false);
//        Ficha peon_b_3 = new Peon(false);
//        Ficha peon_b_4 = new Peon(false);
//        Ficha peon_b_5 = new Peon(false);
//        Ficha peon_b_6 = new Peon(false);
//        Ficha peon_b_7 = new Peon(false);
//        Ficha peon_b_8 = new Peon(false);
//        Ficha tor_b_1 = new Torre(false);
        Ficha tor_b_2 = new Torre(false);
//        Ficha cab_b_1 = new Caballo(false);
//        Ficha cab_b_2 = new Caballo(false);
        Ficha alf_b_1 = new Alfil(false);
//        Ficha alf_b_2 = new Alfil(false);
        Ficha reina_b = new Dama(false);
        Ficha rey_b = new Rey(false);
//
//        //CREAMOS LAS FICHAS NEGRAS 
//        Ficha peon_n_1 = new Peon(true);
//        Ficha peon_n_2 = new Peon(true);
//        Ficha peon_n_3 = new Peon(true);
//        Ficha peon_n_4 = new Peon(true);
//        Ficha peon_n_5 = new Peon(true);
//        Ficha peon_n_6 = new Peon(true);
//        Ficha peon_n_7 = new Peon(true);
//        Ficha peon_n_8 = new Peon(true);
        Ficha tor_n_1 = new Torre(true);
//        Ficha tor_n_2 = new Torre(true);
//        Ficha cab_n_1 = new Caballo(true);
//        Ficha cab_n_2 = new Caballo(true);
        Ficha alf_n_1 = new Alfil(true);
//        Ficha alf_n_2 = new Alfil(true);
        Ficha reina_n = new Dama(true);
        Ficha rey_n = new Rey(true);
          
        System.out.println("Creando las casillas del tablero");
     //   LogManager.info("Creando las casillas del tablero");
        //CREA LAS INSTANCIAS CASILLAS DEL TABLERO
       
        game.setTablero(this.vacio());
       
        System.out.println("Asociando las fichas a las casillas del tablero");
     //   LogManager.info("Asociando las fichas a las casillas del tablero");
        //Asociamos las fichas a sus posiciones en el tablero.
        game.tablero.tablero[0][2].setFicha(alf_n_1);
        //game.tablero.tablero[0][5].setFicha(alf_n_2);
        game.tablero.tablero[7][2].setFicha(alf_b_1);
        //game.tablero.tablero[7][5].setFicha(alf_b_2);
      
        game.tablero.tablero[0][0].setFicha(tor_n_1);
        //game.tablero.tablero[0][7].setFicha(tor_n_2);
        //game.tablero.tablero[7][0].setFicha(tor_b_1);
        game.tablero.tablero[7][7].setFicha(tor_b_2);
        
        game.tablero.tablero[0][3].setFicha(reina_n);
        game.tablero.tablero[7][3].setFicha(reina_b);
        
        //game.tablero.tablero[0][1].setFicha(cab_n_1);
        //game.tablero.tablero[0][6].setFicha(cab_n_2);
        //game.tablero.tablero[7][1].setFicha(cab_b_1);
        //game.tablero.tablero[7][6].setFicha(cab_b_1);
        
        //game.tablero.tablero[6][0].setFicha(peon_b_1);
        //game.tablero.tablero[6][1].setFicha(peon_b_1);
        //game.tablero.tablero[6][2].setFicha(peon_b_1);
        //game.tablero.tablero[6][3].setFicha(peon_b_1);
        //game.tablero.tablero[6][4].setFicha(peon_b_1);
        //game.tablero.tablero[6][5].setFicha(peon_b_1);
        //game.tablero.tablero[6][6].setFicha(peon_b_1);
        //game.tablero.tablero[6][7].setFicha(peon_b_1);
        //game.tablero.tablero[1][0].setFicha(peon_n_1);
        //game.tablero.tablero[1][1].setFicha(peon_n_1);
        //game.tablero.tablero[1][2].setFicha(peon_n_1);
        //game.tablero.tablero[1][3].setFicha(peon_n_1);
        //game.tablero.tablero[1][4].setFicha(peon_n_1);
        //game.tablero.tablero[1][5].setFicha(peon_n_1);
        //game.tablero.tablero[1][6].setFicha(peon_n_1);
        //game.tablero.tablero[1][7].setFicha(peon_n_1);
        
        game.tablero.tablero[0][4].setFicha(rey_n);
        game.tablero.tablero[7][4].setFicha(rey_b);
        game.setTurno(false);
       
        return(game.tablero);  
    }
    
    
    /**Crea un tablero como indique el usuario*/
    public Tablero inicializar_tablero_personalizado(Game game){
        int coordenadas[] = new int[2];
        String coor_fide;
                
        int filaorigen=0, columnaorigen=0, filadestino=0, columnadestino=0;
        int opcion_ficha=0, fila=0, columna=0, m=0, n=0;
        boolean cumple_reglas=false, color=false;
               
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                game.tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
            }
        boolean rb=false,rn=false,ot=false,dosreyes=false;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("PERSONALIZACION DEL TABLERO");
      //  LogManager.info("PERSONALIZACION DEL TABLERO");
        do{
           
            opcion_ficha=game.ofrecer_ficha();
            if(opcion_ficha!=0){
                color=game.pedir_color();
                coor_fide=game.pedir_coordenadas_ficha();
                coordenadas=game.tablero.fide.de_fide_a_modelo(game,coor_fide);
                fila=coordenadas[1];
                columna=coordenadas[0];
                Ficha ficha = game.tablero.crear_ficha(opcion_ficha,color);
                game.tablero.tablero[fila][columna].setFicha(ficha);
                if(ficha.tipo_ficha.equals("rey")&&(ficha.getColor()==false)){
                    //rey blanco
                    if(rb==true){
                        dosreyes=true;
                    }else rb=true;
                }else if(ficha.tipo_ficha.equals("rey")&&(ficha.getColor()==true)){
                        if(rn==true){
                            dosreyes=true;
                        }else rn=true;
                       }else ot=true;
                
            }
        }while((opcion_ficha!=0)||(!game.tablero.cumple_reglas(rn,rb,ot,dosreyes)));
        
        return(game.tablero);
    }
    
      
    public Tablero vacio()
    {
        Tablero tablero = new Tablero();
        
        int m, n;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
            }
        return (tablero);
    }
    /**Busca la casilla solicitada en el tablero, si no la encuentra devuelve null*/
    public Casilla getCasilla(int fila, int columna){
        
        return(tablero[fila][columna]);
    }
    
    public void setCasilla(Casilla casilla, int fila, int columna){
        tablero[fila][columna]=casilla;
    }
    
    /**Comprueba que las coordenadas estan dentro del tablero*/
    public boolean dentro_tablero(int fila, int columna){
        if((fila>=0)&&(fila<=7)&&(columna<=7)&&(columna>=0)) 
            return(true);
        else return(false);
    }
    
    /**Comprueba que los dos reyes y, al menos, otra ficha mas,han sido incluidas*/
    public boolean cumple_reglas(boolean rn, boolean rb, boolean ot, boolean dosreyes){
        if(rb&&rn&&ot&&!dosreyes) return(true);
        else {
            System.out.println("Debe introducir mas fichas.");
            return(false);
        }   
    }
  
    /**Crea fichas a partir de la opcion introducida anteriormente*/
    public Ficha crear_ficha(int opcion, boolean color){
        Ficha ficha;
        
        switch(opcion){
            case 1:return(ficha = new Rey(color));
            case 2:return(ficha = new Dama(color));
            case 3:return(ficha = new Torre(color));
            case 4:return(ficha = new Caballo(color));
            case 5:return(ficha = new Alfil(color));
            case 6:return(ficha = new Peon(color));
            default: return(null);
        }
    }
    
    /**Esta funcion recorre el tablero, marcando las casillas amenazadas*/
    public Tablero amenazas(Tablero tablero){
                
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                //Si no esta vacia, se coge la ficha y se llama a amenazar_casillas
                if(tablero.tablero[i][j].getOcupada()){
                Ficha ficha =tablero.tablero[i][j].getFicha();
                tablero=ficha.amenazar_casillas(this,i,j);
                }
                
            }
        return(tablero);
    }
  
}

    