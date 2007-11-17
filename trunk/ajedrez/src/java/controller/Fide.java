/*
 * Fide.java
 *
 * Created on 31 de octubre de 2007, 11:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.partida.Partida;


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
    
    
    public int[] iniciar_parser(Partida partida, String traduciendo){
        int coordenadas[] = new int[4];
        
        char c= obtenerCaracter(traduciendo);
       
        if(esMayuscula(c)) coordenadas=state1(partida,c,traduciendo);
        else    if(esMinuscula(c)) coordenadas=state22(partida,c,traduciendo);    
                else if(c=='O') coordenadas=state18(partida,traduciendo);
     return(coordenadas);   
    }
    
   
    //Es Mayuscula (Ficha)
    public int[] state1(Partida partida, char c, String traduciendo){
        int coordenadas[] = new int[4];
        String tipo_ficha=this.asociarTipoficha(c);
        c=obtenerCaracter(traduciendo);
        if(esMinuscula(c)) coordenadas=state5(partida,traduciendo,c,tipo_ficha);
        else    if(esNumero(c)) coordenadas=state12(partida,traduciendo,c,tipo_ficha);
                else    if(c=='x') coordenadas=state2(partida,traduciendo,tipo_ficha);
                        else return(null);
           return(coordenadas);
    }
    
    public int[] state2(Partida partida, String traduciendo, String tipo_ficha){
        int[] coordenadas = new int[4];
        char c=obtenerCaracter(traduciendo);
        if(esMinuscula(c)) coordenadas=state3(partida, traduciendo, c, tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    } 
    
    public int[] state3(Partida partida, String traduciendo, char c, String tipo_ficha){
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state4(partida,traduciendo,colDestino,c,tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    }
    
    public int[] state4(Partida partida, String traduciendo ,int colDestino, char c, String tipo_ficha){
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin(traduciendo);
        if(!partida.tablero.tablero[filaDestino][colDestino].getOcupada())
            return(null);
        else    if(fin) coordenadas=buscarMovimiento4_6(partida,tipo_ficha,filaDestino,colDestino);
                else    return(null);
        
        return(coordenadas);
        
    }
    
    public int[] state5(Partida partida, String traduciendo, char c, String tipo_ficha){
        int[] coordenadas = new int[4];
        int columna=this.convertirColumna(c);
        c=this.obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state6(partida,traduciendo,columna,c,tipo_ficha);
        else    if(esMinuscula(c)) coordenadas=state8(partida,traduciendo,columna,c,tipo_ficha);
                else    if(c=='x') coordenadas=state7(partida,traduciendo,columna,tipo_ficha);
                else return(null);
        
        return(coordenadas);
    }
    
    public int[] state6(Partida partida, String traduciendo, int colDestino, char c_sig, String tipo_ficha){
        //TIPO_FICHA, FILADESTINO, COLUMNADESTINO.
        int[] coordenadas=new int[4];
        int filaDestino=this.convertirFila(c_sig);
        boolean fin=comprobarfin(traduciendo);
        if(fin) coordenadas=buscarMovimiento4_6(partida,tipo_ficha,filaDestino,colDestino);
        else return(null);
               
        return(coordenadas);
    }
    
    public int[] state7(Partida partida, String traduciendo, int colOrigen, String tipo_ficha){
        int[] coordenadas=new int[4];
        char c=this.obtenerCaracter(traduciendo);
        if(esMinuscula(c)) coordenadas=state9(partida,traduciendo,c,colOrigen,tipo_ficha);
        else return(null);
        
        return(coordenadas);
        
    }
    
    public int[] state8(Partida partida, String traduciendo, int colOrigen, char c_sig, String tipo_ficha){
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c_sig);
        char c=this.obtenerCaracter(traduciendo);
               
        if(esNumero(c)) coordenadas=state11(partida, traduciendo, colOrigen, c, colDestino,tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state9(Partida partida, String traduciendo, char c, int colOrigen, String tipo_ficha){
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state10(partida,traduciendo,c,colOrigen, colDestino,tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state10(Partida partida, String traduciendo,char c, int colOrigen, int colDestino, String tipo_ficha){
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin(traduciendo);
        if(fin&&partida.tablero.tablero[filaDestino][colDestino].getOcupada()) 
            coordenadas=buscarMovimiento10_11(partida,colOrigen,filaDestino,colDestino, tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state11(Partida partida, String traduciendo, int colOrigen, char c, int colDestino, String tipo_ficha){
        int[] coordenadas = new int[4];
        int filaDestino = this.convertirFila(c);
        boolean fin=comprobarfin(traduciendo);
        
        if(fin) coordenadas=buscarMovimiento10_11(partida,colOrigen,filaDestino,colDestino,tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state12(Partida partida, String traduciendo, char c, String tipo_ficha){
        int[] coordenadas = new int[4];
        int filaOrigen=this.convertirFila(c);
        c=obtenerCaracter(traduciendo);
        if(c=='x') coordenadas=state13(partida, traduciendo, filaOrigen, tipo_ficha);
        else    if(esMinuscula(c)) coordenadas=state14(partida, traduciendo, c, filaOrigen, tipo_ficha);
                else    return(null);
        
        return(coordenadas);
        
    }
    
    public int[] state13(Partida partida, String traduciendo, int filaOrigen, String tipo_ficha){
        int[] coordenadas=new int[4];
        
        char c=this.obtenerCaracter(traduciendo);
        if(esMinuscula(c)) coordenadas=state15(partida, traduciendo, filaOrigen, c, tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    }
    
    public int[] state14(Partida partida, String traduciendo, char c, int filaOrigen, String tipo_ficha){
        int[] coordenadas=new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state16(partida, traduciendo, c, filaOrigen, colDestino, tipo_ficha);
        else return(null);
               
        return(coordenadas);
    }
    
    public int[] state15(Partida partida, String traduciendo, int filaOrigen, char c, String tipo_ficha){
        int[] coordenadas=new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state17(partida, traduciendo, filaOrigen, c, colDestino, tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    }
    
    public int[] state16(Partida partida, String traduciendo, char c, int filaOrigen, int colDestino, String tipo_ficha){
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin(traduciendo);
        
        if(fin) coordenadas=buscarMovimiento16(partida, filaOrigen, filaDestino, colDestino, tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state17(Partida partida, String traduciendo, int filaOrigen, char c, int colDestino, String tipo_ficha){
        int[] coordenadas = new int[4];
        int filaDestino = this.convertirFila(c);
        boolean fin=comprobarfin(traduciendo);
        
        if(fin) coordenadas = buscarMovimiento17(partida, filaOrigen, filaDestino, colDestino, tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state18(Partida partida, String traduciendo){
        int[] coordenadas=new int[4];
        char c=obtenerCaracter(traduciendo);
        if(c=='-') coordenadas=state19(partida,traduciendo);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state19(Partida partida, String traduciendo){
        int[] coordenadas = new int[4];
        char c=obtenerCaracter(traduciendo);
        if(c=='O') coordenadas= state20(partida, traduciendo);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state20(Partida partida, String traduciendo){
        int[] coordenadas = new int[4];
        char c=obtenerCaracter(traduciendo);
        if(c=='-') coordenadas=state21(partida,traduciendo);
        else    if(comprobarfin(traduciendo)) coordenadas=enroqueCorto(partida);
                else return(null);
        
        return(coordenadas);
    }
    
    public int[] state21(Partida partida, String traduciendo){
        int[] coordenadas = new int[4];
        char c=obtenerCaracter(traduciendo);
        boolean fin=comprobarfin(traduciendo);
        if(fin){
            if(c=='O') coordenadas=enroqueLargo(partida);
            else return(null);
        }else return(null);
        
        return(coordenadas);
    }
    
    public int[] state22(Partida partida, char c, String traduciendo){
        int[] coordenadas = new int[4];
        int columna=this.convertirColumna(c);
        c=obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state23(partida,columna,c,traduciendo);
        else    if(c=='x') coordenadas=state24(partida,columna,traduciendo);
                else return(null);
        
        return(coordenadas);
    }
    
    public int[] state23(Partida partida, int colDestino,char c, String traduciendo){
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=this.comprobarfin(traduciendo);
        if(!fin) return(null);
        if(partida.getTurno()){
                int filaOrigen=filaDestino-1;
                int colOrigen=colDestino;
                coordenadas[0]=filaOrigen;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
           }else{
                int filaOrigen=filaDestino+1;
                int colOrigen=colDestino;
                coordenadas[0]=filaOrigen;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
           }
        
        return(coordenadas);
      
    }
    
    public int[] state24(Partida partida, int columna, String traduciendo){
        int[] coordenadas = new int[4];
        char c=obtenerCaracter(traduciendo);
        if(esMinuscula(c)) coordenadas=state25(partida, columna, c, traduciendo);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state25(Partida partida, int colOrigen, char c, String traduciendo){
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=obtenerCaracter(traduciendo);
        if(esNumero(c)) coordenadas=state26(partida,c,colOrigen,colDestino,traduciendo);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state26(Partida partida, char c, int colOrigen, int colDestino, String traduciendo){
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        if(partida.tablero.tablero[filaDestino][colDestino].getOcupada()){
            if(partida.getTurno()){
                coordenadas[0]=filaDestino-1;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
            }else{
                coordenadas[0]=filaDestino+1;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                
            }
        }else return(null);
        
        return(coordenadas);
    }
    
    public int[] buscarMovimiento4_6(Partida partida, String tipo_ficha, int filaDestino, int colDestino){
        int[] coordenadas=new int[4];
        int[][] fichas=new int[2][8];
        int[][] fichas_validas=new int[2][8];
        int filaOrigen=0,colOrigen=0;
        boolean bien=false;
        
        fichas=buscarFichas(partida,tipo_ficha);
        
        for(int j=0;(j<8);j++){
            filaOrigen=fichas[0][j];
            colOrigen=fichas[1][j];
            if(partida.comprobar_movimiento(filaOrigen,colOrigen,filaDestino,colDestino,partida.tablero))
                fichas_validas=aniadir(filaOrigen,colOrigen,fichas_validas);
        }
        
        bien=correcto(fichas_validas);
        if(bien) coordenadas=transformar(fichas_validas,filaDestino,colDestino);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] buscarMovimiento10_11(Partida partida, int cO, int fD, int cD, String tipo_ficha){
        int[] coordenadas = new int[4];
        int[] ficha = new int[2];
              
        ficha=buscarFichaMismaFila(partida,tipo_ficha,cO);
        if(partida.comprobar_movimiento(ficha[0],ficha[1],fD,cD,partida.tablero)){
        coordenadas[0]=ficha[0];
        coordenadas[1]=ficha[1];
        coordenadas[2]=fD;
        coordenadas[3]=cD;
        return(coordenadas);
        }else return(null);
        
    }
    
    public int[] buscarMovimiento17(Partida partida, int filaOrigen, int filaDestino, int colDestino, String tipo_ficha){
        int[] coordenadas = new int[4];
        int[] ficha = new int[2];
        
        ficha=buscarFichaMismaColumna(partida,tipo_ficha,filaOrigen);
        if(partida.tablero.tablero[filaDestino][colDestino].getOcupada()){
            if(partida.comprobar_movimiento(ficha[0],ficha[1],filaDestino,colDestino,partida.tablero)){
                coordenadas[0]=ficha[0];
                coordenadas[1]=ficha[1];
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                return(coordenadas);
            }else return(null);
        }else return(null);
        
    }
    
    public int[] buscarMovimiento16(Partida partida, int filaOrigen, int filaDestino, int colDestino, String tipo_ficha){
         int[] coordenadas = new int[4];
         int[] ficha = new int[2];
         
         ficha=buscarFichaMismaColumna(partida,tipo_ficha,filaOrigen);
         
         if(partida.comprobar_movimiento(ficha[0],ficha[1],filaDestino,colDestino,partida.tablero)){
                coordenadas[0]=ficha[0];
                coordenadas[1]=ficha[1];
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                return(coordenadas);
            }else return(null);
    }
    
    public int[][] aniadir(int filaO, int colO,int[][] fichas_validas){
        for(int i=0;i<8;i++)
            if(fichas_validas[0][i]==-1){
                fichas_validas[0][i]=filaO;
                fichas_validas[1][i]=colO;
            }
        
        return(fichas_validas);
    }
    
    /**Esta funcion comprueba que solo una ficha puede realizar el movimiento solicitado*/
    public boolean correcto(int[][] lista){
        if(lista[0][1]==-1) return(true);
        else return(false);
    }
    
    public int[] transformar(int[][] fichas, int fD, int cD){
        int[] coordenadas = new int[4];
        coordenadas[0]=fichas[0][0];
        coordenadas[1]=fichas[1][0];
        coordenadas[2]=fD;
        coordenadas[3]=cD;
        return(coordenadas);
    }
    
    public char obtenerCaracter(String traduciendo){
     char c=traduciendo.charAt(0);
     traduciendo=traduciendo.substring(1);
        return(c);
    }
    
    public String asociarTipoficha(char c){
        switch(c){
            case 'A': return("alfil");
            case 'C': return("caballo");
            case 'T': return("torre");
            case 'D': return("dama");
            case 'R': return("rey");
            default: return(null);
        }
    }
    
    public boolean esMayuscula(char c){
        if((c=='T')||(c=='C')||(c=='A')||(c=='D')||(c=='R')) return(true);
        else return(false);
    }
    
    public boolean esMinuscula(char c){
        if((c=='a')||(c=='b')||(c=='c')||(c=='d')||(c=='e')||
                (c=='f')||(c=='g')||(c=='h')) return(true);
        else return(false);
    }
       
    public boolean esNumero(char letra){
        if(letra=='1'||letra=='2'||letra=='3'||letra=='4'||
                letra=='5'||letra=='6'||letra=='7'||letra=='8')
            return(true);
        else return(false);
    }
        
    public int[][] obtenerFichas(Partida partida, String tipo_ficha, boolean color){
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
                        coor[0][0]=i;
                        coor[1][0]=j;
                        m++;
            }
        }
        return(coor);
    }
    
    public int[] buscarFichaMismaFila(Partida partida, String tipo_ficha, int col){
        int[] coor=new int[2];
        for(int i=0;i<8;i++)
            if(partida.tablero.tablero[i][col].getOcupada()&&
                partida.tablero.tablero[i][col].getFicha().getColor()==partida.getTurno()&&
                partida.tablero.tablero[i][col].getFicha().getTipo_ficha().equals(tipo_ficha)){
                    coor[0]=i;
                    coor[1]=col;
             }else return(null);
        
        return(coor);
        
    }
    public int[] buscarFichaMismaColumna(Partida partida, String tipo_ficha, int fila){
        int[] coor=new int[2];
        for(int j=0;j<8;j++)
            if(partida.tablero.tablero[fila][j].getOcupada()&&
                partida.tablero.tablero[fila][j].getFicha().getColor()==partida.getTurno()&&
                partida.tablero.tablero[fila][j].getFicha().getTipo_ficha().equals(tipo_ficha)){
                    coor[0]=fila;
                    coor[1]=j;
             }else return(null);
        
        return(coor);
    }
           
    public int[][] inicializacion(int[][] coordenadas){
        for(int i=0;i<2;i++)
            for(int j=0;j<8;j++)
                coordenadas[i][j]=-1;
        return(coordenadas);
    }
    
    public boolean comprobarfin(String trad){
        if(trad.length()==0) return(true);
        else return(false);
    }   
    
    public int convertirFila(char a){
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
       
    public int convertirColumna(char a){
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

    private int[][] buscarFichas(Partida partida, String tipo_ficha) {
        int[][] fichas=new int[2][8];
        int m=0;
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                if(partida.tablero.tablero[i][j].getOcupada()&&
                        partida.tablero.tablero[i][j].getFicha().getColor()==partida.getTurno()&&
                        partida.tablero.tablero[i][j].getFicha().getTipo_ficha().equals(tipo_ficha))
                            fichas[0][m]=i;
                            fichas[1][m]=j;
                            m++;
            }
        return(fichas);
    }
    
    public int[] enroqueCorto(Partida partida){
        int[] coordenadas = new int[4];
        boolean turno=partida.getTurno();
        if(turno){//Negras
            coordenadas[0]=0;
            coordenadas[1]=4;
            coordenadas[2]=0;
            coordenadas[3]=6;
        }else{//blancas
            coordenadas[0]=7;
            coordenadas[1]=4;
            coordenadas[2]=7;
            coordenadas[3]=6;
        }
        return(coordenadas);
    }
    
    public int[] enroqueLargo(Partida partida){
        int[] coordenadas = new int[4];
        boolean turno=partida.getTurno();
        if(turno){//Negras
            coordenadas[0]=0;
            coordenadas[1]=4;
            coordenadas[2]=0;
            coordenadas[3]=2;
        }else{//blancas
            coordenadas[0]=7;
            coordenadas[1]=4;
            coordenadas[2]=7;
            coordenadas[3]=4;
        }
        return(coordenadas);
    }
}
