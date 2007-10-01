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
    
    /**Coloca las fichas en sus posiciones iniciales*/
    public Tablero inicializar_tablero(Tablero tablero){
        //Aqui habria que modificar el tablero, colocando las fichas.
      return(tablero);  
    }
    
    /**Modificael turno*/
    public void setTurno(boolean turno){
        this.turno=turno;
    }
    /**Metodo que cambia el turno*/
    public void cambio_turno(){
        //Si el turno es False(BLANCAS) pasa a true(NEGRAS) y viceversa
        if(this.getTurno()) 
            this.setTurno(false);
        else this.setTurno(true);
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
                //Obtenemos las casillas
                Casilla origen=getCasilla(filaorigen,columnaorigen);
                Casilla destino=getCasilla(filadestino,columnadestino);
                //Ponemos en el destino la ficha del origen
                destino.setFicha(origen.getFicha());
                //Vaciamos la casilla origen
                origen.setFicha(null);
                //Ponemos ocupada a false en la casilla origen
                origen.ocupada=false;
                //Ponemos ocupada a true en el destino
                destino.ocupada=true;
        }
        //Habria que poner aqui un else con un mensaje de error, indicando que
        //el movimiento no esta permitido.
    }
    
    public boolean dentro_tablero(int fila, int columna){
        if(fila>=1&&fila<=8&&columna<=8&&columna>=1) return(true);
        else return(false);
    }
    
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, int filadestino, int columnadestino){
        
        boolean origen_valido=true;
        boolean destino_valido=true;
        
        //comprueba que el origen y el destino estan dentro del tablero
        
        origen_valido=dentro_tablero(filaorigen,columnaorigen); 
        destino_valido=dentro_tablero(filadestino,columnadestino);
        
        //Si el origen y el destino son validos seguimos
        if(origen_valido&&destino_valido)
        {
        
        //Ahora habria que comprobar que el movimiento se corresponde con el de la ficha
        //que se esta moviendo. Obtenemos la casilla, y luego la ficha.
        Casilla casillaorigen=getCasilla(filaorigen,columnaorigen);
        Ficha fichaorigen=casillaorigen.getFicha();
        
        //Llamamos al metodo abstracto MOVIMIENTO_CORRESPONDIENTE_FICHA
        boolean mcf=fichaorigen.movimiento_correspondiente_ficha(this,filaorigen,columnaorigen,filadestino,columnadestino);
         if(mcf){
        //Se obtienen la casilla y la ficha del destino
        Casilla casilladestino=getCasilla(filadestino,columnadestino);
        Ficha fichadestino=casilladestino.getFicha();
        
            if(fichaorigen.getColor()!=turno) 
            { 
                //La ficha que se quiere mover no es del color del turno de la partida.
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
                            //ficha del destino.
                
                            return(true);
                            }
                            else return(false);
        
        }return(false); //La condicion de que el movimiento es el correspondiente es falsa.
        
        }
        else return(false);//No se da la condicion del if. No estan dentro del tablero
        
    
    }
    
  
    
}
