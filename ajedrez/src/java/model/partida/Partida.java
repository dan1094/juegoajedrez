/*
 * Partida.java
 *
 * Created on 10 de octubre de 2007, 21:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

import controller.Fide;
import controller.IObserver;
import controller.ISubject;
import controller.TableroFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import view.MostrarTablero;
import view.MostrarTableroBlanco;
import view.MostrarTableroNegro;

/**
 *
 * @author Pablo
 */
public class Partida implements ISubject {
    
    protected int id_partida;
    protected boolean turno;
    public Tablero tablero;
    protected boolean blanco_puede_enrocar;
    protected boolean negro_puede_enrocar;
    private ArrayList misObservers;
    private MostrarTablero mostrarTableroNegro = new MostrarTableroNegro();

    
    /**Instancia vacia de Partida*/
    public Partida(){
        id_partida = 0;
        turno = false;
        blanco_puede_enrocar = true;
        negro_puede_enrocar = true;
        //tablero.inicializar_tablero_estandar(this);
        misObservers = new ArrayList();
    }
    
     public void addObserver(IObserver obs) {
         System.out.println("A�adiendo Observer");
        // LogManager.info("A�adiendo Observer");
         misObservers.add(obs);
         System.out.println("Observer a�adido");       
     //   LogManager.info("Observer a�adido");
     }

    public void removeObserver(IObserver obs) {
        System.out.println("Eliminando Observer");
        //LogManager.info("Eliminando Observer");
        misObservers.remove(misObservers.size()-1);
        System.out.println("Observer eliminado");
        //LogManager.info("Observer eliminado");
    }
    public void notifyObserver() 
    {
        
        for( int i = 0; i < misObservers.size(); i++ )
        {
            IObserver obs = ( IObserver )misObservers.get(i);
            obs.update(this);
            //LogManager.info("********************OBSERVER ENTERADO************************");
            
        }

        
    }
    
    /** Creates a new instance of Partida */
    public Partida(int id_partida, boolean turno, Tablero tablero, boolean blanco_puede_enrocar, boolean negro_puede_enrocar) {
        this.id_partida=id_partida;
        this.tablero=tablero;
        this.turno=turno;
        this.blanco_puede_enrocar=blanco_puede_enrocar;
        this.negro_puede_enrocar=negro_puede_enrocar;
        misObservers = new ArrayList();
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
    public void nueva_partida()
    {
        int n_partida = 0;
        MostrarTablero mostrarTableroBlanco = new MostrarTableroBlanco();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         do
        {
            System.out.println("Que desea hacer?");
            System.out.println("1.- A�adir una vista");
            System.out.println("2.- Suprimir una vista");
            System.out.println("3.- No realizar ninguna accion");
            
            try{
                n_partida = Integer.parseInt(in.readLine());
                if(n_partida==1)
                {
                    this.addObserver(mostrarTableroBlanco);
                    mostrarTableroBlanco.update(this);
                }
                else if(n_partida==2)
                {
                    if(misObservers.size()<2)
                    {
                        System.out.println("No puede borrar una vista ya que no existe ninguna");
                    }
                    else
                    {
                        this.removeObserver(mostrarTableroBlanco);
                        
                    }
                   
                }
                
                
            }catch(NumberFormatException ex){
                
                System.out.println("Caracter invalido");
            //    LogManager.info("Caracter invalido");
                
            }catch(IOException ex){
                
                System.out.println("Caracter invalido");
            //    LogManager.info("Caracter invalido");
            }
            
        
        }while((n_partida!=1)&&(n_partida!=2)&&(n_partida!=3));
        
        
    }
            
    public void comenzar(Partida partida)
    {
        //Declaro un array, donde meteremos las coordenadas, una vez pasadas de FIDE a enteros
        int coordenadas[] = new int[4];
        MostrarTableroNegro mostrarTableroNegro = new MostrarTableroNegro();
        
        Fide fide= new Fide();
        
        mostrarTableroNegro.update(partida);
       
        this.nueva_partida();
        
        
        System.out.println("COMIENZO DE LA PARTIDA");
      //  LogManager.info("COMIENZO DE LA PARTIDA");
        System.out.print("El turno es de las: ");
      //  LogManager.info("El turno es de las: ");
        if(partida.getTurno()){
            System.out.println("NEGRAS");
      //      LogManager.info("NEGRAS");
        }
        else{
            System.out.println("BLANCAS");
      //      LogManager.info("BLANCAS");
        }
        do{
           do{
            coordenadas = fide.de_fide_a_modelo(partida,pedir_coordenadas_movimiento());
            }while(coordenadas==null);
           
            int filaorigen=coordenadas[0];
            int columnaorigen=coordenadas[1];
            int filadestino=coordenadas[2];
            int columnadestino=coordenadas[3];       
         
            System.out.println("FILA ORIGEN: "+filaorigen);
        //    LogManager.info("FILA ORIGEN: "+filaorigen);
            System.out.println("COL ORIGEN: "+columnaorigen);
        //    LogManager.info("COL ORIGEN: "+columnaorigen);
            System.out.println("FILA DESTINO: "+filadestino);
        //    LogManager.info("FILA DESTINO: "+filadestino);
            System.out.println("COL DESTINO: "+columnadestino);
        //    LogManager.info("COL DESTINO: "+columnadestino);
            
            boolean movida=partida.mover(filaorigen,columnaorigen,filadestino,columnadestino,partida.getTablero());
            
            if(movida)
            { 
              //Para comprobar que ha movido, miramos lo que hay ahora en la casilla destino.
              Ficha ficha=partida.getTablero().getCasilla(filadestino,columnadestino).getFicha();
              System.out.print("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
        //      LogManager.info("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
              if(ficha.getColor()){
                  System.out.println("negro.");
        //          LogManager.info("negro.");
              }
              else{
                  System.out.println("blanco.");
        //          LogManager.info("blanco.");
              }
             /* if(partida.getTablero().tablero[filadestino][columnadestino].getFicha().getTipo_ficha().equalsIgnoreCase("rey"))
                 {
                 //Si lo movido es un rey, ya no puede enrocar.
                 //de que color es?
                 if(ficha.getColor()==false) 
                   partida.setBlanco_puede_enrocar(false);
                 else partida.setNegro_puede_enrocar(false);
                 }*/
             } 
            //Por ahora va aqui ya que esta funcion deberia ir en el controller
            this.notifyObserver();
            this.nueva_partida();
        }while(!partida.fin_partida(partida));
        
    }
    
    /**Recibe la eleccion del cambio y realiza el cambio de ficha*/
    public Tablero cambio_ficha(Tablero tablero, int eleccion, int fd, int cd){
     //Esta funcion dependiendo de la ficha que el jugador haya escogido
      //crea la ficha y la mete en su sitio.
     System.out.println("Cambio de ficha. ("+fd+","+cd+").");
   //  LogManager.info("Cambio de ficha. ("+fd+","+cd+").");
     System.out.println("Ha solicitado cambiar el peon por un "+eleccion);
   //  LogManager.info("Ha solicitado cambiar el peon por un "+eleccion);
     
      switch(eleccion){
          case 1: tablero.tablero[fd][cd].setFicha(new Dama(this.getTurno()));
                    return(tablero);
          case 2: tablero.tablero[fd][cd].setFicha(new Torre(this.getTurno()));
                    return(tablero);
          case 3: tablero.tablero[fd][cd].setFicha(new Alfil(this.getTurno()));
                    return(tablero);
          case 4: tablero.tablero[fd][cd].setFicha(new Caballo(this.getTurno()));
                    return(tablero);
          default: return(tablero);
      }
  }
    
    /**Comprueba si el movimiento es una CORONACION y ofrece el cambio*/
    public Tablero ofrecer_cambio(Partida partida, int fo, int co, int fd, int cd){
        System.out.println("FO="+fo+" CO="+co+" FD="+fd+" CD="+cd+" TURNO="+partida.getTurno());
        Tablero tablero = new Tablero();
      if((fd==0)&&(fo==1)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          
          int eleccion = this.ofrecer_cambio_ficha();
          tablero=this.cambio_ficha(partida.tablero,eleccion,fd,cd);
          System.out.println("Coronacion de blancas");
          
      }else if((fd==7)&&(fo==6)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
            
          System.out.println("FO="+fo+" CO="+co+" FD="+fd+" CD="+cd);
          
          int eleccion = this.ofrecer_cambio_ficha();
          tablero=this.cambio_ficha(partida.tablero,eleccion,fd,cd);
          System.out.println("Coronacion de negras");
       }else return(tablero);
      
      return(partida.tablero);
  }
    
    /**Comprueba el movimiento que ha introducido el usuario*/
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, 
        int filadestino, int columnadestino, Tablero tablero){
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
        System.out.println("La ficha de la casilla ORIGEN es de su color.");
     //   LogManager.info("La ficha de la casilla ORIGEN es de su color.");
        
        //Para comprobar el movimiento necesitamos saber la ficha que se mueve
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
                                if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf))
                                    this.setTablero(this.ofrecer_cambio(this,filaorigen,columnaorigen,filadestino,columnadestino));
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
                                if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf))
                                    this.setTablero(this.ofrecer_cambio(this,filaorigen,columnaorigen,filadestino,columnadestino));
                                
                               return(mcf);
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
    
    public boolean mover(int filaorigen, int columnaorigen, int filadestino, 
            int columnadestino, Tablero tablero){
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
                
                this.setTablero(this.tablero.amenazas(this));
                if(turno){
                    System.out.println("ES EL TURNO DE LAS NEGRAS");
//                    LogManager.info("ES EL TURNO DE LAS NEGRAS");
                }
                else{
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
    
    public boolean ocupada_color(Tablero tablero, int fo, int co){
      Ficha ficha;
      if(this.tablero.tablero[fo][co].getOcupada()) ficha=this.tablero.tablero[fo][co].getFicha();
      else return(false);
      if(ficha.getColor()==this.getTurno()) return(true);
      else return(false);
   }
    
    /*Esta funcion se invoca desde MAIN. Recibe la partida creada anteriormente y devuelve un tablero
     personalizado o estandar, dependiendo de lo que pida el usuario*/
    public Partida obtener_tablero(){
        boolean personal=true;
        Tablero tablero=null;
        //Le pido al controlador un tipo de partida
        personal = this.tablero_personalizado();
        if(personal){
            int opcion=0;
            System.out.println("�Que Escenario desea?");
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
                  case 1: this.tablero = tabFac.situacionEnroque();
                          break;  
                  case 2: this.tablero = tabFac.situacionCoronar();
                          break; 
                  case 3: this.tablero = tabFac.situacionComerDobleOpcion();
                          break; 
                  default: this.tablero = tabFac.situacionComerDobleCaballo();
                          break; 
              }
                this.turno = false;
            }catch(Exception e){
                this.tablero=this.tablero.inicializar_tablero_estandar(this);
            }
            //La partida es personalizada.
            //this.tablero=this.tablero.inicializar_tablero_personalizado(this);
            //this.turno=this.obtener_turno_personalizado(this);
        }else{
            //La partida es estandar
            this.tablero=this.tablero.inicializar_tablero_estandar(this);
        }
        
        return(this);
   }
    
    public boolean obtener_turno_personalizado(Partida partida){
         boolean turno=false;
         int turn=2; //Igual a cero, para asegurarnos de que entra a leer.
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
    
  
    public boolean fin_partida(Partida partida){
        //Una partida termina cuando hay jaque-mate o cuando hay tablas.
        boolean tablas=false;
        boolean mate=false;
        
        tablas=this.son_tablas(partida);
        mate=this.es_mate(partida);
        
        return(tablas||mate);
    }
    
    /**Ofrece la personalizacion del tablero de la partida*/
     public boolean tablero_personalizado(){
        int tipo_partida=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            
            System.out.println("�Quiere introducir una nueva pantalla a la partida?");
            
            System.out.println("Introduzca el tipo de partida que desea empezar");
            System.out.println("0 .- Partida Estandar");
            System.out.println("1 .- Partida Personalizada");
            
            try{
                tipo_partida = Integer.parseInt(in.readLine());
            }catch(NumberFormatException ex){
                
                System.out.println("Caracter invalido");
//                LogManager.info("Caracter invalido");
                
            }catch(IOException ex){
                
                System.out.println("Caracter invalido");
//                LogManager.info("Caracter invalido");
            }
            
        
        }while((tipo_partida!=0)&&(tipo_partida!=1));
        
        if(tipo_partida==0) return(false);
        else return(true);
    }
     
    
    /**Mira si se ha llegado a tablas en la partida*/
    public boolean son_tablas(Partida partida){
        //Busca los reyes y comprueba si pueden mover
                int filarey_blanco=0,columnarey_blanco=0,filarey_negro=0,columnarey_negro=0;
       
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                if((this.tablero.tablero[i][j].getFicha()!=null)&&(this.tablero.tablero[i][j].getFicha().getTipo_ficha().equals("rey"))&&(this.tablero.tablero[i][j].getFicha().getColor()==false))
                {
                    //Si es un rey, y si es blanco
                    filarey_blanco=i;
                    columnarey_blanco=j;
                }
                 if((this.tablero.tablero[i][j].getFicha()!=null)&&(this.tablero.tablero[i][j].getFicha().getTipo_ficha().equals("rey"))&&(this.tablero.tablero[i][j].getFicha().getColor()==true))
                {//Si es un rey, y si es negro
                    filarey_negro=i;
                    columnarey_negro=j;
                }
            }
        if(this.tablero.tablero[filarey_blanco][columnarey_blanco].getFicha().getColor()==false){
            //se comprueba si el rey blanco puede mover
            if(this.tablero.tablero[filarey_blanco-1][columnarey_blanco-1].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco-1][columnarey_blanco].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco-1][columnarey_blanco+1].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco][columnarey_blanco-1].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco][columnarey_blanco+1].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco+1][columnarey_blanco-1].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco+1][columnarey_blanco].getAmenazada_por_negras()&&
                this.tablero.tablero[filarey_blanco+1][columnarey_blanco+1].getAmenazada_por_negras()&&
               !this.tablero.tablero[filarey_blanco][columnarey_blanco].getAmenazada_por_negras())
            return(true);
        else return(false);
        }else{
            //se comprueba si el rey negro puede mover
            if(this.tablero.tablero[filarey_negro-1][columnarey_negro-1].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro-1][columnarey_negro].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro-1][columnarey_negro+1].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro][columnarey_negro-1].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro][columnarey_negro+1].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro+1][columnarey_negro-1].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro+1][columnarey_negro].getAmenazada_por_blancas()&&
                this.tablero.tablero[filarey_negro+1][columnarey_negro+1].getAmenazada_por_blancas()&&
               !this.tablero.tablero[filarey_negro][columnarey_negro].getAmenazada_por_blancas())
            return(true);
        else return(false);        
        }
                
    }
    
    /**Mira si ha habido jaque-mate*/
    public boolean es_mate(Partida partida){
        //Busca los reyes y comprueba si pueden mover
        int filarey_blanco=0,columnarey_blanco=0,filarey_negro=0,columnarey_negro=0;
        int[] reyBlanco=this.buscarRey(partida,false);
        int[] reyNegro=this.buscarRey(partida,true);
        boolean mate=false;
       
        if(partida.getTurno()){ //Turno negras
            if(partida.tablero.tablero[reyNegro[0]][reyNegro[1]].getAmenazada_por_blancas()&&
                    !reyPuedeMover(partida,reyNegro)){
                
            }else return(false);
        }else{
            if(partida.tablero.tablero[reyBlanco[0]][reyBlanco[1]].getAmenazada_por_negras()&&
                    !reyPuedeMover(partida,reyBlanco)){
                
            }else return(false);
        }
        
        
        return(mate);
                
    }
    
    public boolean reyPuedeMover(Partida partida, int[] rey){
        boolean puede=false;
        int fil=rey[0],col=rey[1];
        
    /*    for(int i=fila-1;i<fila+2;i++){
            for(int j=col-1;j<col+2;j++){
                if(
            }
        }*/
       
        
        return(puede);
    }
    
    /**Ofrece al usuario el cambio de ficha al coronar un peon*/
     public int ofrecer_cambio_ficha(){
         int eleccion;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
          try {
            System.out.println("Ha coronado un peon. �Que ficha desea obtener?");
            System.out.println("1.- Reina");
            System.out.println("2.- Torre");
            System.out.println("3.- Alfil");
            System.out.println("4.- Caballo");
            //Leemos el numero
            eleccion = Integer.parseInt(in.readLine());
            return(eleccion);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la ficha.");
//            LogManager.info("Entrada incorrecta de la ficha.");
        } finally {
            return(0);
        }
     }

     public int ofrecer_ficha(){
        
        int opcion=0;
        System.out.println("�Que ficha desea introducir? (0 para ninguna mas)");
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
     
     public boolean pedir_color(){
        int columna=0, color=0;
        System.out.println("�Que color?");
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
     
     public String pedir_coordenadas_ficha(){
         
        
        String coordenadas="";
        
        System.out.println("Introduzca las coordenadas (FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //llamamos a convertir_columna, que pasa de char a entero. Y lo metemos en un array de enteros.
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coordenadas=in.readLine();
            
                      
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     } 
     
     public String pedir_coordenadas_movimiento(){
        
        String coordenadas="";
        System.out.println("Introduzca las coordenadas del movimiento (formato FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //y llamamos a "de_fide_a_modelo", de la clase FIDE.
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coordenadas=in.readLine();
                      
                        
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     }
   
     public int[] buscarRey(Partida partida, boolean color){
         int[] rey=new int[2];
         for(int i=0;i<8;i++)
             for(int j=0;j<8;j++)
                if(partida.tablero.tablero[i][j].getOcupada()&&
                   partida.tablero.tablero[i][j].getFicha().getColor()==color&&
                   partida.tablero.tablero[i][j].getFicha().getTipo_ficha().equals("rey")){
                            rey[0]=i;
                            rey[1]=j;
                }
                    
             return(rey);
     
     }
     
     public boolean esEnroque(int fo, int co, int fd, int cd, Partida partida){
         if(partida.tablero.tablero[fo][co].getOcupada()&&
            partida.tablero.tablero[fo][co].getFicha().equals("rey")&&
            (fo==0)&&(co==4)&&(fd==0)&&(cd==6)){
            return(true);
             
         }else  if(partida.tablero.tablero[fo][co].getOcupada()&&
                   partida.tablero.tablero[fo][co].getFicha().equals("rey")&&
                   (fo==7)&&(co==4)&&(fd==7)&&(cd==6)){
                   return(true);
                }else   if(partida.tablero.tablero[fo][co].getOcupada()&&
                           partida.tablero.tablero[fo][co].getFicha().equals("rey")&&
                           (fo==0)&&(co==4)&&(fd==0)&&(cd==2)){
                           return(true);
                        }else   if(partida.tablero.tablero[fo][co].getOcupada()&&
                                   partida.tablero.tablero[fo][co].getFicha().equals("rey")&&
                                   (fo==7)&&(co==4)&&(fd==7)&&(cd==2)){
                                    return(true);
          }else return(false);
     }
      
     public Tablero enrocar(Partida partida, int fila, int colDestino, boolean turno){
         Tablero tablero = new Tablero();
         tablero=partida.getTablero();
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
}
