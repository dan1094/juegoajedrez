/*
 * Partida.java
 *
 * Created on 10 de octubre de 2007, 21:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;

import controller.IObserver;
import controller.ISubject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
         System.out.println("Añadiendo Observer");
         misObservers.add(obs);
         System.out.println("Observer añadido");
     }

    public void removeObserver(IObserver obs) {
        System.out.println("Eliminando Observer");
        misObservers.remove(misObservers.indexOf(obs));
        System.out.println("Observer eliminado");
    }
    public void notifyObserver() 
    {
        
        for( int i = 0; i < misObservers.size(); i++ )
        {
            IObserver obs = ( IObserver )misObservers.get(i);
            obs.update(this);
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
    
    /**Recibe la eleccion del cambio y realiza el cambio de ficha*/
    public Tablero cambio_ficha(Tablero tablero, int eleccion, int fd, int cd){
     //Esta funcion dependiendo de la ficha que el jugador haya escogido
      //crea la ficha y la mete en su sitio.
     System.out.println("Cambio de ficha. ("+fd+","+cd+").");
     System.out.println("Ha solicitado cambiar el peon por un "+eleccion);
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
    public void ofrecer_cambio(Partida partida, int fo, int co, int fd, int cd){
      if((fd==0)&&(fo==1)&&(this.getTurno()==tablero.tablero[fo][co].getFicha().color)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          
          int eleccion = this.ofrecer_cambio_ficha();
          this.tablero=this.cambio_ficha(partida.tablero,eleccion,fd,cd);
          
      }else if((fd==7)&&(fo==6)&&(this.getTurno()==tablero.tablero[fo][co].getFicha().color)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          
          int eleccion = this.ofrecer_cambio_ficha();
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
                if(!origen_turno) System.out.println("La ficha de la casilla ORIGEN no es de su color.");
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
                this.tablero.amenazas();
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
            //La partida es personalizada.
            this.tablero=this.tablero.inicializar_tablero_personalizado(this);
            this.turno=this.obtener_turno_personalizado(this);
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
    
  
    public boolean fin_partida(){
        //Una partida termina cuando hay jaque-mate o cuando hay tablas.
        boolean tablas=false;
        boolean mate=false;
        
        tablas=this.son_tablas();
        mate=this.es_mate();
        
        return(tablas||mate);
    }
    
    /**Ofrece la personalizacion del tablero de la partida*/
     public boolean tablero_personalizado(){
        int tipo_partida=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do
        {
            System.out.println("Introduzca el tipo de partida que desea empezar");
            System.out.println("0 .- Partida Estandar");
            System.out.println("1 .- Partida Personalizada");
            
            try{
                tipo_partida = Integer.parseInt(in.readLine());
            }catch(NumberFormatException ex){
                
                System.out.println("Caracter invalido");
                
            }catch(IOException ex){
                
                System.out.println("Caracter invalido");
            }
            
        
        }while((tipo_partida!=0)&&(tipo_partida!=1));
        
        if(tipo_partida==0) return(false);
        else return(true);
    }
     
    
    /**Mira si se ha llegado a tablas en la partida*/
    public boolean son_tablas(){
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
    public boolean es_mate(){
        //Busca los reyes y comprueba si pueden mover
                int filarey_blanco=0,columnarey_blanco=0,filarey_negro=0,columnarey_negro=0;
       
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++){
                if((this.tablero.tablero[i][j].getFicha()!=null)&&this.tablero.tablero[i][j].getFicha().getTipo_ficha().equals("rey")&&(this.tablero.tablero[i][j].getFicha().getColor()==false))
                {//Si es un rey, y si es blanco
                    filarey_blanco=i;
                    columnarey_blanco=j;
                }
                if((this.tablero.tablero[i][j].getFicha()!=null)&&this.tablero.tablero[i][j].getFicha().getTipo_ficha().equals("rey")&&(this.tablero.tablero[i][j].getFicha().getColor()==true))
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
                this.tablero.tablero[filarey_blanco][columnarey_blanco].getAmenazada_por_negras())
                //Esta ultima linea diferencia el mate de las tablas. Si esta en jaque->es mate, si no son tablas
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
                this.tablero.tablero[filarey_negro][columnarey_negro].getAmenazada_por_blancas())
                //Esta ultima linea diferencia el mate de las tablas. Si esta en jaque->es mate, si no son tablas
            return(true);
        else return(false);        
        }
                
    }
    
    /**Ofrece al usuario el cambio de ficha al coronar un peon*/
     public int ofrecer_cambio_ficha(){
         int eleccion;
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
          try {
            System.out.println("Ha coronado un peon. ¿Que ficha desea obtener?");
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
        } finally {
            return(0);
        }
     }

   /**Ofrece al usuario las fichas que quiere para crear el tablero*/
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
     
      /**Pide al usuario el color de la deseado de la ficha*/
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
    
   
}
