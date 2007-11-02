/*
 * Fide.java
 *
 * Created on 31 de octubre de 2007, 13:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

  /**
 *
 * @author Pablo
 */

public class Fide {
    
    /** Creates a new instance of Fide */
    public Fide() {
    }
    
    
    /**Metodo que recibe una cadena de caracteres y convierte esta en las
     *coordenadas correspondientes comprensibles por el modelo*/
    public int[] de_fide_a_modelo(Partida partida, String coordenadas_fide){
        int coordenadas[] = new int[4]; 
        
        coordenadas=iniciar_parser(partida, coordenadas_fide);
        
     return(coordenadas);   
    }
    
    
    private int[] iniciar_parser(Partida partida, String coordenadas_fide){
        int coordenadas[] = new int[4];
        
        char c= obtenerCaracter(coordenadas_fide);
        coordenadas_fide=avanzar(coordenadas_fide);
        
        switch(c){
            case 'T':   coordenadas=stateTorre(partida,coordenadas_fide);
                        break;
            case 'C':   coordenadas=stateCaballo(partida,coordenadas_fide);
                        break;
            case 'A':   coordenadas=stateAlfil(partida,coordenadas_fide);
                        break;
            case 'D':   coordenadas=stateDama(partida,coordenadas_fide);
                        break;
            case 'R':   coordenadas=stateRey(partida,coordenadas_fide);
                        break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':   coordenadas=statePeon(partida,coordenadas_fide);
                        break;
                        
            default: 
                                                
        }
     return(coordenadas);   
    }
   
    private char obtenerCaracter(String coordenadas_fide){
     char c=coordenadas_fide.charAt(0);
        return(c);
    } 
    
    /**Esta funcion avanza en el string, actualizando el nuevo string*/
    private String avanzar(String coordenadas_fide){
        return(coordenadas_fide.substring(1));
    }
    
    private int[] stateTorre(Partida partida, String coordenadas_fide){
        int[] mov = new int[4];
        boolean existeficha;
        boolean turno=partida.getTurno();
        //Busqueda de la torre que pueda mover a donde indica el char[]
        existeficha=existeFicha(partida,"torre",turno,coordenadas_fide);
        
        return(mov);
    }
    
    private int[] stateCaballo(Partida partida, String coordenadas_fide){
        int[] mov = new int[4];
        boolean existeficha;
        boolean turno=partida.getTurno();
        //Busqueda de la torre que pueda mover a donde indica el char[]
        existeficha=existeFicha(partida,"caballo",turno,coordenadas_fide); 
        
        return(mov);
    }
    
    private int[] stateAlfil(Partida partida, String coordenadas_fide){
        int[] mov = new int[4];
        boolean existeficha;
        boolean turno=partida.getTurno();
        //Busqueda de la torre que pueda mover a donde indica el char[]
        existeficha=existeFicha(partida,"alfil",turno,coordenadas_fide);
        
        return(mov);
    }
    
    private int[] stateDama(Partida partida, String coordenadas_fide){
        int[] mov = new int[4];
        boolean existeficha;
        boolean turno=partida.getTurno();
        //Busqueda de la torre que pueda mover a donde indica el char[]
        existeficha=existeFicha(partida,"dama",turno,coordenadas_fide);
        
        return(mov);
    }
            
    private int[] stateRey(Partida partida, String coordenadas_fide){
        int[] mov = new int[4];
        boolean existeficha;
        boolean turno=partida.getTurno();
        //Busqueda de la torre que pueda mover a donde indica el char[]
        existeficha=existeFicha(partida,"rey",turno,coordenadas_fide);
        
       return(mov);
    }
    
    private int[] statePeon(Partida partida, String coordenadas_fide){
        int[] mov = new int[4];
        boolean existeficha;
        boolean turno=partida.getTurno();
        //Busqueda de la torre que pueda mover a donde indica el char[]
        existeficha=existeFicha(partida,"peon",turno,coordenadas_fide);
        
        return(mov);
    }
    
    private boolean existeFicha(Partida partida, String tipo_ficha, boolean color, String movimiento){
        boolean existedestino;
        int[] coor = new int[2];
        char c=obtenerCaracter(movimiento);
        movimiento=avanzar(movimiento);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
            if(partida.tablero.tablero[i][j].getOcupada()&&
                    partida.tablero.tablero[i][j].getFicha().getTipo_ficha().equals(tipo_ficha)&&
                    partida.tablero.tablero[i][j].getFicha().getColor()==color){
                        coor[0]=i;
                        coor[1]=j;
                        existedestino=existeDestino(partida,movimiento,coor);
              
            }
        }
        return(true);
    }
    
    /**Esta funcion busca, para una casilla dada, si el destino
     introducido en "movimiento" es correcto y accesible.*/
    private boolean existeDestino(Partida partida, String movimiento, int[] coor){
        
        
     return(true);   
    }
}
