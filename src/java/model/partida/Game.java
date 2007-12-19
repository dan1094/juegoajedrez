/*
 * Game.java
 *
 * Created on 28 de noviembre de 2007, 21:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import controller.Fide;
import controller.IObserver;
import controller.ISubject;
import controller.TableroFactory;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import model.prolog.Partida_Prolog;
import view.MostrarTablero;
import view.MostrarTableroBlanco;
import view.MostrarTableroNegro;

/**
 *
 * @author Pablo
 */
public class Game implements ISubject, KeyListener{
    
    protected int id_partida;
    protected boolean turno;
    public Tablero tablero;
    protected boolean blanco_puede_enrocar;
    protected boolean negro_puede_enrocar;
    private ArrayList misObservers;
    private MostrarTablero mostrarTableroNegro = new MostrarTableroNegro();
    
    
    /**Instancia vacia de Partida*/
    public Game(){
        id_partida = 0;
        turno = false;
        blanco_puede_enrocar = true;
        negro_puede_enrocar = true;
        //tablero.inicializar_tablero_estandar(this);
        misObservers = new ArrayList();
        
    }
    
    /** Creates a new instance of Partida */
    public Game(int id_partida, boolean turno, Tablero tablero, boolean blanco_puede_enrocar, boolean negro_puede_enrocar) {
        this.id_partida=id_partida;
        this.tablero=tablero;
        this.turno=turno;
        this.blanco_puede_enrocar=blanco_puede_enrocar;
        this.negro_puede_enrocar=negro_puede_enrocar;
        misObservers = new ArrayList();
    }
    
    public Game(Game otra)
    {
        id_partida=otra.id_partida;
        turno=otra.turno;
        tablero=otra.tablero;
        blanco_puede_enrocar=otra.blanco_puede_enrocar;
        negro_puede_enrocar=otra.negro_puede_enrocar;
        misObservers=otra.misObservers;
        mostrarTableroNegro=otra.mostrarTableroNegro;
        
    }
    
    
    public void addObserver(IObserver obs) {
        System.out.println("Añadiendo Observer");
        // LogManager.info("Añadiendo Observer");
        misObservers.add(obs);
        System.out.println("Observer añadido");
        //   LogManager.info("Observer añadido");
    }
    
    public void removeObserver(IObserver obs) {
        System.out.println("Eliminando Observer");
        //LogManager.info("Eliminando Observer");
        misObservers.remove(misObservers.size()-1);
        System.out.println("Observer eliminado");
        //LogManager.info("Observer eliminado");
    }
    
    public void notifyObserver(){
        
        for( int i = 0; i < misObservers.size(); i++ ) {
            IObserver obs = ( IObserver )misObservers.get(i);
            obs.update(this);
            //LogManager.info("********************OBSERVER ENTERADO************************");
            
        }
        
        
    }
    
    //GETTERS Y SETTERS
    public void setId_partida(int id_partida){
        this.id_partida=id_partida;
    }
    
    public int getId_partida(){
        return(this.id_partida);
    }
    
    public void setTurno(boolean turno){
        this.turno=turno;
    }
    
    public boolean getTurno(){
        return(this.turno);
    }
    
    public void setTablero(Tablero tablero){
        this.tablero=tablero;
    }
    
    public Tablero getTablero(){
        return(this.tablero);
    }
    
    public void setBlanco_puede_enrocar(boolean b_p_e){
        this.blanco_puede_enrocar=b_p_e;
    }
    
    public boolean getBlanco_puede_enrocar(){
        return(this.blanco_puede_enrocar);
    }
    
    public void setNegro_puede_enrocar(boolean n_p_e){
        this.negro_puede_enrocar=n_p_e;
    }
    
    public boolean getNegro_puede_enrocar(){
        return(this.negro_puede_enrocar);
    }
    
    /**Metodo que cambia el turno de la partida*/
    public void cambio_turno(){
        //Si el turno es False(BLANCAS) pasa a true(NEGRAS) y viceversa
        if(this.getTurno())
            this.setTurno(false);
        else this.setTurno(true);
    }
    
    /**Comienza la partida, mostrando la "introduccion"*/
    public void comenzarPartida(Game game) throws NoSolutionException, MalformedGoalException{
        int coordenadas[] = new int[4];
        int opt;
        String coorString="";
        MostrarTableroNegro mostrarTableroNegro = new MostrarTableroNegro();
        Fide fide= new Fide();
        //mostrarTableroNegro.update(game);
        
        Partida_Prolog p= new Partida_Prolog();
        Prolog engine= new Prolog();
        //AQUI CREAMOS EL TABLERO T0, con todas las fichas.
        engine = p.inicializar_Prolog();
        
        int prueba=-1;
        boolean comiendo=false;
        
        this.aniadirVista();
        game.tablero=game.tablero.amenazas(game.tablero);
        
        System.out.println("COMIENZO DE LA PARTIDA");
        System.out.print("El turno es de las: ");
        if(game.getTurno()) System.out.println("NEGRAS");
        else System.out.println("BLANCAS");
        
        do{
            //Si el turno es de las negras, mueve solo (opt=0), si es de las blancas,
            //le pedimos las coordenadas al jugador.
            System.out.println("TURNO="+game.getTurno());
            if(game.getTurno()) {
                System.out.println("DENTRO DEL IF DEL TURNO");
                opt=0;
            }else{
                System.out.println("DENTRO DEL ELSE DEL TURNO.");
            mostrarTableroNegro.update(game);
            //  mostrarAmenazadasBlancas(game);
            //  mostrarAmenazadasNegras(game);
            coorString=this.pedir_coordenadas_movimiento();
            //En comiendo guardamos si el movimiento es comiendo, para pasarselo a prolog.
            comiendo=coorString.contains("x");
            coordenadas=fide.de_fide_a_modelo(this,coorString);
            //coordenadas = fide.de_fide_a_modelo(this,pedir_coordenadas_movimiento());
            opt=this.lectura(coordenadas);
            //prueba=p.calcular_movimento(engine,3,4,5,this.turno);
            }
            System.out.println("OPCION="+opt);
            switch(opt){
                case 0: //MUEVE EL ORDENADOR. Llamamos a Alfa_Beta, con los parametros
                        //adecuados. ALFA=0, BETA=0. Turno de las negras.
                    p.Alfa_Beta(engine,0,0,0,true,this);
                    break;
                case 1: //SALIR
                    break;
                case 2: //MENU
                    break;
                case 3: //HA OFRECIDO TABLAS
                    if(this.ofrecimientoTablas(game)){
                        System.out.println("Partida terminada en tablas.");
                        opt=1;//SALIR
                    } else {
                        System.out.println("Tu adversario no ha aceptado las tablas.");
                        break;
                    }
                case 4: //FIN PARTIDA
                    break;
                case 5: //RENDICION
                    this.rendicion(game);
                    opt=1;
                    break;
                case 6: //GUARDAR
                    this.guardar(game);
                    break;
                case 7: //CARGAR
                    game=this.cargar();
                    break;
                case 8: //AYUDA
                    this.ayuda(game);
                    break;
                default: //EL RESTO
                    this.opcionMover(coordenadas,engine,p,comiendo);
                    break;
            }
            
            
        }while(opt!=1); //Mientras no sea 1, significa que no ha terminado la partida
        
        System.out.println("LA PARTIDA HA FINALIZADO.");
        
    }
    /**Ofrece al usuario añadir una vista. Por ahora solo la ofrece al comenzar la partida*/
    public void aniadirVista() {
        int n_partida = 0;
        MostrarTablero mostrarTableroBlanco = new MostrarTableroBlanco();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Que desea hacer?");
            System.out.println("1.- Añadir una vista");
            System.out.println("2.- No Realizar ninguna accion");
            //System.out.println("3.- Suprimir una vista");
            
            try{
                n_partida = Integer.parseInt(in.readLine());
                if(n_partida==1) {
                    this.addObserver(mostrarTableroBlanco);
                    mostrarTableroBlanco.update(this);
                }
                
            }catch(NumberFormatException ex){
                
                System.out.println("Caracter invalido");
                //    LogManager.info("Caracter invalido");
                
            }catch(IOException ex){
                
                System.out.println("Caracter invalido");
                //    LogManager.info("Caracter invalido");
            }
            
            
        }while((n_partida!=1)&&(n_partida!=2));
        
        
    }
    
    /**Recibe el array con las coordenadas y comprueba los codigos.
     * 9999 -> opt=1 -> SALIR
     * 9998 -> opt=2 -> MENU
     * 9997 -> opt=3 -> OFRECERTABLAS
     * 9996 -> opt=4 ->
     * 9995 -> opt=5 -> RENDIRSE
     * 9994 -> opt=6 -> GUARDAR
     * 9993 -> opt=7 -> CARGAR
     * 9992 -> opt=8 -> AYUDA
     */
    public int lectura(int[] coordenadas) {
        
        if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==9))
            return(1);//SALIR
        
        else    if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==8))
            return(2);//MENU
        
        else    if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==7))
            return(3);//OFRECER TABLAS
        
        else     if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==6))
            return(4);//FIN PARTIDA
        else    if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==5))
            return(5);//RENDIRSE
        else    if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==4))
            return(6);//GUARDAR
        else    if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[3]==3))
            return(7);//CARGAR
        else    if((coordenadas[0]==9)&&(coordenadas[1]==9)&&
                (coordenadas[2]==9)&&(coordenadas[2]==3))
            return(8);//AYUDA
        
        return(-1);
    }
    
    /**Pide las coordenadas al usuario*/
    public String pedir_coordenadas_movimiento() {
        
        String coordenadas="";
        System.out.println("Introduzca las coordenadas del movimiento (formato FIDE):");
        System.out.println("=========================================================");
        System.out.println("Para salir, introduzca 'salir'.");
        System.out.println("Para volver al menu inicial, introduzca 'menu'.");
        System.out.println("Para ofrecer tablas,introduzca 'tablas'.");
        System.out.println("Para rendirse 'rendirse'.");
        System.out.println("Para guardar partida 'guardar'.");
        System.out.println("Para cargar partida 'cargar");
        System.out.println("Para mostrar movimientos posibles 'ayuda'.");
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coordenadas=in.readLine();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
    }
    
    /**Llamada al metodo tras introducir por teclado, uno de los jugadores
     * "tablas". Este metodo, le comunica y ofrece tablas al adversario*/
    private boolean ofrecimientoTablas(Game game) {
        int tablas=0;
        System.out.println("Tu adversario te ha ofrecido tablas.");
        System.out.println("¿Aceptas las tablas? [0-> NO, 1-> SI]");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            
            tablas = Integer.parseInt(in.readLine());
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if(tablas==0) return(false);
        else if(tablas==1) return(true);
        
        return(false);
        
    }
    
    /**Ofrece al usuario el cambio de ficha al coronar un peon*/
    public int ofrecer_cambio_ficha(){
        int eleccion=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Ha coronado un peon. ¿Que ficha desea obtener?");
            System.out.println("1.- Reina");
            System.out.println("2.- Torre");
            System.out.println("3.- Alfil");
            System.out.println("4.- Caballo");
            //Leemos el numero
            eleccion = Integer.parseInt(in.readLine());
            
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la ficha.");
//            LogManager.info("Entrada incorrecta de la ficha.");
        } return(eleccion);
    }
    
    /**Ofrece al usuario fichas para jugar una partida personalizada*/
    public int ofrecer_ficha(){
        
        int opcion=0;
        System.out.println("¿Que ficha desea introducir? (0 para ninguna mas)");
        try {
            
            do{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("1.- REY");
                System.out.println("2.- REINA");
                System.out.println("3.- TORRE");
                System.out.println("4.- CABALLO");
                System.out.println("5.- ALFIL");
                System.out.println("6.- PEON");
                opcion = Integer.parseInt(in.readLine());
            }while((opcion<0)||(opcion>6));
            
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return(opcion);
    }
    
    /**Pide el color al usuario dela ficha introducida*/
    public boolean pedir_color(){
        int columna=0, color=0;
        System.out.println("¿Que color?");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("(0-Blanco, 1-Negro)");
            color = Integer.parseInt(in.readLine());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }if(color==0) return(false);
        else return(true);
    }
    
    /**Pide las coordenadas de la nueva ficha*/
    public String pedir_coordenadas_ficha(){
        
        String coordenadas="";
        System.out.println("Introduzca las coordenadas (FIDE):");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coordenadas=in.readLine();
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
    }
    
    /**Comprueba si el movimiento realizado es un enroque*/
    public boolean esEnroque(int fo, int co, int fd, int cd, Game game){
        if(game.tablero.tablero[fo][co].getOcupada()&&
                game.tablero.tablero[fo][co].getFicha().equals("rey")&&
                (fo==0)&&(co==4)&&(fd==0)&&(cd==6)){
            return(true);
            
        }else  if(game.tablero.tablero[fo][co].getOcupada()&&
                game.tablero.tablero[fo][co].getFicha().equals("rey")&&
                (fo==7)&&(co==4)&&(fd==7)&&(cd==6)){
            return(true);
        }else   if(game.tablero.tablero[fo][co].getOcupada()&&
                game.tablero.tablero[fo][co].getFicha().equals("rey")&&
                (fo==0)&&(co==4)&&(fd==0)&&(cd==2)){
            return(true);
        }else   if(game.tablero.tablero[fo][co].getOcupada()&&
                game.tablero.tablero[fo][co].getFicha().equals("rey")&&
                (fo==7)&&(co==4)&&(fd==7)&&(cd==2)){
            return(true);
        }else return(false);
    }
    
    /**Esta funcion realiza el enroque, se hace aparte porque el enroque implica
     * dos movimientos, torre y rey*/
    public Tablero enrocar(Game game, int fila, int colDestino, boolean turno){
        Tablero tablero = new Tablero();
        tablero=game.getTablero();
        if(colDestino==2){//ENROQUE LARGO
            if(turno){ //NEGRAS
                tablero.tablero[0][2].setFicha(tablero.tablero[0][4].getFicha());
                tablero.tablero[0][4].setFicha(null);
                tablero.tablero[0][3].setFicha(tablero.tablero[0][0].getFicha());
                tablero.tablero[0][0].setFicha(null);
            }else{     //BLANCAS
                tablero.tablero[7][2].setFicha(tablero.tablero[7][4].getFicha());
                tablero.tablero[7][4].setFicha(null);
                tablero.tablero[7][3].setFicha(tablero.tablero[7][0].getFicha());
                tablero.tablero[7][0].setFicha(null);
            }
        }else if(colDestino==6){ //ENROQUE CORTO
            if(turno){ //NEGRAS
                tablero.tablero[0][6].setFicha(tablero.tablero[0][4].getFicha());
                tablero.tablero[0][4].setFicha(null);
                tablero.tablero[0][5].setFicha(tablero.tablero[0][7].getFicha());
                tablero.tablero[0][7].setFicha(null);
            }else{     //BLANCAS
                tablero.tablero[7][6].setFicha(tablero.tablero[7][4].getFicha());
                tablero.tablero[7][4].setFicha(null);
                tablero.tablero[7][5].setFicha(tablero.tablero[7][7].getFicha());
                tablero.tablero[7][7].setFicha(null);
            }
        }
        
        return(tablero);
        
    }
    
    /**Comprueba si una casilla esta ocupada por una ficha del color
     * del turno de la partida*/
    public boolean ocupada_color(Tablero tablero, int fo, int co){
        Ficha ficha;
        if(this.tablero.tablero[fo][co].getOcupada()) ficha=this.tablero.tablero[fo][co].getFicha();
        else return(false);
        if(ficha.getColor()==this.getTurno()) return(true);
        else return(false);
    }
    
    /**Este metodo, mueve las fichas, para ello, comprueba si el movimiento esta
     * permitido.*/
    public boolean mover(int filaorigen, int columnaorigen, int filadestino, int columnadestino, Tablero tablero){
        System.out.println("Entra en mover.");
//        LogManager.info("Entra en mover.");
        
        
        boolean mov_per=comprobar_movimiento(filaorigen,columnaorigen,filadestino,columnadestino,tablero);
        
        
        if(mov_per){
            //Obtenemos las casillas
            Casilla origen=tablero.getCasilla(filaorigen,columnaorigen);
            Casilla destino=tablero.getCasilla(filadestino,columnadestino);
            //Ponemos en el destino la ficha del origen
            destino.setFicha(origen.getFicha());
            //Vaciamos la casilla origen y directamente, al colocar la ficha
            //en el destino, se pone ocupada a TRUE el destino.
            origen.setFicha(null);
            this.cambio_turno();
            System.out.println("Ficha movida.");
//                LogManager.info("Ficha movida.");
            
            this.setTablero(this.tablero.amenazas(this.tablero));
            if(turno){
                System.out.println("ES EL TURNO DE LAS NEGRAS");
//                    LogManager.info("ES EL TURNO DE LAS NEGRAS");
            } else{
                System.out.println("ES EL TURNO DE LAS BLANCAS");
//                    LogManager.info("ES EL TURNO DE LAS BLANCAS");
            }
            
            return(true);
            
        }else{
            System.out.println("No puede realizarse el movimiento solicitado.");
//            LogManager.info("No puede realizarse el movimiento solicitado.");
            return(false);
        }
        
    }
    
    /**Comprueba el movimiento que ha introducido el usuario, y devuelve si se puede
     * al metodo que lo invoca, que es MOVER*/
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen,int filadestino, int columnadestino, Tablero tablero){
        try{
            System.out.println("Comprobando el movimiento.");
            //   LogManager.info("Comprobando el movimiento.");
            
            //comprueba que el origen y el destino estan dentro del tablero
            boolean origen_dentro=this.tablero.dentro_tablero(filaorigen,columnaorigen);
            boolean destino_dentro=this.tablero.dentro_tablero(filadestino,columnadestino);
            
            
            
            //ORIGEN Y DESTINO DENTRO. Y ORIGEN OCUPADO POR FICHA DEL COLOR ADECUADO.
            if(origen_dentro&&destino_dentro){
                
                System.out.println("Origen y Destino dentro del tablero.");
                //   LogManager.info("Origen y Destino dentro del tablero.");
                
                //   Para comprobar el movimiento necesitamos saber la ficha que se mueve
                Ficha fichaorigen=this.tablero.tablero[filaorigen][columnaorigen].getFicha();
                Ficha fichadestino;
                boolean mcf, coro;
                
                Casilla casilladestino = this.tablero.tablero[filadestino][columnadestino];
                
                if(fichaorigen.getColor()!=turno){
                    System.out.println("La ficha que se quiere mover no es del color del turno de la partida.");
                    //    LogManager.info("La ficha que se quiere mover no es del color del turno de la partida.");
                    return(false);
                }else if(!casilladestino.getOcupada()){
                    //origen del mismo color que el turno y casilla destino vacia
                    System.out.println("Va a mover un/una: "+fichaorigen.getTipo_ficha()+". La casilla" +
                            " destino esta vacia.");
                    //              LogManager.info("Va a mover un/una: "+fichaorigen.getTipo_ficha()+". La casilla" +
//                                         " destino esta vacia.");
                    mcf=fichaorigen.movimiento_correspondiente_ficha(tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                    if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf)){
                        Tablero tablero2 = new Tablero();
                        tablero2=this.ofrecer_cambio(this,filaorigen,columnaorigen,filadestino,columnadestino);
                        this.setTablero(tablero2);
                        
                    }
                    if(fichaorigen.getTipo_ficha().equals("rey")){
                        if(esEnroque(filaorigen,columnaorigen,filadestino,columnadestino,this)){
                            this.setTablero(this.enrocar(this,filaorigen,columnadestino,this.getTurno()));
                        }
                        if(this.getTurno()) this.setNegro_puede_enrocar(false);
                        else this.setBlanco_puede_enrocar(false);
                    }
                    
                    return(mcf);
                }else if(casilladestino.getFicha().getColor()!=this.getTurno()){
                    //origen=turno, y destino del color diferente. Se puede comer la ficha del destino.
                    fichadestino=casilladestino.getFicha();
                    mcf=fichaorigen.movimiento_correspondiente_ficha(tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                    System.out.println("El/La "+fichaorigen.tipo_ficha+" a mover es de su color. Y la casilla" +
                            " destino esta ocupada por un/una "+fichadestino.getTipo_ficha()+" del contrario.");
//                                LogManager.info("El/La "+fichaorigen.tipo_ficha+" a mover es de su color. Y la casilla" +
//                                        " destino esta ocupada por un/una "+fichadestino.getTipo_ficha()+" del contrario.");
                    if(mcf){
                        System.out.println("Ha comido un "+casilladestino.ficha.tipo_ficha+" contrario.");
//                                    LogManager.info("Ha comido un "+casilladestino.ficha.tipo_ficha+" contrario.");
                    }
                    if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf)){
                        Tablero tablero2 = new Tablero();
                        tablero2=this.ofrecer_cambio(this,filaorigen,columnaorigen,filadestino,columnadestino);
                        this.setTablero(tablero2);
                        
                    }return(mcf);
                }else if(casilladestino.getFicha().getColor()==this.getTurno()){
                    System.out.println("El destino esta ocupado por una ficha de su propio color.");
//                                        LogManager.info("El destino esta ocupado por una ficha de su propio color.");
                }else return(false);
                
            }else {
                //Origen no valido o destino no valido o origen vacio
                if(!origen_dentro){
                    System.out.println("El origen no es valido. No pertenece al tablero.");
//                    LogManager.info("El origen no es valido. No pertenece al tablero.");
                }
                if(!destino_dentro){
                    System.out.println("El destino no es valido. No pertenece al tablero.");
//                    LogManager.info("El destino no es valido. No pertenece al tablero.");
                }
                
                return(false);//No se da la condicion del if. No estan dentro del tablero
            }
        }catch(Exception e){
            return(false);
        }
        return(false);
    }
    
    /**Comprueba si el movimiento es una CORONACION y ofrece el cambio*/
    public Tablero ofrecer_cambio(Game game, int fo, int co, int fd, int cd){
        System.out.println("FO="+fo+" CO="+co+" FD="+fd+" CD="+cd+" TURNO="+game.getTurno());
        Tablero tablero = new Tablero();
        tablero=game.getTablero();
        if((fd==0)&&(fo==1)){
            //FD=ultima fila. FO=penultima. turno=color ficha a mover
            //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
            // ofrece el cambio y llama a cambio_ficha.
            System.out.println("Coronacion de blancas");
            int eleccion = this.ofrecer_cambio_ficha();
            System.out.println("ELECCION: "+eleccion);
            tablero=this.cambio_ficha(game,eleccion,fo,co,fd,cd);
            
            
        }else if((fd==7)&&(fo==6)){
            //FD=ultima fila. FO=penultima. turno=color ficha a mover
            //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
            // ofrece el cambio y llama a cambio_ficha.
            System.out.println("Coronacion de negras");
            System.out.println("FO="+fo+" CO="+co+" FD="+fd+" CD="+cd);
            
            int eleccion = this.ofrecer_cambio_ficha();
            System.out.println("ELECCION: "+eleccion);
            tablero=this.cambio_ficha(game,eleccion,fo,co,fd,cd);
            
        }else return(tablero);
        
        return(tablero);
    }
    
    /**Recibe la eleccion del cambio y realiza el cambio de ficha*/
    public Tablero cambio_ficha(Game game, int eleccion, int fo, int co, int fd, int cd){
        Tablero tablero = new Tablero();
        tablero=game.getTablero();
        //Esta funcion dependiendo de la ficha que el jugador haya escogido
        //crea la ficha y la mete en su sitio.
        System.out.println("Cambio de ficha. ("+fd+","+cd+").");
        //  LogManager.info("Cambio de ficha. ("+fd+","+cd+").");
        System.out.println("Ha solicitado cambiar el peon por un "+eleccion);
        //  LogManager.info("Ha solicitado cambiar el peon por un "+eleccion);
        
        switch(eleccion){
            
            case 1:   tablero.tablero[fo][co].setFicha(new Dama(this.getTurno()));
            //tablero.tablero[fo][co].setFicha(null);
            System.out.println("Dama:"+eleccion);
            return(tablero);
            case 2:   tablero.tablero[fo][co].setFicha(new Torre(this.getTurno()));
            //tablero.tablero[fo][co].setFicha(null);
            return(tablero);
            case 3:   tablero.tablero[fo][co].setFicha(new Alfil(this.getTurno()));
            //tablero.tablero[fo][co].setFicha(null);
            return(tablero);
            case 4:   tablero.tablero[fo][co].setFicha(new Caballo(this.getTurno()));
            //tablero.tablero[fo][co].setFicha(null);
            return(tablero);
            default: return(tablero);
        }
    }
    
    /**Pide al usuario el turno de la partida personalizada*/
    public boolean obtener_turno_personalizado(Game game){
        boolean turno=false;
        int turn=2; //Igual a cero, para asegurarnos de que entra a leer.
        System.out.println("¿Con que turno desea que comience la partida personalizada?");
        do{
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                turn=in.read();
                
                if(turn==0) turno=false;
                else turno=true;
                
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }while((turn<0)&&(turn>1));
        
        return(turno);
    }
    
    /**Ofrece la personalizacion del tablero de la partida*/
    public int pedirtablero_personalizado(){
        int tipo_partida=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Introduzca el tipo de partida que desea empezar");
            System.out.println("0 .- Partida Estandar");
            System.out.println("1 .- Partida Personalizada");
            System.out.println("2 .- Leer partida desde un archivo");
            System.out.println("3 .- Cargar una partida guardada");
            try{
                tipo_partida = Integer.parseInt(in.readLine());
            }catch(NumberFormatException ex){
                System.out.println("Caracter invalido");
//                LogManager.info("Caracter invalido");
            }catch(IOException ex){
                System.out.println("Caracter invalido");
//                LogManager.info("Caracter invalido");
            }
        }while((tipo_partida!=0)&&(tipo_partida!=1)&&(tipo_partida!=2)&&(tipo_partida!=3));
        return(tipo_partida);
    }
    
    /**Ofrece al jugador los escenarios particulares que hay*/
    public Tablero escenariosParticulares(){
        int opcion=0;
        Tablero tablero = new Tablero();
        System.out.println("¿Que Escenario desea?");
        
        try{
            do{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("1.- Enroque");
                System.out.println("2.- Coronar");
                System.out.println("3.- Comer con 2 posibles peones");
                System.out.println("4.- Comer con 2 posibles caballos");
                opcion = Integer.parseInt(in.readLine());
            }while((opcion<1)||(opcion>4));
            
            TableroFactory tabFac = new TableroFactory();
            
            switch (opcion){
                case 1: tablero = tabFac.situacionEnroque();
                break;
                case 2: tablero = tabFac.situacionCoronar();
                break;
                case 3: tablero = tabFac.situacionComerDobleOpcion();
                break;
                default: tablero = tabFac.situacionComerDobleCaballo();
                break;
            }
            this.turno = false;
        }catch(Exception e){
            tablero=this.tablero.inicializar_tablero_estandar(this);
        }
        
        return(tablero);
    }
    
    /**Comprueba si una partida esta terminada, ya sea por tablas o por
     * jaque mate.*/
    public boolean fin_partida(Game game){
        boolean tablas=false,mate=false;
        
        tablas=this.sonTablas(game);
        mate=this.esMateJava(game);
        
        return(tablas||mate);
    }
    
    /**Busca un rey en un tablero*/
    public int[] buscarRey(Game game, boolean color){
        int[] rey=new int[2];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                if(game.tablero.tablero[i][j].getOcupada()&&
                game.tablero.tablero[i][j].getFicha().getColor()==color&&
                game.tablero.tablero[i][j].getFicha().getTipo_ficha().equals("rey")){
            rey[0]=i;
            rey[1]=j;
                }
        
        return(rey);
        
    }
    
    public Game tableroDePartidaPorFichero(){
        Game game = new Game();
        Tablero tablero = new Tablero();
        game.setTablero(tablero);
        PartidaFichero pf = new PartidaFichero(this);
        System.out.println("Introduzca la ruta del archivo a leer, seguido del nombre del archivo:");
        System.out.println("(Por ejemplo: [c:\\partida.txt]");
        String ruta=pf.obtenerRuta();
        String[] movs = new String[100];
        try {
            movs=pf.obtenerCoordenadasFichero(ruta);
            game=pf.jugarPartidaFichero(this,movs);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return(game);
    }
    
     /*Esta funcion se invoca desde MAIN. Recibe la partida creada anteriormente y devuelve un tablero
     personalizado o estandar, dependiendo de lo que pida el usuario*/
    public Game obtener_tablero(Game game){
        int personal;
        Tablero tablero=null;
        //Le pido al controlador un tipo de partida
        personal = this.pedirtablero_personalizado();
        //0 indica partida estandar
        //1 indica escenarios particulares
        //2 indica
        //3 indica
        
        if(personal==0) game.tablero=this.tablero.inicializar_tablero_estandar(this);
        else    if(personal==1) game.tablero=this.escenariosParticulares();
        else    if(personal==2) game=this.tableroDePartidaPorFichero();
        else    if(personal==3) game=this.cargar();
        
        
        return(game);
    }
    
    public ArrayList getMisObservers() {
        return misObservers;
    }
    
    public void opcionMover(int[] coordenadas, Prolog engine, Partida_Prolog p, boolean comiendo) throws NoSolutionException, MalformedGoalException{
        System.out.println("Entra en opcion MOVER");
        int filaorigen=coordenadas[0];
        int columnaorigen=coordenadas[1];
        int filadestino=coordenadas[2];
        int columnadestino=coordenadas[3];
        
        p.mover(filaorigen,columnaorigen,filadestino, columnadestino,this.getTurno(),engine,comiendo);    
        System.out.println("Despues de mover en PROLOG con BLANCAS.");
        boolean movida=this.mover(filaorigen,columnaorigen,filadestino,columnadestino,this.getTablero());
        System.out.println("Despues de mover en JAVA con BLANCAS.");
        if(movida) {
            
        //Si la ha movido, necesito moverla tb en prolog.
       // p.mover(filaorigen,columnaorigen,filadestino, columnadestino,this.getTurno(),engine,comiendo);    
            
            if(this.tablero.tablero[filadestino][columnadestino].getOcupada()){
                Ficha ficha=this.tablero.tablero[filadestino][columnadestino].getFicha();
                System.out.print("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
                //      LogManager.info("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
                if(ficha.getColor()){
                    System.out.println("negro.");
                    //              LogManager.info("negro.");
                }else{
                    System.out.println("blanco.");
                    //              LogManager.info("blanco.");
                }
            }
        }
        //Por ahora va aqui ya que esta funcion deberia ir en el controller
        this.notifyObserver();
        //this.aniadirVista();
        //return(this);
    }
    
    public boolean esMateJava(Game game){
    return(false);
    }
    
    public boolean esMate(Game game, Prolog engine){
        boolean esMate=false;
        //Aqui metemos la sentencia PROLOG.
        
        
        
        return(esMate);
    }
    
    public boolean sonTablas(Game game){
        boolean sonTablas=false;
        
        return(sonTablas);
    }
    
    public boolean esJaque(Game game, Prolog engine){
       return(false); 
    }
    
    public void rendicion(Game game){
        
        System.out.print("El jugador ");
        if(game.getTurno()) System.out.print("negro se ha rendido.");
        else System.out.print("blanco se ha rendido.");
    }
    
    public void guardar(Game game){
        PartidaFichero pf = new PartidaFichero(game);
        System.out.println("Introduzca la ruta y el nombre que desea para la partida:");
        String nombre = pf.obtenerRuta();
        FileOutputStream fout;
        
        try{
            fout = new FileOutputStream(nombre);
            pf.escrituraPartida(fout,game);
        }catch (IOException e){}
        
    }
    
    public Game cargar(){
        Game game = new Game();
        PartidaFichero pf = new PartidaFichero(game);
        System.out.println("Introduzca la ruta de la partida que desea abrir.");
        String archivo= pf.obtenerRuta();
        game=pf.aperturaPartida(archivo);
        
        return(game);
    }
    
    /**Deberia recorrer el tablero buscando posibles movimientos.*/
    public boolean PuedeMover(Game game){
        
        return(true);
    }
    
    /**Busca el rey correspondiente al turno de la partida. Si es blanco, mira si
     * esta amenazado por negras, y viceversa.*/
    public boolean reyEstaEnJaque(Game game){
        
        int[] coor = buscarRey(game,game.getTurno());
        if(game.getTurno()) //NEGRAS
            return(game.tablero.tablero[coor[0]][coor[1]].getAmenazada_por_blancas());
        else return(game.tablero.tablero[coor[0]][coor[1]].getAmenazada_por_negras());
    }
    
    public void ayuda(Game game){
        Ficha ficha;
        boolean turno = game.getTurno();
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
            if(game.tablero.tablero[i][j].getOcupada()&&
                    game.tablero.tablero[i][j].getFicha().getColor()==turno){
                ficha=game.tablero.tablero[i][j].getFicha();
                this.mostrarMovimientos(game,ficha,i,j);
            }
            }
    }
    
    public void mostrarMovimientos(Game game, Ficha ficha, int i, int j) {
        
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
    
    public void keyPressed(KeyEvent e) {
        
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void mostrarAmenazadasBlancas(Game game){
        Casilla casillaAux;
        Ficha fichaAux;
        System.out.println("     a    b    c    d    e    f    g    h  ");
        for(int i=0;i<8;i++){
            System.out.println("  -----------------------------------------");
            System.out.print((8-i)+" |");
            for(int j=0;j<8;j++){
                casillaAux = game.getTablero().getCasilla(i,j);
                //Hay ficha por lo tanto imprimimos su contenido
                if(casillaAux.getAmenazada_por_blancas())
                    System.out.println(" AB ");
                else{
                    System.out.print("    ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("  -----------------------------------------");
    }
    
    public void mostrarAmenazadasNegras(Game game){
        Casilla casillaAux;
        Ficha fichaAux;
        System.out.println("     a    b    c    d    e    f    g    h  ");
        for(int i=0;i<8;i++){
            System.out.println("  -----------------------------------------");
            System.out.print((8-i)+" |");
            for(int j=0;j<8;j++){
                casillaAux = game.getTablero().getCasilla(i,j);
                //Hay ficha por lo tanto imprimimos su contenido
                if(casillaAux.getAmenazada_por_negras())
                    System.out.println(" AN ");
                else{
                    System.out.print("    ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("  -----------------------------------------");
    }
    
    
}