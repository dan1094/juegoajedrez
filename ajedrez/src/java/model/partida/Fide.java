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
        String traduciendo = new String (coordenadas_fide); //Copia del String para no modificarlo
                
        
        coordenadas=iniciar_parser(partida, traduciendo);
        
     return(coordenadas);   
    }
    
    
    private int[] iniciar_parser(Partida partida, String traduciendo){
        int coordenadas[] = new int[4];
        
        char c= obtenerCaracter(traduciendo);
       
        
        switch(c){
            case 'T':   coordenadas=stateTorre(partida,traduciendo);
                        break;
            case 'C':   coordenadas=stateCaballo(partida,traduciendo);
                        break;
            case 'A':   coordenadas=stateAlfil(partida,traduciendo);
                        break;
            case 'D':   coordenadas=stateDama(partida,traduciendo);
                        break;
            case 'R':   coordenadas=stateRey(partida,traduciendo);
                        break;
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':   coordenadas=statePeon(partida,traduciendo);
                        break;
                        
            default: 
                                                
        }
     return(coordenadas);   
    }
   
    private char obtenerCaracter(String traduciendo){
     char c=traduciendo.charAt(0);
     traduciendo=traduciendo.substring(1);
        return(c);
    } 
    
    private int[] stateTorre(Partida partida, String traduciendo){
        int[] mov = new int[4];
        int[][] lista_fichas = new int[2][8];
       
        int i=0,j=0,indice_ficha=0;
        boolean turno=partida.getTurno();
        
        lista_fichas=obtenerFichas(partida,"torre",turno);
        char c=obtenerCaracter(traduciendo);
                
        if(es_letra_min(c)){
            mov=stateMoviendo(partida, lista_fichas, traduciendo);
        }else   if(es_numero_1a8(c)){
                    mov=stateMoviendo_mismacolumna(partida, lista_fichas, traduciendo);
                }else    if(c=='x'){
                             mov=stateComiendo(partida, lista_fichas, traduciendo);
                         }
        
            
        return(mov);
    }
    
    private int[] stateCaballo(Partida partida, String traduciendo){
        int[] mov = new int[4];
        int[][] lista_fichas = new int[2][8];
        boolean existeficha;
        boolean turno=partida.getTurno();
       
        lista_fichas=obtenerFichas(partida,"caballo",turno); 
        char c=obtenerCaracter(traduciendo);
        
        
        if(es_letra_min(c)){}
        else if(es_numero_1a8(c)){}
        else if(c=='x'){}
        
            
        return(mov);
        
    }
    
    private int[] stateAlfil(Partida partida, String traduciendo){
        int[] mov = new int[4];
        int[][] lista_fichas = new int[2][8];
        boolean existeficha;
        boolean turno=partida.getTurno();
        
        lista_fichas=obtenerFichas(partida,"alfil",turno);
        char c=obtenerCaracter(traduciendo);
        
        
        if(es_letra_min(c)){}
        else if(es_numero_1a8(c)){}
        else if(c=='x'){}
        
            
        return(mov);
    }
    
    private int[] stateDama(Partida partida, String traduciendo){
        int[] mov = new int[4];
        int[][] lista_fichas = new int[2][8];
        int[][] lista_fichas_validas = new int[2][8];
        boolean turno=partida.getTurno();
        
        lista_fichas=obtenerFichas(partida,"dama",turno);
        
        char c=obtenerCaracter(traduciendo);
                
        if(es_letra_min(c)){}
        else if(es_numero_1a8(c)){}
        else if(c=='x'){}
        
            
        return(mov);
    }
            
    private int[] stateRey(Partida partida, String traduciendo){
        int[] mov = new int[4];
        int[][] lista_fichas = new int[2][8];
        boolean existeficha;
        boolean turno=partida.getTurno();
        
        lista_fichas=obtenerFichas(partida,"rey",turno);
        
        char c=obtenerCaracter(traduciendo);
 
        
        if(es_letra_min(c)){}
        else if(es_numero_1a8(c)){}
        else if(c=='x'){}
        
            
        return(mov);
    }
    
    private int[] statePeon(Partida partida, String traduciendo){
        int[] mov = new int[4];
        int[][] lista_fichas = new int[2][8];
        boolean existeficha;
        boolean turno=partida.getTurno();
     
        lista_fichas=obtenerFichas(partida,"peon",turno);
       
        char c=obtenerCaracter(traduciendo);
       
        
        if(es_letra_min(c)){}
        else if(es_numero_1a8(c)){}
        else if(c=='x'){}
        
            
        return(mov);
    }
    
    private int[][] obtenerFichas(Partida partida, String tipo_ficha, boolean color){
        boolean existedestino;
        int[][] coor = new int[2][8];   //como maximo podremo encontrarnos 8 fichas (peones).
        coor=this.inicializacion(coor); //inicializamos la matriz a -1's.  
        int m=0;
               
        //Se recorre el tablero, añadiendo todas las coordenadas de las fichas que cumplan
        //con el primer requisito(posision inicial,turno=color,tipoficha).
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
            if(partida.tablero.tablero[i][j].getOcupada()&&
                    partida.tablero.tablero[i][j].getFicha().getTipo_ficha().equals(tipo_ficha)&&
                    partida.tablero.tablero[i][j].getFicha().getColor()==color){
                        //Ha encontrado una de las fichas que puede cumplir el movimiento
                        //guardamos sus coordenadas
                        coor[m][0]=i;
                        coor[m][1]=j;
                        m++;
            }
        }
        return(coor);
    }
    
    /**Esta funcion busca, para una casilla dada, si el destino
     introducido en "movimiento" es correcto y accesible.*/
    private boolean existeDestino(Partida partida, String movimiento, int[] coor){
        int i=coor[0],j=coor[1];
        
        
        
            
     return(true);   
    }
    
    private int[][] inicializacion(int[][] coordenadas){
        for(int i=0;i<2;i++)
            for(int j=0;j<8;j++)
                coordenadas[i][j]=-1;
        return(coordenadas);
    }
    
    private boolean hayficha(int[][] lista_fichas, int indice){
        if((lista_fichas[0][indice]!=-1)&&(lista_fichas[1][indice]!=-1)) 
            return(true);
        else return(false);
    }
    
    private int[][] obtenerFichasConDestinosValidos(Partida partida, int[][] lista, String cadena_coord){
        int[][] fichas_validas = new int[2][8];
        
        
        
        return(fichas_validas);
    }
    
    private boolean es_letra_min(char letra){
        if(letra=='a'||letra=='b'||letra=='c'||letra=='d'||
                letra=='e'||letra=='f'||letra=='g'||letra=='h')
            return(true);
        else return(false);
    }
    
    private boolean es_numero_1a8(char letra){
        if(letra=='1'||letra=='2'||letra=='3'||letra=='4'||
                letra=='5'||letra=='6'||letra=='7'||letra=='8')
            return(true);
        else return(false);
    }
    
    private int[] stateMoviendo(Partida partida, int[][] lista_fichas, String traduciendo){
        char c =obtenerCaracter(traduciendo);
        
        
    }
    
    private int[] stateMoviendo_mismacolumna(Partida partida, int[][] lista_fichas, String traduciendo){
        
    }
    
    private int[] stateComiendo(Partida partida, int[][] lista_fichas, String traduciendo){
        //Moviendo una ficha F, comiendo, a:
        char c=obtenerCaracter(traduciendo);
        int col=0,fil;
        
        if(es_letra_min(c)){ //letra de "a" a "h".
            col=this.convertirColumna(c);
            c=obtenerCaracter(traduciendo);
            if(es_numero_1a8(c)){
                fil=this.convertirFila(c);
                
            }else ;
            
            
        }else ;
    }
    
    private int convertirFila(char a){
        switch(a){
            case '1': return(7);
            case '2': return(6);
            case '3': return(5);
            case '4': return(4);
            case '5': return(3);
            case '6': return(2);
            case '7': return(1);
            case '8': return(0);
            default: return(-1);
        }       
   }
   
    
    private int convertirColumna(char a){
        switch(a){
            case 'a': return(0);
            case 'b': return(1);
            case 'c': return(2);
            case 'd': return(3);
            case 'e': return(4);
            case 'f': return(5);
            case 'g': return(6);
            case 'h': return(7);
            default: return(8);
      
        }
    }
}
