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
import model.partida.Game;
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
    public int[] de_fide_a_modelo(Game game, String coordenadas_fide){
        int coordenadas[] = new int[4];
        this.traduciendo=coordenadas_fide;
        
            
        coordenadas=iniciar_parser(game);
        
     return(coordenadas);   
    }
    
    public int[] iniciar_parser(Game game){
        int coordenadas[] = new int[4];
        
        char c= obtenerCaracter();
        if(esMayuscula(c)) coordenadas=state1(game,c );
        else    if(esMinuscula(c)) coordenadas=state22(game,c);    
                else    if(c=='O') coordenadas=state18(game );
                        else    if(c=='s') coordenadas=state27(game);
                                else    if(c=='m') coordenadas=state28(game);
                                        else    if(c=='t') coordenadas=state29(game);
                                                else    if(c=='r') coordenadas=state30(game);

     return(coordenadas);   
    }
    
    public int[] state1(Game game, char c ){
        System.out.println("Entra en el estado 1");
        int coordenadas[] = new int[4];
        String tipo_ficha=this.asociarTipoficha(c);
        c=obtenerCaracter();
        if(esMinuscula(c)) coordenadas=state5(game, c,tipo_ficha);
        else    if(esNumero(c)) coordenadas=state12(game, c,tipo_ficha);
                else    if(c=='x') coordenadas=state2(game, tipo_ficha);
                        else return(this.errorState(1));
           return(coordenadas);
    }
    
    public int[] state2(Game game,String tipo_ficha){
        System.out.println("Entra en el estado 2");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state3(game,c,tipo_ficha);
        else    return(this.errorState(2));
        
        return(coordenadas);
    } 
    
    public int[] state3(Game game, char c, String tipo_ficha){
        System.out.println("Entra en el estado 3");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=obtenerCaracter( );
        if(esNumero(c)) coordenadas=state4(game, colDestino,c,tipo_ficha);
        else    return(this.errorState(3));
        
        return(coordenadas);
    }
    
    public int[] state4(Game game,int colDestino, char c, String tipo_ficha){
        System.out.println("Entra en el estado 4");
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin();
        if(!game.tablero.tablero[filaDestino][colDestino].getOcupada())
            return(null);
        else    if(fin) coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                else {
                    c=this.obtenerCaracter();
                    if(c=='+'){
                        System.out.println("JAQUE!");
                        coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);        
                    }else    if(c=='?'){ 
                                System.out.println("Jugada Tonta");
                                coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                             }else    if(c=='!'){ 
                                        System.out.println("Gran Jugada");
                                        coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                                      }else    if(c=='#'){ 
                                                    System.out.println("JAQUE MATE!");
                                                    coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                                                }else return(this.errorState(4));
                        
            }
        
        return(coordenadas);
        
    }
    
    public int[] state5(Game game,char c, String tipo_ficha){
        System.out.println("Entra en el estado 5");
        int[] coordenadas = new int[4];
        int columna=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state6(game, columna,c,tipo_ficha);
        else    if(esMinuscula(c)) coordenadas=state8(game, columna,c,tipo_ficha);
                else    if(c=='x') coordenadas=state7(game, columna,tipo_ficha);
                else return(this.errorState(5));
        
        return(coordenadas);
    }
    
    public int[] state6(Game game, int colDestino, char c, String tipo_ficha){
        System.out.println("Entra en el estado 6");
        int[] coordenadas=new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin();
        if(game.tablero.tablero[filaDestino][colDestino].getOcupada()) return(null);
        else{
            if(fin) coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
            else {
                    c=this.obtenerCaracter();
                    if(c=='+'){
                        System.out.println("JAQUE!");
                        coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);        
                    }else    if(c=='?'){ 
                                System.out.println("Jugada Tonta");
                                coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                             }else    if(c=='!'){ 
                                        System.out.println("Gran Jugada");
                                        coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                                      }else    if(c=='#'){ 
                                                    System.out.println("JAQUE MATE!");
                                                    coordenadas=buscarMovimiento4_6(game,tipo_ficha,filaDestino,colDestino);
                                                }else return(this.errorState(6));
                        
            }
        }
               
        return(coordenadas);
    }
    
    public int[] state7(Game game,int colOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 7");
        int[] coordenadas=new int[4];
        char c=this.obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state9(game, c,colOrigen,tipo_ficha);
        else return(this.errorState(7));
        
        return(coordenadas);
        
    }
    
    public int[] state8(Game game, int colOrigen, char c_sig, String tipo_ficha){
        System.out.println("Entra en el estado 8");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c_sig);
        char c=this.obtenerCaracter( );
               
        if(esNumero(c)) coordenadas=state11(game,   colOrigen, c, colDestino,tipo_ficha);
        else return(this.errorState(8));
        
        return(coordenadas);
    }
    
    public int[] state9(Game game,char c, int colOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 9");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state10(game, c,colOrigen, colDestino,tipo_ficha);
        else return(this.errorState(9));
        
        return(coordenadas);
    }
    
    public int[] state10(Game game,char c, int colOrigen, int colDestino, String tipo_ficha){
        System.out.println("Entra en el estado 10");
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin( );
        if(fin&&game.tablero.tablero[filaDestino][colDestino].getOcupada()) 
            coordenadas=buscarMovimiento10_11(game,colOrigen,filaDestino,colDestino, tipo_ficha);
        else {
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(10));
                        
            }
        
        return(coordenadas);
    }
    
    public int[] state11(Game game,int colOrigen, char c, int colDestino, String tipo_ficha){
        System.out.println("Entra en el estado 11");
        int[] coordenadas = new int[4];
        int filaDestino = this.convertirFila(c);
        boolean fin=comprobarfin( );
        
        if(fin) coordenadas=buscarMovimiento10_11(game,colOrigen,filaDestino,colDestino,tipo_ficha);
        else{
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(11));
                        
            }
        
        return(coordenadas);
    }
    
    public int[] state12(Game game,char c, String tipo_ficha){
        System.out.println("Entra en el estado 12");
        int[] coordenadas = new int[4];
        int filaOrigen=this.convertirFila(c);
        c=obtenerCaracter( );
        if(c=='x') coordenadas=state13(game,   filaOrigen, tipo_ficha);
        else    if(esMinuscula(c)) coordenadas=state14(game,   c, filaOrigen, tipo_ficha);
                else    return(this.errorState(12));
        
        return(coordenadas);
        
    }
    
    public int[] state13(Game game,int filaOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 13");
        int[] coordenadas=new int[4];
        
        char c=this.obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state15(game,   filaOrigen, c, tipo_ficha);
        else    return(this.errorState(13));
        
        return(coordenadas);
    }
    
    public int[] state14(Game game,char c, int filaOrigen, String tipo_ficha){
        System.out.println("Entra en el estado 14");
        int[] coordenadas=new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state16(game,   c, filaOrigen, colDestino, tipo_ficha);
        else return(this.errorState(14));
               
        return(coordenadas);
    }
    
    public int[] state15(Game game,int filaOrigen, char c, String tipo_ficha){
        System.out.println("Entra en el estado 15");
        int[] coordenadas=new int[4];
        int colDestino=this.convertirColumna(c);
        c=this.obtenerCaracter( );
        if(esNumero(c)) coordenadas=state17(game,   filaOrigen, c, colDestino, tipo_ficha);
        else    return(this.errorState(15));
        
        return(coordenadas);
    }
    
    public int[] state16(Game game,char c, int filaOrigen, int colDestino, String tipo_ficha){
        System.out.println("Entra en el estado 16");
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=comprobarfin( );
        
        if(fin) coordenadas=buscarMovimiento16(game, filaOrigen, filaDestino, colDestino, tipo_ficha);
        else {
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(16));
                        
            }
        
        return(coordenadas);
    }
    
    public int[] state17(Game game,int filaOrigen, char c, int colDestino, String tipo_ficha){
        System.out.println("Entra en el estado 17");
        int[] coordenadas = new int[4];
        int filaDestino = this.convertirFila(c);
        boolean fin=comprobarfin( );
        if(!game.tablero.tablero[filaDestino][colDestino].getOcupada()) return(null);
        else{
                if(fin) coordenadas = buscarMovimiento17(game, filaOrigen, filaDestino, colDestino, tipo_ficha);
                else {
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(17));
                        
            }
        }
        return(coordenadas);
    }
    
    public int[] state18(Game game ){
        System.out.println("Entra en el estado 18");
        int[] coordenadas=new int[4];
        char c=obtenerCaracter();
        if(c=='-') coordenadas=state19(game );
        else return(this.errorState(18));
        
        return(coordenadas);
    }
    
    public int[] state19(Game game ){
        System.out.println("Entra en el estado 19");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(c=='O') coordenadas= state20(game);
        else return(this.errorState(19));
        
        return(coordenadas);
    }
    
    public int[] state20(Game game ){
        System.out.println("Entra en el estado 20");
        int[] coordenadas = new int[4];
        if(comprobarfin()) coordenadas=enroqueCorto(game);
        else {
            char c=obtenerCaracter();
            if(c=='-') coordenadas=state21(game);
            else return(this.errorState(20));
        }
        
        
        return(coordenadas);
    }
    
    public int[] state21(Game game ){
        System.out.println("Entra en el estado 21");
        int[] coordenadas = new int[4];
        char c= obtenerCaracter();
        boolean fin = this.comprobarfin();
        if(fin){
            if(c=='O') coordenadas=enroqueLargo(game);
            else return(this.errorState(21));
        }else {
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(21));
                        
            }
        
        return(coordenadas);
    }
    
    public int[] state22(Game game, char c ){
        System.out.println("Entra en el estado 22");
        int[] coordenadas = new int[4];
        int columna=this.convertirColumna(c);
        c=obtenerCaracter();
        if(esNumero(c)) coordenadas=state23(game,columna,c );
        else    if(c=='x') coordenadas=state24(game,columna );
                else    if(c=='u'){
                            if(obtenerCaracter()=='a'){
                                if(obtenerCaracter()=='r'){
                                    if(obtenerCaracter()=='d'){
                                        if(obtenerCaracter()=='a'){
                                            if(obtenerCaracter()=='r'){
                                                coordenadas[0]=9;
                                                coordenadas[1]=9;
                                                coordenadas[2]=9;
                                                coordenadas[3]=4;
                                            }else return(this.errorState(22));
                                        }else return(this.errorState(22));
                                    }else return(this.errorState(22));
                                }else return(this.errorState(22));
                            }else return(this.errorState(22));
                        }else   if(c=='a'){
                                    if(obtenerCaracter()=='r'){
                                        if(obtenerCaracter()=='g'){
                                            if(obtenerCaracter()=='a'){
                                                if(obtenerCaracter()=='r'){
                                                    coordenadas[0]=9;
                                                    coordenadas[1]=9;
                                                    coordenadas[2]=9;
                                                    coordenadas[3]=3;
                                        }else return(this.errorState(22));
                                    }else return(this.errorState(22));
                                }else return(this.errorState(22));
                            }
                         }else  if(c=='y'){
                                    if(obtenerCaracter()=='u'){
                                        if(obtenerCaracter()=='d'){
                                            if(obtenerCaracter()=='a'){
                                                coordenadas[0]=9;
                                                coordenadas[1]=9;
                                                coordenadas[2]=9;
                                                coordenadas[3]=2;
                                            }
                                        }else return(this.errorState(22));
                                    }else return(this.errorState(22));
                                }else return(this.errorState(22));
            
                        
        
        return(coordenadas);
    }
    
    public int[] state23(Game game, int colDestino,char c ){
        System.out.println("Entra en el estado 23");
        int colOrigen=colDestino;
        int[] ficha=new int[2];
        int[] coordenadas = new int[4];
        int filaDestino=this.convertirFila(c);
        boolean fin=this.comprobarfin( );
        try{
        
        if(!fin){
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(23));
                        
        }else{
            if(game.getTurno()){
                if(game.tablero.tablero[filaDestino-1][colOrigen].getOcupada()&&
                        game.tablero.tablero[filaDestino-1][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        game.tablero.tablero[filaDestino-1][colOrigen].getFicha().getColor()==game.getTurno()){
                coordenadas[0]=filaDestino-1;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else   if(game.tablero.tablero[filaDestino-2][colOrigen].getOcupada()&&
                        game.tablero.tablero[filaDestino-2][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        game.tablero.tablero[filaDestino-2][colOrigen].getFicha().getColor()==game.getTurno()){
                coordenadas[0]=filaDestino-2;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else return(this.errorState(23));
           }else if(game.tablero.tablero[filaDestino+1][colOrigen].getOcupada()&&
                        game.tablero.tablero[filaDestino+1][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        game.tablero.tablero[filaDestino+1][colOrigen].getFicha().getColor()==game.getTurno()){
                coordenadas[0]=filaDestino+1;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else   if(game.tablero.tablero[filaDestino+2][colOrigen].getOcupada()&&
                        game.tablero.tablero[filaDestino+2][colOrigen].getFicha().getTipo_ficha().equals("peon")&&
                        game.tablero.tablero[filaDestino+2][colOrigen].getFicha().getColor()==game.getTurno()){
                coordenadas[0]=filaDestino+2;
                coordenadas[1]=colOrigen;
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                }else return(this.errorState(23));
            }
         }catch(Exception e){
             return this.errorState(23);
         }
        return(coordenadas);
        
    }
    
    public int[] state24(Game game, int columna ){
        System.out.println("Entra en el estado 24");
        int[] coordenadas = new int[4];
        char c=obtenerCaracter( );
        if(esMinuscula(c)) coordenadas=state25(game, columna, c);
        else return(this.errorState(24));
        
        return(coordenadas);
    }
    
    public int[] state25(Game game, int colOrigen, char c ){
        System.out.println("Entra en el estado 25");
        int[] coordenadas = new int[4];
        int colDestino=this.convertirColumna(c);
        c=obtenerCaracter( );
        if(esNumero(c)) coordenadas=state26(game,c,colOrigen,colDestino );
        else return(this.errorState(25));
        
        return(coordenadas);
    }
    
    public int[] state26(Game game, char c, int colOrigen, int colDestino ){
        System.out.println("Entra en el estado 26 (Comiendo con un peon)");
        int[] coordenadas = new int[4];
        boolean fin=this.comprobarfin();
        int filaDestino=this.convertirFila(c);
        if(fin){
                if(game.tablero.tablero[filaDestino][colDestino].getOcupada()){
                    if(game.getTurno()){
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
                }else return(this.errorState(26));
    }else {
                    c=this.obtenerCaracter();
                    if(c=='+') System.out.println("JAQUE!");
                    else    if(c=='?') System.out.println("Jugada Tonta");
                            else    if(c=='!') System.out.println("Gran Jugada");
                                    else    if(c=='#') System.out.println("JAQUE MATE!");
                                    else return(this.errorState(26));
                        
            }
        return(coordenadas);
    }
    
    public int[] state27(Game game){
        char c=obtenerCaracter();
        int[] coor= new int[4];
        if(c=='a'){
            if(obtenerCaracter()=='l'){
                if(obtenerCaracter()=='i'){
                    if(obtenerCaracter()=='r'){
                        coor[0]=9;
                        coor[1]=9;
                        coor[2]=9;
                        coor[3]=9;
                    }else return(this.errorState(27));
                }else return(this.errorState(27));
            }else return(this.errorState(27));
        }else return(this.errorState(27)); 
        return(coor);
    }
    
    public int[] state28(Game game){
        char c=obtenerCaracter();
        int[] coor= new int[4];
        if(c=='e'){
            if(obtenerCaracter()=='n'){
                if(obtenerCaracter()=='u'){
                    coor[0]=9;
                    coor[1]=9;
                    coor[2]=9;
                    coor[3]=8;
                }else return(this.errorState(28));
            }else return(this.errorState(28));
         }else return(this.errorState(28));
        return(coor);
    }
    
    public int[] state29(Game game){
        System.out.println("Entra en state 29");
        int[] coor = new int[4];
        char c=obtenerCaracter();
        if(c=='a'){
            if(obtenerCaracter()=='b'){
                if(obtenerCaracter()=='l'){
                    if(obtenerCaracter()=='a'){
                        if(obtenerCaracter()=='s'){
                            coor[0]=9;
                            coor[1]=9;
                            coor[2]=9;
                            coor[3]=7;
                        }
                    }else return(this.errorState(29));
                }else return(this.errorState(29));
            }else return(this.errorState(29));
        }else return(this.errorState(29));
        return(coor);
    }
    
    public int[] state30(Game game){
        int[] coor = new int[4];
        char c= obtenerCaracter();
        if(c=='e'){
            if(obtenerCaracter()=='n'){
                if(obtenerCaracter()=='d'){
                    if(obtenerCaracter()=='i'){
                        if(obtenerCaracter()=='r'){
                            if(obtenerCaracter()=='s'){
                                if(obtenerCaracter()=='e'){
                                    coor[0]=9;
                                    coor[1]=9;
                                    coor[2]=9;
                                    coor[3]=5;
                                }else return(this.errorState(30));
                            }else return(this.errorState(30));
                        }else return(this.errorState(30));
                    }else return(this.errorState(30));
                }else return(this.errorState(30));
            }else return(this.errorState(30));
        }else return(this.errorState(30));
        
        return(coor);
    }
    
    public int[] buscarMovimiento4_6(Game game, String tipo_ficha, int filaDestino, int colDestino){
        System.out.println("Entra buscarMovimiento 4,6");
        int[] coordenadas=new int[4];
        int[][] fichas=new int[2][8];
        fichas=inicializacion(fichas);
        int[][] fichas_validas=new int[2][8];
        fichas_validas=inicializacion(fichas_validas);
        int filaOrigen=0,colOrigen=0,i=0;;
        boolean bien=false;
        boolean hFicha=true;
        
        fichas=buscarFichas(game,tipo_ficha);
        
        System.out.println("Fichas encontradas de tipo."+tipo_ficha);
        for(int m=0;m<2;m++)
        {   for(int n=0;n<8;n++){
                System.out.print(fichas[m][n]);
            }
            System.out.println();
        }
        hFicha=hayFicha(fichas,0);
        for(int j=0;(j<8)&&hFicha;j++){
            filaOrigen=fichas[0][j];
            colOrigen=fichas[1][j];
            hFicha=hayFicha(fichas,i+1);
            i++;
            if(this.comprobar_movimiento(filaOrigen,colOrigen,filaDestino,colDestino,game))
                fichas_validas=aniadir(filaOrigen,colOrigen,fichas_validas);
        }
        System.out.println("Fichas añadidas:"); 
        for(int m=0;m<2;m++){
            for(int n=0;n<8;n++){
            System.out.print(fichas_validas[m][n]);
            }
            System.out.println();
        }
        
        
        coordenadas=transformar(fichas_validas,filaDestino,colDestino);
       
        return(coordenadas);
    }
    
    public boolean hayFicha(int[][] fichas, int i){
        if(fichas[0][i]==-1) return(false);
        else return(true);
    }
    
    public int[] buscarMovimiento10_11(Game game, int cO, int fD, int cD, String tipo_ficha){
        int[] coordenadas = new int[4];
        int[] ficha = new int[2];
       
        ficha=buscarFichaMismaFila(game,tipo_ficha,cO);
        if(this.comprobar_movimiento(ficha[0],ficha[1],fD,cD,game)){
        coordenadas[0]=ficha[0];
        coordenadas[1]=ficha[1];
        coordenadas[2]=fD;
        coordenadas[3]=cD;
        return(coordenadas);
        }else return(this.errorState(30));
        
    }
    
    public int[] buscarMovimiento17(Game game, int filaOrigen, int filaDestino, int colDestino, String tipo_ficha){
        int[] coordenadas = new int[4];
        int[] ficha = new int[2];
        
        ficha=buscarFichaMismaColumna(game,tipo_ficha,filaOrigen);
        if(game.tablero.tablero[filaDestino][colDestino].getOcupada()){
            if(comprobar_movimiento(ficha[0],ficha[1],filaDestino,colDestino,game)){
                coordenadas[0]=ficha[0];
                coordenadas[1]=ficha[1];
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                return(coordenadas);
            }else return(this.errorState(31));
        }else return(this.errorState(31));
        
    }
    
    public int[] buscarMovimiento16(Game game, int filaOrigen, int filaDestino, int colDestino, String tipo_ficha){
         int[] coordenadas = new int[4];
         int[] ficha = new int[2];
         
         ficha=buscarFichaMismaColumna(game,tipo_ficha,filaOrigen);
         
         if(this.comprobar_movimiento(ficha[0],ficha[1],filaDestino,colDestino,game)){
                coordenadas[0]=ficha[0];
                coordenadas[1]=ficha[1];
                coordenadas[2]=filaDestino;
                coordenadas[3]=colDestino;
                return(coordenadas);
            }else return(this.errorState(32));
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
   
    public int[] buscarFichaMismaFila(Game game, String tipo_ficha, int col){
        int[] coor=new int[2];
        boolean encontrada=false;
        System.out.println("Entra en buscar ficha misma fila.");
        for(int i=0;(i<8)&&!encontrada;i++){
            if(game.tablero.tablero[i][col].getOcupada()&&
                game.tablero.tablero[i][col].getFicha().getColor()==game.getTurno()&&
                game.tablero.tablero[i][col].getFicha().getTipo_ficha().equals(tipo_ficha)){
                    System.out.println("Ha encontrado la ficha.[Fila("+i+"),Col("+col+")].");
                    coor[0]=i;
                    coor[1]=col;
                    encontrada=true;
             }
        }
        return(coor);
        
    }
    
    public int[] buscarFichaMismaColumna(Game game, String tipo_ficha, int fila){
        int[] coor=new int[2];
        for(int j=0;j<8;j++)
            if(game.tablero.tablero[fila][j].getOcupada()&&
                game.tablero.tablero[fila][j].getFicha().getColor()==game.getTurno()&&
                game.tablero.tablero[fila][j].getFicha().getTipo_ficha().equals(tipo_ficha)){
                    coor[0]=fila;
                    coor[1]=j;
             }else return(null);
        
        return(coor);
    }
    
    public int[] buscarPeon(Game game, int colOrigen, int filaDestino, int colDestino){
        int[] coordenadas = new int[4];
        for(int i=0;i<8;i++){
            if(game.getTurno()){//TURNO NEGRAS
                if(game.tablero.tablero[i][colDestino].getOcupada()&&
                   game.tablero.tablero[i][colDestino].getFicha().getTipo_ficha().equals("peon")){
                    
                    
                    
                }
                    
            }else{ //TURNO BLANCAS
                if(game.tablero.tablero[i][colDestino].getOcupada()&&
                   game.tablero.tablero[i][colDestino].getFicha().getTipo_ficha().equals("peon")){
                    
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

    public int[][] buscarFichas(Game game, String tipo_ficha) {
        int[][] fichas=new int[2][8];
        int m=0;
        
        fichas=inicializacion(fichas);
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
            {
                if(game.tablero.tablero[i][j].getOcupada()&&
                        game.tablero.tablero[i][j].getFicha().getColor()==game.getTurno()&&
                        game.tablero.tablero[i][j].getFicha().getTipo_ficha().equals(tipo_ficha)){
                            System.out.println("I="+i+" ,J="+j);
                            fichas[0][m]=i;
                            fichas[1][m]=j;
                            m++;
                }
            }
        
        return(fichas);
    }
    
    public int[] enroqueCorto(Game game){
        int[] coordenadas = new int[4];
       
        if(game.getTurno()){//Negras
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
    
    public int[] enroqueLargo(Game game){
        int[] coordenadas = new int[4];
        boolean turno=game.getTurno();
        if(turno){//Negras
            coordenadas[0]=0;
            coordenadas[1]=4;
            coordenadas[2]=0;
            coordenadas[3]=2;
        }else{//blancas
            coordenadas[0]=7;
            coordenadas[1]=4;
            coordenadas[2]=7;
            coordenadas[3]=2;
        }
        return(coordenadas);
    }
    
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, int filadestino, int columnadestino, Game game){
       
        //comprueba que el origen y el destino estan dentro del tablero
        boolean origen_dentro=game.tablero.dentro_tablero(filaorigen,columnaorigen); 
        boolean destino_dentro=game.tablero.dentro_tablero(filadestino,columnadestino);
        System.out.println("COM MOV");
       
        //ORIGEN Y DESTINO DENTRO. Y ORIGEN OCUPADO POR FICHA DEL COLOR ADECUADO.
        if(origen_dentro&&destino_dentro){
         System.out.println("COM MOV (dentro if)");  
        //Para comprobar el movimiento necesitamos saber la ficha que se mueve
        Ficha fichaorigen=game.tablero.tablero[filaorigen][columnaorigen].getFicha();
        Ficha fichadestino;
        boolean mcf;
        
        Casilla casilladestino = game.tablero.tablero[filadestino][columnadestino];
        
                if(fichaorigen.getColor()!=game.getTurno()){
                   
                    return(false);
                }else if(!casilladestino.getOcupada()){
                                //origen del mismo color que el turno y casilla destino vacia
                                 
                                 mcf=fichaorigen.movimiento_correspondiente_ficha(game.tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                                 return(mcf);
                      }else if(casilladestino.getFicha().getColor()!=game.getTurno()){
                                //origen=turno, y destino del color diferente. Se puede comer la ficha del destino.
                                mcf=fichaorigen.movimiento_correspondiente_ficha(game.tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                                return(mcf);
                            }else if(casilladestino.getFicha().getColor()==game.getTurno()){
                                    
                                  }else return(false);
        
        }else return(false);
        
    return(false);
    }
    
    /**Esta funcion genera un int[] dependiendo del error que haya dado*/
    public int[] errorState(int tipo){
        int[] error = new int[4];
        
        return(error);
    }
}
