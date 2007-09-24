/*
 * Tablero.java
 *
 * Created on 19 de septiembre de 2007, 13:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Tablero {
    
    protected Long id_tablero; //numero de tablero
    protected boolean turno;    //turno del jugador (BLANCAS=0, NEGRAS=1)
    protected Casilla tablero[][];
        
    /** Creates a new instance of Tablero */
    public Tablero() {        
    }
    
    /**Crea una tablero con los atributos especificados*/
    public Tablero(Long id, boolean tur, Casilla tablero[][]){
        this.id_tablero=id;
        this.turno=tur;
        this.tablero=tablero;
    }
    
    /**Cambia el turno de la partida.False(0)-> Turno de Blancas
     True(1)-> Turno de Negras*/
    public void setTurno(boolean turno){
        this.turno=turno;
    }
    
    /**Obtiene el turno de la partida, a quien le toca mover. False(0)-> Turno de Blancas
     True(1)-> Turno de Negras*/
    public boolean getTurno(){
        return(this.turno);
    }
    
    /**Coloca las fichas en su posicion inicial, al comienzo de la partida*/
    public Tablero colocar_fichas(Tablero tablero){
        //Colocar cada ficha en su sitio del tablero
        return tablero;
    }
   
    
    /**Busca la casilla solicitada en el tablero, si no la encuentra devuelve null*/
    public Casilla getCasilla(int fila, int columna){
   
        return(tablero[fila-1][columna-1]);
    }
    public void mover(Casilla origen, Casilla destino){
        destino.setFicha(origen.getFicha());
        origen.setFicha(null);
        origen.ocupada=false;
    }
    
    public void comprobar_movimiento(int filaorigen, int columnaorigen, int filadestino, int columnadestino){
        boolean origen_invalido=false; //La casilla origen no es del turno
        boolean destino_invalido=false; //La casilla destino no esta vacia o tiene una ficha del color
                                        //del turno.
        
        
        do{
            
        //comprobar_coordenadas(filaorigen,columnaorigen);
        //comprobar_coordenadas(filadestino,columnadestino);
        
        Casilla casillaorigen=getCasilla(filaorigen,columnaorigen);
        Casilla casilladestino=getCasilla(filadestino,columnadestino);
        
        Ficha fichaorigen=casillaorigen.getFicha();
        Ficha fichadestino=casilladestino.getFicha();
        
        //color=true=blancas
        //color=false=negras
        if(fichaorigen.getColor()!=turno) { origen_invalido=true;
        }
        else if(!casilladestino.getOcupada()) 
                            {/*AQUI MOVEMOS*/
                            mover(casillaorigen,casilladestino);
                            }
             else if(casilladestino.getFicha().getColor()!=turno) 
                            {/*AQUI MOVEMOS*/
                            mover(casillaorigen,casilladestino);
                            }
                else destino_invalido=true;
        }while(!origen_invalido||!destino_invalido);
        
        
        
    }
    
    
    
    
   
    
}
