/*
 * Fide.java
 *
 * Created on 31 de octubre de 2007, 11:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controller;

import model.partida.Casilla;
import model.partida.Ficha;
import model.partida.Partida;
import model.partida.Tablero;


  /**
 *
 * @author Pablo
 */

public class Fide {
    
    String traduciendo;
    
    /** Creates a new instance of Fide */
    public Fide() {
    }
    
    
    /**Metodo que recibe una cadena de caracteres y convierte esta en las
     *coordenadas correspondientes comprensibles por el modelo*/
    public int[] de_fide_a_modelo(Partida partida, String coordenadas_fide){
        int coordenadas[] = new int[4];
        this.traduciendo=coordenadas_fide;
            
        coordenadas=iniciar_parser(partida);
        
     return(coordenadas);   
    }
    
    public int[] iniciar_parser(Partida partida){
        int coordenadas[] = new int[4];
        
        char c= obtenerCaracter();
        if(esMayuscula(c)) coordenadas=state1(partida,c );
        else    if(esMinuscula(c)) coordenadas=state22(partida,c);    
                else if(c=='O') coordenadas=state18(partida );
     return(coordenadas);   
    }
    
    public int[] state1(Partida partida, char c ){
        System.out.println("Entra en el estado 1");
        int coordenadas[] = new int[4];
        String tipo_ficha=this.asociarTipoficha(c);
        c=obtenerCaracter();
        if(esMinuscula(c)) coordenadas=state5(partida, c,tipo_ficha);
        else    if(esNumero(c)) coordenadas=state12(partida, c,tipo_ficha);
                else    if(c=='x') coordenadas=state2(partida, tipo_ficha);
                        else return(null);
           return(coordenadas);
    }
    
    public int[] state2(Partida partida,String tipo_ficha){
        System.out.println("Entra en el estado 2");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state3(partida,   c, tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    } 
    
    public int[] state3(Partida partida, char c, String tipo_ficha){
        System.out.println("Entra en el estado 3");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=obtenerCaracter( );
        if(esNumero(c)) coordenadas=state4(partida, colDestino,c,tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    }
    
    public int[] state4(Partida partida,int colDestino, char c, String tipo_ficha){
        System.out.println("Entra en el estado 4");
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin();
        if(!partida.tablero.tablero[filaDestino][colDestino].getOcupada())
            return(null);
        else    if(fin) coordenadas=buscarMovimiento4_6(partida,tipo_ficha,filaDestino,colDestino);
                else    return(null);
        
        return(coordenadas);
        
    }
    
    public int[] state5(Partida partida,char c, String tipo_ficha){
        System.out.println("Entra en el estado 5");
        int[] coordenadas = new int[4];
        int columna=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state6(partida, columna,c,tipo_ficha);
        else    if(esMinuscula(c)) coordenadas=state8(partida, columna,c,tipo_ficha);
                else    if(c=='x') coordenadas=state7(partida, columna,tipo_ficha);
                else return(null);
        
        return(coordenadas);
    }
    
    public int[] state6(Partida partida, int colDestino, char c, String tipo_ficha){
        System.out.println("Entra en el estado 6");
        int[] coordenadas=new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin( );
        if(partida.tablero.tablero[filaDestino][colDestino].getOcupada()) return(null);
        else{
            if(fin) coordenadas=buscarMovimiento4_6(partida,tipo_ficha,filaDestino,colDestino);
            else return(null);
        }
               
        return(coordenadas);
    }
    
    public int[] state7(Partida partida,int colOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 7");
        int[] coordenadas=new int[4];
        char c=this.obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state9(partida, c,colOrigen,tipo_ficha);
        else return(null);
        
        return(coordenadas);
        
    }
    
    public int[] state8(Partida partida, int colOrigen, char c_sig, String tipo_ficha){
        System.out.println("Entra en el estado 8");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c_sig);
        char c=this.obtenerCaracter( );
               
        if(esNumero(c)) coordenadas=state11(partida,   colOrigen, c, colDestino,tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state9(Partida partida,char c, int colOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 9");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state10(partida, c,colOrigen, colDestino,tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state10(Partida partida,char c, int colOrigen, int colDestino, String tipo_ficha){
        System.out.println("Entra en el estado 10");
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin( );
        if(fin&&partida.tablero.tablero[filaDestino][colDestino].getOcupada()) 
            coordenadas=buscarMovimiento10_11(partida,colOrigen,filaDestino,colDestino, tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state11(Partida partida,int colOrigen, char c, int colDestino, String tipo_ficha){
        System.out.println("Entra en el estado 11");
        int[] coordenadas = new int[4];
        int filaDestino = this.convertirFila(c);
        boolean fin=comprobarfin( );
        
        if(fin) coordenadas=buscarMovimiento10_11(partida,colOrigen,filaDestino,colDestino,tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state12(Partida partida,char c, String tipo_ficha){
        System.out.println("Entra en el estado 12");
        int[] coordenadas = new int[4];
        int filaOrigen=this.convertirFila(c);
        c=obtenerCaracter( );
        if(c=='x') coordenadas=state13(partida,   filaOrigen, tipo_ficha);
        else    if(esMinuscula(c)) coordenadas=state14(partida,   c, filaOrigen, tipo_ficha);
                else    return(null);
        
        return(coordenadas);
        
    }
    
    public int[] state13(Partida partida,int filaOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 13");
        int[] coordenadas=new int[4];
        
        char c=this.obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state15(partida,   filaOrigen, c, tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    }
    
    public int[] state14(Partida partida,char c, int filaOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 14");
        int[] coordenadas=new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state16(partida,   c, filaOrigen, colDestino, tipo_ficha);
        else return(null);
               
        return(coordenadas);
    }
    
    public int[] state15(Partida partida,int filaOrigen, char c, String tipo_ficha){
        System.out.println("state15");
        int[] coordenadas=new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state17(partida,   filaOrigen, c, colDestino, tipo_ficha);
        else    return(null);
        
        return(coordenadas);
    }
    
    public int[] state16(Partida partida,char c, int filaOrigen, int colDestino, String tipo_ficha){
        System.out.println("state16");
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin( );
        
        if(fin) coordenadas=buscarMovimiento16(partida, filaOrigen, filaDestino, colDestino, tipo_ficha);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state17(Partida partida,int filaOrigen, char c, int colDestino, String tipo_ficha){
        System.out.println("state17");
        int[] coordenadas = new int[4];
        int filaDestino = this.convertirFila(c);
        boolean fin=comprobarfin( );
        if(!partida.tablero.tablero[filaDestino][colDestino].getOcupada()) return(null);
        else{
                if(fin) coordenadas = buscarMovimiento17(partida, filaOrigen, filaDestino, colDestino, tipo_ficha);
                else return(null);
        }
        return(coordenadas);
    }
    
    public int[] state18(Partida partida ){
        System.out.println("state18");
        int[] coordenadas=new int[4];
        char c=obtenerCaracter( );
        if(c=='-') coordenadas=state19(partida );
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state19(Partida partida ){
        System.out.println("state19");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(c=='O') coordenadas= state20(partida);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state20(Partida partida ){
        System.out.println("state20");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(c=='-') coordenadas=state21(partida );
        else    if(comprobarfin( )) coordenadas=enroqueCorto(partida);
                else return(null);
        
        return(coordenadas);
    }
    
    public int[] state21(Partida partida ){
        System.out.println("state21");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        boolean fin=comprobarfin( );
        if(fin){
            if(c=='O') coordenadas=enroqueLargo(partida);
            else return(null);
        }else return(null);
        
        return(coordenadas);
    }
    
    public int[] state22(Partida partida, char c ){
        System.out.println("Entra en el estado 22");
        int[] coordenadas = new int[4];
        int columna=this.convertirColumna(c);
        c=obtenerCaracter( );
        if(esNumero(c)) coordenadas=state23(partida,columna,c );
        else    if(c=='x') coordenadas=state24(partida,columna );
                else return(null);
        
        return(coordenadas);
    }
    
    public int[] state23(Partida partida, int colDestino,char c ){
        System.out.println("Entra en el estado 23");
        int colOrigen=colDestino;
        int[] ficha=new int[2];
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=this.comprobarfin( );
        if(!fin) return(null);
        if(partida.getTurno()){
                if(partida.tablero.tablero[filaDestino-1][colOrigen].getOcupada()&&
                        partida.tablero.tablero[filaDestino-1][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        partida.tablero.tablero[filaDestino-1][colOrigen].getFicha().getColor()==partida.getTurno()){
                coordenadas[0]=filaDestino-1;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else   if(partida.tablero.tablero[filaDestino-2][colOrigen].getOcupada()&&
                        partida.tablero.tablero[filaDestino-2][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        partida.tablero.tablero[filaDestino-2][colOrigen].getFicha().getColor()==partida.getTurno()){
                coordenadas[0]=filaDestino-2;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else return(null);
           }else if(partida.tablero.tablero[filaDestino+1][colOrigen].getOcupada()&&
                        partida.tablero.tablero[filaDestino+1][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        partida.tablero.tablero[filaDestino+1][colOrigen].getFicha().getColor()==partida.getTurno()){
                coordenadas[0]=filaDestino+1;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else   if(partida.tablero.tablero[filaDestino+2][colOrigen].getOcupada()&&
                        partida.tablero.tablero[filaDestino+2][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        partida.tablero.tablero[filaDestino+2][colOrigen].getFicha().getColor()==partida.getTurno()){
                coordenadas[0]=filaDestino+2;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else return(null);
        
        return(coordenadas);
      
    }
    
    public int[] state24(Partida partida, int columna ){
        System.out.println("state24");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state25(partida, columna, c);
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state25(Partida partida, int colOrigen, char c ){
        System.out.println("state25");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=obtenerCaracter( );
        if(esNumero(c)) coordenadas=state26(partida,c,colOrigen,colDestino );
        else return(null);
        
        return(coordenadas);
    }
    
    public int[] state26(Partida partida, char c, int colOrigen, int colDestino ){
        System.out.println("state26");
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
        System.out.println("Entra buscarMovimiento 4,6");
        int[] coordenadas=new int[4];
        int[][] fichas=new int[2][8];
        fichas=inicializacion(fichas);
        int[][] fichas_validas=new int[2][8];
        fichas_validas=inicializacion(fichas_validas);
        int filaOrigen=0,colOrigen=0,i=0;;
        boolean bien=false;
        boolean hFicha=true;
        
        fichas=buscarFichas(partida,tipo_ficha);
        
        for(int j=0;(j<8)&&hFicha;j++){
            filaOrigen=fichas[0][j];
            colOrigen=fichas[1][j];
            hFicha=hayFicha(fichas,i+1);
            i++;
            if(this.comprobar_movimiento(filaOrigen,colOrigen,filaDestino,colDestino,partida))
                fichas_validas=aniadir(filaOrigen,colOrigen,fichas_validas);
        }
    
        coordenadas=transformar(fichas_validas,filaDestino,colDestino);
       
        return(coordenadas);
    }
    
    public boolean hayFicha(int[][] fichas, int i){
        if(fichas[0][i]==-1) return(false);
        else return(true);
    }
    
    public int[] buscarMovimiento10_11(Partida partida, int cO, int fD, int cD, String tipo_ficha){
        int[] coordenadas = new int[4];
        int[] ficha = new int[2];
              
        ficha=buscarFichaMismaFila(partida,tipo_ficha,cO);
        if(this.comprobar_movimiento(ficha[0],ficha[1],fD,cD,partida)){
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
            if(comprobar_movimiento(ficha[0],ficha[1],filaDestino,colDestino,partida)){
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
         
         if(this.comprobar_movimiento(ficha[0],ficha[1],filaDestino,colDestino,partida)){
                coordenadas[0]=ficha[0];
                coordenadas[1]=ficha[1];
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                return(coordenadas);
            }else return(null);
    }
    
    public int[][] aniadir(int filaO, int colO,int[][] fichas_validas){
        boolean fin=false;
        System.out.println("Dentro de añadir");
        
        for(int i=0;(i<8)&&(!fin);i++){
            if(fichas_validas[0][i]==-1){
                System.out.println("Añade la fila="+filaO+" columna="+colO);
                fichas_validas[0][i]=filaO;
                fichas_validas[1][i]=colO;
                fin=true;
            }
        }
        return(fichas_validas);
    }
    
    public boolean correcto(int[][] lista){
        System.out.println("Dentro de correcto.");
        for(int i=0;i<2;i++)
            for(int j=0;j<8;j++)
                System.out.print(lista[i][j]);
        if((lista[0][2]==-1)) return(true);
        else return(false);
    }
    
    public int[] transformar(int[][] fichas_validas, int fD, int cD){
        int[] coordenadas = new int[4];
        coordenadas[0]=fichas_validas[0][0];
        coordenadas[1]=fichas_validas[1][0];
        coordenadas[2]=fD;
        coordenadas[3]=cD;
//        System.out.println("FO= "+coordenadas[0]);
//        System.out.println("CO= "+coordenadas[1]);
//        System.out.println("FD= "+coordenadas[2]);
//        System.out.println("CD= "+coordenadas[3]);
        
        return(coordenadas);
    }
    
    public char obtenerCaracter(){
     char c=traduciendo.charAt(0);
     traduciendo=traduciendo.substring(1);
     this.traduciendo=traduciendo;
     System.out.println("CARACTER: "+c);
     
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
    
    public int[] buscarPeon(Partida partida, int colOrigen, int filaDestino, int colDestino){
        int[] coordenadas = new int[4];
        for(int i=0;i<8;i++){
            if(partida.getTurno()){//TURNO NEGRAS
                if(partida.tablero.tablero[i][colDestino].getOcupada()&&
                   partida.tablero.tablero[i][colDestino].getFicha().getTipo_ficha().equals("peon")){
                    
                    
                    
                }
                    
            }else{ //TURNO BLANCAS
                if(partida.tablero.tablero[i][colDestino].getOcupada()&&
                   partida.tablero.tablero[i][colDestino].getFicha().getTipo_ficha().equals("peon")){
                    
                }
                   
            }
        }
        return(coordenadas);
    }
           
    public int[][] inicializacion(int[][] fichas){
        for(int i=0;i<2;i++)
            for(int j=0;j<8;j++)
                fichas[i][j]=-1;
        
        
        return(fichas);
    }
    
    public boolean comprobarfin(){
        if(this.traduciendo.length()==0) return(true);
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
        
        fichas=inicializacion(fichas);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                if(partida.tablero.tablero[i][j].getOcupada()&&
                        partida.tablero.tablero[i][j].getFicha().getColor()==partida.getTurno()&&
                        partida.tablero.tablero[i][j].getFicha().getTipo_ficha().equals(tipo_ficha)){
                            System.out.println("I="+i+" ,J="+j);
                            fichas[0][m]=i;
                            fichas[1][m]=j;
                            m++;
                }
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
    
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, int filadestino, int columnadestino, Partida partida){
       
        //comprueba que el origen y el destino estan dentro del tablero
        boolean origen_dentro=partida.tablero.dentro_tablero(filaorigen,columnaorigen); 
        boolean destino_dentro=partida.tablero.dentro_tablero(filadestino,columnadestino);
       
        //ORIGEN Y DESTINO DENTRO. Y ORIGEN OCUPADO POR FICHA DEL COLOR ADECUADO.
        if(origen_dentro&&destino_dentro){
               
        //Para comprobar el movimiento necesitamos saber la ficha que se mueve
        Ficha fichaorigen=partida.tablero.tablero[filaorigen][columnaorigen].getFicha();
         System.out.println("Va a mover un/una: "+fichaorigen.getTipo_ficha());
        Ficha fichadestino;
        boolean mcf;
        
        Casilla casilladestino = partida.tablero.tablero[filadestino][columnadestino];
        
                if(fichaorigen.getColor()!=partida.getTurno()){
                    System.out.println("Pero no es de su color.");
                    return(false);
                }else if(!casilladestino.getOcupada()){
                                //origen del mismo color que el turno y casilla destino vacia
                                 System.out.println("La casilla destino esta vacia.");
                                 mcf=fichaorigen.movimiento_correspondiente_ficha(partida.tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                                 return(mcf);
                      }else if(casilladestino.getFicha().getColor()!=partida.getTurno()){
                                //origen=turno, y destino del color diferente. Se puede comer la ficha del destino.
                                fichadestino=casilladestino.getFicha();
                                mcf=fichaorigen.movimiento_correspondiente_ficha(partida.tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                                System.out.println("Casilla destino esta ocupada por un/una "+fichadestino.getTipo_ficha()+" del contrario.");
                                return(mcf);
                            }else if(casilladestino.getFicha().getColor()==partida.getTurno()){
                                        System.out.println("El destino esta ocupado por una ficha de su propio color.");  
                                  }else return(false);
        
        }else return(false);
        
    return(false);
    }
}
