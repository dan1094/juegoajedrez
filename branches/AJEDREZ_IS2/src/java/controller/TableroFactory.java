/*
 * TableroFactory.java
 *
 * Created on 21 de noviembre de 2007, 13:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.partida.Alfil;
import model.partida.Caballo;
import model.partida.Casilla;
import model.partida.Dama;
import model.partida.Ficha;
import model.partida.Peon;
import model.partida.Rey;
import model.partida.Tablero;
import model.partida.Torre;
import view.MostrarTableroNegro;

/**
 *
 * @author Alvarete
 */
public class TableroFactory {
    
    /** Creates a new instance of TableroFactory */
    public TableroFactory() {
    }
    public Tablero situacionEnroque(){
        Tablero tablero = new Tablero(1);
        int i=0,j=0;
        
        //CREAMOS LAS FICHAS BLANCAS
        Ficha peon_b_1 = new Peon(false);
        Ficha tor_b_1 = new Torre(false);
        Ficha tor_b_2 = new Torre(false);
        Ficha alf_b_1 = new Alfil(false);
        Ficha reina_b = new Dama(false);
        Ficha rey_b = new Rey(false);

        //CREAMOS LAS FICHAS NEGRAS 
        Ficha cab_n_1 = new Caballo(true);
        Ficha reina_n = new Dama(true);
        Ficha rey_n = new Rey(true);
        
        int m, n;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
            }
       
        //Asociamos las fichas a sus posiciones en el tablero.
        tablero.tablero[2][0].setFicha(peon_b_1);
        tablero.tablero[7][0].setFicha(tor_b_1);
        tablero.tablero[7][7].setFicha(tor_b_2);
        tablero.tablero[5][0].setFicha(alf_b_1);
        tablero.tablero[6][5].setFicha(reina_b);
        tablero.tablero[7][4].setFicha(rey_b);
        
        tablero.tablero[0][1].setFicha(cab_n_1);
        tablero.tablero[0][3].setFicha(reina_n);
        tablero.tablero[0][4].setFicha(rey_n);
       

       
        return tablero;
    }
    
    public Tablero situacionComerDobleOpcion(){
        Tablero tablero = new Tablero(1);
        int i=0,j=0;
        
        //CREAMOS LAS FICHAS BLANCAS
        Ficha peon_b_1 = new Peon(false);
        Ficha peon_b_2 = new Peon(false);
        Ficha rey_b = new Rey(false);

        //CREAMOS LAS FICHAS NEGRAS 
        Ficha alf_n_1 = new Alfil(true);
        Ficha rey_n = new Rey(true);
        
        int m, n;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
            }
       
        //Asociamos las fichas a sus posiciones en el tablero.
        tablero.tablero[4][2].setFicha(peon_b_1);
        tablero.tablero[4][4].setFicha(peon_b_2);
        tablero.tablero[7][4].setFicha(rey_b);
        
        tablero.tablero[3][3].setFicha(alf_n_1);
        tablero.tablero[0][4].setFicha(rey_n);

       
        return tablero;
    }
    
    public Tablero situacionCoronar(){
        Tablero tablero = new Tablero(1);
        int i=0,j=0;
        
        //CREAMOS LAS FICHAS BLANCAS
        Ficha peon_b_1 = new Peon(false);
        Ficha peon_b_2 = new Peon(false);
        Ficha rey_b = new Rey(false);

        //CREAMOS LAS FICHAS NEGRAS 
        Ficha alf_n_1 = new Alfil(true);
        Ficha rey_n = new Rey(true);
        
        int m, n;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
            }
       
        //Asociamos las fichas a sus posiciones en el tablero.
        tablero.tablero[1][1].setFicha(peon_b_1);
        tablero.tablero[4][4].setFicha(peon_b_2);
        tablero.tablero[7][4].setFicha(rey_b);
        
        tablero.tablero[1][7].setFicha(alf_n_1);
        tablero.tablero[0][4].setFicha(rey_n);

       
        return tablero;
    }
    
    public Tablero situacionComerDobleCaballo(){
        Tablero tablero = new Tablero(1);
        int i=0,j=0;
        
        //CREAMOS LAS FICHAS BLANCAS
        Ficha caballo_b_1 = new Caballo(false);
        Ficha caballo_b_2 = new Caballo(false);
        Ficha rey_b = new Rey(false);

        //CREAMOS LAS FICHAS NEGRAS 
        Ficha alf_n_1 = new Alfil(true);
        Ficha rey_n = new Rey(true);
        
        int m, n;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(null,m,n,false,false);
            }
       
        //Asociamos las fichas a sus posiciones en el tablero.
        tablero.tablero[5][2].setFicha(caballo_b_1);
        tablero.tablero[5][4].setFicha(caballo_b_2);
        tablero.tablero[7][4].setFicha(rey_b);
        
        tablero.tablero[3][3].setFicha(alf_n_1);
        tablero.tablero[0][4].setFicha(rey_n);

       
        return tablero;
    }
    
    
}
