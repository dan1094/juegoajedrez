/*
 * Controller2.java
 *
 * Created on 30 de octubre de 2007, 17:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.partida.Ficha;
import model.partida.Partida;
import model.partida.Tablero;
import view.*;

/**
 *
 * @author Administrador
 */
public class Controller2 {
    
    Partida partida;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    
    
    /** Creates a new instance of Controller2 */
    public Controller2() {
    }
   
    public void comenzar()
    {
         //Declaro un array, donde meteremos las coordenadas, una vez pasadas de FIDE a enteros
        int coordenadas[];
        coordenadas = new int[4];
        
        
        System.out.println("COMIENZO DE LA PARTIDA");
        System.out.print("El turno es de las: ");
        if(partida.getTurno()) System.out.println("NEGRAS");
        else System.out.println("BLANCAS");
        
        do{
            
            coordenadas = pedir_coordenadas_movimiento();
            int filaorigen=coordenadas[1];
            int columnaorigen=coordenadas[0];
            int filadestino=coordenadas[3];
            int columnadestino=coordenadas[2];
            
            boolean movida=partida.mover(filaorigen,columnaorigen,filadestino,columnadestino,partida.tablero);
            if(movida)
            { 
              //Para comprobar que ha movido, miramos lo que hay ahora en la casilla destino.
              Ficha ficha=partida.tablero.getCasilla(filadestino,columnadestino).getFicha();
              System.out.print("Ha movido el/la: "+ficha.getTipo_ficha()+", de color ");
              if(ficha.getColor()) System.out.println("negro.");
              else System.out.println("blanco.");
              if(partida.tablero.tablero[filadestino][columnadestino].getFicha().getTipo_ficha().equalsIgnoreCase("rey"))
                 {
                 //Si lo movido es un rey, ya no puede enrocar.
                 //de que color es?
                 if(ficha.getColor()==false) 
                   partida.setBlanco_puede_enrocar(false);
                 else partida.setNegro_puede_enrocar(false);
                 }
             }  
            else
            {
                System.out.println("No puede realizarse el movimiento");
            }
        }while(!partida.fin_partida(partida));
       
       
    
    }
    /**Ofrece la personalizacion del tablero de la partida*/
     public boolean tablero_personalizado(){
        int tipo_partida=0;
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
     
    public int[] pedir_coordenadas_movimiento(){
        
        char coor_cadena[];
        coor_cadena = new char[10];
        int coordenadas[];
        coordenadas = new int[4];
        
        System.out.println("Introduzca las coordenadas del movimiento (formato FIDE):");
         
        try {
            //Creamos un array de chars, donde el usuario metera las coordenadas en formato FIDE
            //y llamamos a "de_fide_a_modelo"
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            coor_cadena=in.readLine().toCharArray();
            coordenadas=this.de_fide_a_modelo(coor_cadena);
                        
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(coordenadas);
     }
     /**Esta funcion se invoca desde MAIN. Recibe la partida creada anteriormente y devuelve un tablero
     *personalizado o estandar, dependiendo de lo que pida el usuario*/
   
    public Partida obtener_tablero(Partida partida){
        boolean personal=true;
        Tablero tablero=null;
        //Creo un controlador
        //Controller controller = new Controller();
        //Asocio el controlador a la partida
        //partida.setController(controller);
        //Le pido al controlador un tipo de partida
        personal = tablero_personalizado();
        if(personal){
            //La partida es personalizada.
            partida.tablero=partida.tablero.inicializar_tablero_personalizado(partida);
            partida.turno=this.obtener_turno_personalizado(partida);
        }else{
            //La partida es estandar
            partida.tablero=partida.tablero.inicializar_tablero_estandar(partida);
        }
        
        return(partida);
   }
    
    public  int[] de_fide_a_modelo(char[] fide){
         int coordenadas[];
         coordenadas = new int[4];
         //Vamos leyendo de caracter en caracter, lo introducido en "fide[]"
         switch(fide[0]){
             case 'T':
             case 't':
             case 'C':
             case 'c':
             case 'A':
             case 'a':
             case 'D':
             case 'd':
             case 'R':
             case 'r':
        }
         
         
         
         return(coordenadas);
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
    
     /**Funcion para pedir al usuario la fila de la ficha solicitada*/
     public int ofrecer_fila(){
        int fila=0;
        try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("FILA: ");
            fila = Integer.parseInt(in.readLine())-1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(fila);
    }
    
     /**Funcion para pedir al usuario la fila de la ficha solicitada*/
     public int ofrecer_columna(){
        int columna=0;
        char columna_letra;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("COLUMNA: ");
            columna_letra=(char)in.read();
            columna=this.convertir(columna_letra);
            //columna = Integer.parseInt(in.readLine())-1;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }return(columna);
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

    /**Esta funcion convierte la columna, introducida en letras por el usuario,
     *a numeros, para la aplicacion*/
     public int convertir(char letra){
         switch(letra){
             case 'A':
             case 'a':  return(0);
             case 'B':
             case 'b':  return(1);
             case 'C':
             case 'c':  return(2);
             case 'D':
             case 'd':  return(3);
             case 'E':
             case 'e':  return(4);
             case 'F':
             case 'f':  return(5);
             case 'G':
             case 'g':  return(6);
             case 'H':
             case 'h':  return(7);
             default: return(8);
         }
                 
     }
     
     public int convertir_int(char letra){
         switch(letra){
             
             case '1':  return(7);             
             case '2':  return(6);
             case '3':  return(5);
             case '4':  return(4);
             case '5':  return(3);
             case '6':  return(2);
             case '7':  return(1);
             case '8':  return(0);
             default: return(8);
         }
                 
     }
     public boolean obtener_turno_personalizado(Partida partida){
         boolean turno=false;
         try {
                        
             
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int turn=in.read();
            
            if(turn==0) turno=false;
            else turno=true;
                      
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         return(turno);
     }
      public static void main(String[] args){ 
          
        boolean mate=false;
        int i=1, filaorigen=0, columnaorigen=0, filadestino=0, columnadestino=0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Controller2 controller = new Controller2();
        
        Partida partida = new Partida();
        
        MostrarTablero mostrarTableroNegro = new MostrarTableroNegro();
        MostrarTablero mostrarTableroNegro2 = new MostrarTableroNegro();
        
        //partida.addObserver(mostrarTableroNegro);
        //partida.addObserver(mostrarTableroNegro2);
        //partida.removeObserver(mostrarTableroNegro);
        
       
        
        System.out.println("BIENVENIDO AL AJEDREZ");
        
        //CasosDeUsoEnNegro instancia= new CasosDeUsoEnNegro();
        //instancia.casosDeUso();
        
        /*Creamos una partida, y llamamos a OBTENER TABLERO, que nos devuelve un 
         tablero, el que asociamos a setTablero de la partida. */
        
        Tablero tablero = new Tablero(0);
        
        partida.setTablero(tablero);  //Debemos asociar un tablero vacio antes
        controller.obtener_tablero(partida); 
        controller.comenzar();
        
        
      }
    
}
