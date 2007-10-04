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
    
    protected int id_tablero; //numero de tablero
    protected boolean turno;    //turno del jugador (BLANCAS=0, NEGRAS=1)
    protected Casilla tablero[][];
        
    /** Creates a new instance of Tablero */
    public Tablero() {        
    }
    
    /**Crea una tablero con los atributos especificados*/
    public Tablero(int id, boolean tur){
        this.id_tablero=id;
        this.turno=tur;
        tablero = new Casilla[8][8];
        }
    
    /**Coloca las fichas en sus posiciones iniciales*/
    public Tablero inicializar_tablero(Tablero tablero){
        
        //CREA LAS INSTANCIAS DE LAS FICHAS (por ahora, alfiles)
        int i=0,j=0;
        int id_ficha = 0;
        
        //Creamos FICHAS de tipo ALFIL blancos
        Ficha alf_b_1 = new Alfil(id_ficha,false);
        id_ficha++;
        Ficha alf_b_2 = new Alfil(id_ficha,false);
        id_ficha++;
        //Creamos alfiles negros
        Ficha alf_n_1 = new Alfil(id_ficha,true);
        id_ficha++;
        Ficha alf_n_2 = new Alfil(id_ficha,true);
        id_ficha++;
        
        //CREA LAS INSTANCIAS CASILLAS DEL TABLERO
        Casilla cas;
        int m=0,n=0,id=0;
        int id_casilla= 0;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(id_casilla,null,m,n,false);
                id_casilla++;
            }
        
        
        //Asociamos las fichas(alfiles) a sus posiciones en el tablero.
        tablero.tablero[0][2].setFicha(alf_n_1);
        tablero.tablero[0][5].setFicha(alf_n_2);
        tablero.tablero[7][2].setFicha(alf_b_1);
        tablero.tablero[7][5].setFicha(alf_b_2);
        
       
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
    
    /**Busca la casilla solicitada en el tablero, si no la encuentra devuelve null*/
    public Casilla getCasilla(int fila, int columna){
        
        return(tablero[fila][columna]);
    }
    
    public void setCasilla(Casilla casilla, int fila, int columna){
        tablero[fila][columna]=casilla;
    }
    public boolean mover(int filaorigen, int columnaorigen, int filadestino, int columnadestino, Tablero tablero){
        
        boolean mov_per=comprobar_movimiento(filaorigen,columnaorigen,filadestino,columnadestino,tablero);
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
                tablero.cambio_turno();
                
                return(true);
                
        }
        else{
            System.out.println("No puede realizarse el movimiento solicitado. " +
                    "No es un movimiento permitido.");
            return(false);
        }
        
        
    }
    
    public boolean dentro_tablero(int fila, int columna){
        if((fila>=0)&&(fila<=7)&&(columna<=7)&&(columna>=0)) 
            return(true);
        else return(false);
    }
    
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, 
        int filadestino, int columnadestino, Tablero tablero){
        
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
        Casilla casillaorigen=tablero.getCasilla(filaorigen,columnaorigen);
        Ficha fichaorigen=casillaorigen.getFicha();
        
        //Llamamos al metodo abstracto MOVIMIENTO_CORRESPONDIENTE_FICHA
        boolean mcf=fichaorigen.movimiento_correspondiente_ficha(this,filaorigen,columnaorigen,filadestino,columnadestino);
        if(mcf){
        //Se obtienen la casilla y la ficha del destino
        Casilla casilladestino=getCasilla(filadestino,columnadestino);
        
        Ficha fichadestino=casilladestino.getFicha();
        
            if(fichaorigen.getColor()!=turno) 
            { 
                System.out.println("La ficha que se quiere mover no es del color del turno de la partida.");
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
        
        }{
            System.out.println("Ese movimiento no se corresponde con esa ficha.");
            return(false); //La condicion de que el movimiento es el correspondiente es falsa.
        }
        
        }
        else {
            if(origen_valido){
                 System.out.println("El destino no es valido.");
            }else {
                System.out.println("El origen no es valido.");
            }
            return(false);//No se da la condicion del if. No estan dentro del tablero
        }
        
    
    }
    
  
    
}
