/*
 * Partida.java
 *
 * Created on 10 de octubre de 2007, 21:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.Pack200;
import view.*;

/**
 *
 * @author Pablo
 */
public class Partida {
    
    protected int id_partida;
    protected boolean turno;
    protected Tablero tablero;
    protected boolean blanco_puede_enrocar;
    protected boolean negro_puede_enrocar;
    protected Controller controller;
    
    /**Instancia vacia de Partida*/
    public Partida(){
    }
    
    /** Creates a new instance of Partida */
    public Partida(int id_partida, boolean turno, Tablero tablero, boolean blanco_puede_enrocar, boolean negro_puede_enrocar) {
        this.id_partida=id_partida;
        this.tablero=tablero;
        this.turno=turno;
        this.blanco_puede_enrocar=blanco_puede_enrocar;
        this.negro_puede_enrocar=negro_puede_enrocar;
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
    
    public Controller getController(){
        return(this.controller);
    }
    
    public void setController(Controller controller){
        this.controller=controller;
    }
    
    /**Metodo que cambia el turno de la partida*/
    public void cambio_turno(){
        //Si el turno es False(BLANCAS) pasa a true(NEGRAS) y viceversa
        if(this.getTurno()) 
            this.setTurno(false);
        else this.setTurno(true);
    }
    
    /**Recibe la eleccion del cambio y realiza el cambio de ficha*/
    public Tablero cambio_ficha(Tablero tablero, int eleccion, int fd, int cd){
     //Esta funcion dependiendo de la ficha que el jugador haya escogido
      //crea la ficha y la mete en su sitio.
     System.out.println("Cambio de ficha. ("+fd+","+cd+").");
     System.out.println("Ha solicitado cambiar el peon por un "+eleccion);
      switch(eleccion){
          case 1: tablero.tablero[fd][cd].setFicha(new Reina(33,this.getTurno()));
                    return(tablero);
          case 2: tablero.tablero[fd][cd].setFicha(new Torre(33,this.getTurno()));
                    return(tablero);
          case 3: tablero.tablero[fd][cd].setFicha(new Alfil(33,this.getTurno()));
                    return(tablero);
          case 4: tablero.tablero[fd][cd].setFicha(new Caballo(33,this.getTurno()));
                    return(tablero);
          default: return(tablero);
      }
  }
    
    /**Comprueba si el movimiento es una CORONACION y ofrece el cambio*/
    public void ofrecer_cambio(Partida partida, int fo, int co, int fd, int cd){
      if((fd==0)&&(fo==1)&&(this.getTurno()==tablero.tablero[fo][co].getFicha().color)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          int eleccion = this.controller.ofrecer_cambio_ficha();
          this.tablero=this.cambio_ficha(partida.tablero,eleccion,fd,cd);
          
      }else if((fd==7)&&(fo==6)&&(this.getTurno()==tablero.tablero[fo][co].getFicha().color)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          int eleccion = this.controller.ofrecer_cambio_ficha();
          this.tablero=this.cambio_ficha(partida.tablero,eleccion,fd,cd);
       }
  }
    
    /**Comprueba el movimiento que ha introducido el usuario*/
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, 
        int filadestino, int columnadestino, Tablero tablero){
        
        System.out.println("Comprobando el movimiento.");
        
        //comprueba que el origen y el destino estan dentro del tablero
        boolean origen_dentro=this.tablero.dentro_tablero(filaorigen,columnaorigen); 
        boolean destino_dentro=this.tablero.dentro_tablero(filadestino,columnadestino);
        boolean origen_turno=this.ocupada_color(tablero,filaorigen,columnaorigen);
        
        //ORIGEN Y DESTINO DENTRO. Y ORIGEN OCUPADO POR FICHA DEL COLOR ADECUADO.
        if(origen_dentro&&destino_dentro&&origen_turno){
        
        System.out.println("Origen y Destino dentro del tablero.");
        System.out.println("La ficha de la casilla ORIGEN es de su color.");
        
        //Para comprobar el movimiento necesitamos saber la ficha que se mueve
        Ficha fichaorigen=this.tablero.tablero[filaorigen][columnaorigen].getFicha();
        Ficha fichadestino;
        boolean mcf;
        
        Casilla casilladestino = this.tablero.tablero[filadestino][columnadestino];
        
                if(fichaorigen.getColor()!=turno){ 
                    System.out.println("La ficha que se quiere mover no es del color del turno de la partida.");
                    return(false);
                }else if(!casilladestino.getOcupada()){
                                //origen del mismo color que el turno y casilla destino vacia
                                 System.out.println("Va a mover un/una: "+fichaorigen.getTipo_ficha()+". La casilla" +
                                         " destino esta vacia.");
                                 mcf=fichaorigen.movimiento_correspondiente_ficha(tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                                if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf))
                                     this.ofrecer_cambio(this,filaorigen,columnaorigen,filadestino,columnadestino);
                                 if(fichaorigen.getTipo_ficha().equals("rey")){
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
                                if(mcf) System.out.println("Ha comido un "+casilladestino.ficha.tipo_ficha+" contrario.");
                                if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf))
                                     this.ofrecer_cambio(this,filaorigen,columnaorigen,filadestino,columnadestino);
                               return(mcf);
                            }else if(casilladestino.getFicha().getColor()==this.getTurno()){
                                        System.out.println("El destino esta ocupado por una ficha de su propio color.");  
                                  }else return(false);
        
        }else {
               //Origen no valido o destino no valido o origen vacio
                if(!origen_dentro) System.out.println("El origen no es valido. No pertenece al tablero.");
                if(!destino_dentro)  System.out.println("El destino no es valido. No pertenece al tablero.");
                if(!origen_turno) System.out.println("La ficha de la casilla DESTINO es de su color.");
                return(false);//No se da la condicion del if. No estan dentro del tablero
        }
        
    return(false);
    }
    
    public boolean mover(int filaorigen, int columnaorigen, int filadestino, 
            int columnadestino, Tablero tablero){
        
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
                if(turno)  System.out.println("ES EL TURNO DE LAS NEGRAS");
                else System.out.println("ES EL TURNO DE LAS BLANCAS");
                
                return(true);
                
        }else{
            System.out.println("No puede realizarse el movimiento solicitado.");
            return(false);
        }
        
    }
    
    public boolean ocupada_color(Tablero tablero, int fo, int co){
      Ficha ficha;
      if(tablero.tablero[fo][co].getOcupada()) ficha=tablero.tablero[fo][co].getFicha();
      else return(false);
      if(ficha.color==this.turno) return(true);
      else return(false);
   }
    
    /**Esta funcion se invoca desde MAIN. Recibe la partida creada anteriormente y devuelve un tablero
     *personalizado o estandar, dependiendo de lo que pida el usuario*/
    public Partida obtener_tablero(Partida partida){
        boolean personal=true;
        Tablero tablero=null;
        //Creo un controlador
        Controller controller = new Controller();
        //Asocio el controlador a la partida
        partida.setController(controller);
        //Le pido al controlador un tipo de partida
        personal = controller.tablero_personalizado();
        if(personal){
            //La partida es personalizada.
            this.tablero=this.tablero.inicializar_tablero_personalizado(this);
        }else{
            //La partida es estandar
            this.tablero=this.tablero.inicializar_tablero_estandar(this);
        }
        
        return(this);
   }
    //ATENCION: ESTE METODO DEBERÍA IR ENTERO EN EL CONTROLER
    public void comenzar(){
        System.out.println("COMIENZO DE LA PARTIDA");
        System.out.print("El turno es de las: ");
        if(this.getTurno()) System.out.println("NEGRAS");
        else System.out.println("BLANCAS");
        MostrarTablero mostrarTablero = new MostrarTableroNegro(); 
        do{
            mostrarTablero.mostrar(tablero);
            System.out.println("COORDENADAS ORIGEN:");
            int filaorigen=this.controller.ofrecer_fila();
            int columnaorigen=this.controller.ofrecer_columna();
            System.out.println("COORDENADAS DESTINO:");
            int filadestino=this.controller.ofrecer_fila();
            int columnadestino=this.controller.ofrecer_columna();
            
            boolean movida=this.mover(filaorigen,columnaorigen,filadestino,columnadestino,tablero);
            if(movida)
            { 
              //Para comprobar que ha movido, miramos lo que hay ahora en la casilla destino.
              Ficha ficha=tablero.getCasilla(filadestino,columnadestino).getFicha();
              System.out.print("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
              if(ficha.getColor()) System.out.println("negro.");
              else System.out.println("blanco.");
              if(tablero.tablero[filadestino][columnadestino].getFicha().getTipo_ficha().equalsIgnoreCase("rey"))
                 {
                 //Si lo movido es un rey, ya no puede enrocar.
                 //de que color es?
                 if(ficha.getColor()==false) 
                   this.setBlanco_puede_enrocar(false);
                 else this.setNegro_puede_enrocar(false);
                 }
             }  
        }while(!this.fin_partida(this));
        
    }
    
    public boolean fin_partida(Partida partida){
        //Una partida termina cuando hay jaque-mate o cuando hay tablas.
        boolean tablas=false;
        boolean mate=false;
        
        tablas=this.son_tablas(this);
        mate=this.es_mate(this);
        
        return(tablas||mate);
    }
    
    /**Mira si se ha llegado a tablas en la prtida*/
    public boolean son_tablas(Partida partida){
        return(false);
    }
    
    /**Mira si ha habido jaque-mate*/
    public boolean es_mate(Partida partida){
        return(false);
    }
    
    
}
