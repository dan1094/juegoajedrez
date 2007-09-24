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
    public void mover(int filaorigen, int columnaorigen, int filadestino, int columnadestino){
        
        boolean mov_per=comprobar_movimiento(filaorigen,columnaorigen,filadestino,columnadestino);
        if(mov_per){
                Casilla origen=getCasilla(filaorigen,columnaorigen);
                Casilla destino=getCasilla(filadestino,columnadestino);
                destino.setFicha(origen.getFicha());
                origen.setFicha(null);
                origen.ocupada=false;
        }
    }
    
    public boolean dentro_tablero(int fila, int columna){
        if(fila>=1&&fila<=8&&columna<=8&&columna>=1) return(true);
        else return(false);
    }
    
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, int filadestino, int columnadestino){
        
        boolean origen_valido=true;
        boolean destino_valido=true;
        
        origen_valido=dentro_tablero(filaorigen,columnaorigen); //esta dentro
        destino_valido=dentro_tablero(filadestino,columnadestino); //esta dentro
        while(origen_valido&&destino_valido)
        {
            Casilla casillaorigen=getCasilla(filaorigen,columnaorigen);
            Casilla casilladestino=getCasilla(filadestino,columnadestino);
        
            Ficha fichaorigen=casillaorigen.getFicha();
            Ficha fichadestino=casilladestino.getFicha();
        
        //color=true=blancas
        //color=false=negras
        if(fichaorigen.getColor()!=turno) 
        { 
                //Origen de distinto color que el turno
                return(false);
        }
        else if(!casilladestino.getOcupada()) 
                            {
                            //origen del mismo color que el turno y casilla destino vacia
                            return(true);
                            }
             else if(casilladestino.getFicha().getColor()!=turno) 
                            {
                            //origen=turno, y destino del color diferente. Se puede comer la
                            //ficha del destino
                            return(true);
                            }
                else return(false);
        }
        
        return(false);
    }
    
    
    
    
   
    
}
