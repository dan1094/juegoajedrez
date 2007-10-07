/*
 * Tablero.java
 *
 * Created on 19 de septiembre de 2007, 13:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Pablo
 */
public class Tablero {
    
    protected int id_tablero; //numero de tablero
    protected boolean turno;    //turno del jugador (BLANCAS=0, NEGRAS=1)
    protected Casilla tablero[][];
        
    /** Creates a new instance of Tablero */
    public Tablero() {        
    }
    
    /**Crea una tablero con los atributos especificados*/
    public Tablero(int id, boolean tur){
        this.id_tablero=id;
        this.turno=tur;
        tablero = new Casilla[8][8];
        }
    
    /**Coloca las fichas en sus posiciones iniciales*/
    public Tablero inicializar_tablero(Tablero tablero){
        
        int i=0,j=0;
        int id_ficha = 0;
        
        //CREAMOS LAS FICHAS BLANCAS. (sus ids iran del 0 al 15)
        Ficha peon_b_1 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_2 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_3 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_4 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_5 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_6 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_7 = new Peon(id_ficha,false);      id_ficha++;
        Ficha peon_b_8 = new Peon(id_ficha,false);      id_ficha++;
        Ficha tor_b_1 = new Torre(id_ficha,false);      id_ficha++;
        Ficha tor_b_2 = new Torre(id_ficha,false);      id_ficha++;
        Ficha cab_b_1 = new Caballo(id_ficha,false);    id_ficha++;
        Ficha cab_b_2 = new Caballo(id_ficha,false);    id_ficha++;
        Ficha alf_b_1 = new Alfil(id_ficha,false);      id_ficha++;
        Ficha alf_b_2 = new Alfil(id_ficha,false);      id_ficha++;
        Ficha reina_b = new Reina(id_ficha,false);      id_ficha++;
        Ficha rey_b = new Rey(id_ficha,false);          id_ficha++;

        //CREAMOS LAS FICHAS NEGRAS (ids del 16 al 31) 
        Ficha peon_n_1 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_2 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_3 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_4 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_5 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_6 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_7 = new Peon(id_ficha,true);       id_ficha++;
        Ficha peon_n_8 = new Peon(id_ficha,true);       id_ficha++;
        Ficha tor_n_1 = new Torre(id_ficha,true);       id_ficha++;
        Ficha tor_n_2 = new Torre(id_ficha,true);       id_ficha++;
        Ficha cab_n_1 = new Caballo(id_ficha,true);     id_ficha++;
        Ficha cab_n_2 = new Caballo(id_ficha,true);     id_ficha++;
        Ficha alf_n_1 = new Alfil(id_ficha,true);       id_ficha++;
        Ficha alf_n_2 = new Alfil(id_ficha,true);       id_ficha++;
        Ficha reina_n = new Reina(id_ficha,true);       id_ficha++;
        Ficha rey_n = new Rey(id_ficha,true);
                
        //CREA LAS INSTANCIAS CASILLAS DEL TABLERO
        Casilla cas;
        int m=0,n=0,id=0;
        int id_casilla= 0;
        for(m=0;m<8;m++)
            for(n=0;n<8;n++)
            {
                tablero.tablero[m][n] = new Casilla(id_casilla,null,m,n);
                id_casilla++;
            }
        
        
        //Asociamos las fichas a sus posiciones en el tablero.
        tablero.tablero[0][2].setFicha(alf_n_1);
        tablero.tablero[0][5].setFicha(alf_n_2);
        tablero.tablero[7][2].setFicha(alf_b_1);
        tablero.tablero[7][5].setFicha(alf_b_2);
        
        tablero.tablero[0][0].setFicha(tor_n_1);
        tablero.tablero[0][7].setFicha(tor_n_2);
        tablero.tablero[7][0].setFicha(tor_b_1);
        tablero.tablero[7][7].setFicha(tor_b_2);
        
        tablero.tablero[0][3].setFicha(reina_n);
        tablero.tablero[7][3].setFicha(reina_b);
        
        tablero.tablero[0][1].setFicha(cab_n_1);
        tablero.tablero[0][6].setFicha(cab_n_2);
        tablero.tablero[7][1].setFicha(cab_b_1);
        tablero.tablero[7][6].setFicha(cab_b_1);
        
        tablero.tablero[6][0].setFicha(peon_b_1);
        tablero.tablero[6][1].setFicha(peon_b_1);
        tablero.tablero[6][2].setFicha(peon_b_1);
        tablero.tablero[6][3].setFicha(peon_b_1);
        tablero.tablero[6][4].setFicha(peon_b_1);
        tablero.tablero[6][5].setFicha(peon_b_1);
        tablero.tablero[6][6].setFicha(peon_b_1);
        tablero.tablero[6][7].setFicha(peon_b_1);
        tablero.tablero[1][0].setFicha(peon_n_1);
        tablero.tablero[1][1].setFicha(peon_n_1);
        tablero.tablero[1][2].setFicha(peon_n_1);
        tablero.tablero[1][3].setFicha(peon_n_1);
        tablero.tablero[1][4].setFicha(peon_n_1);
        tablero.tablero[1][5].setFicha(peon_n_1);
        tablero.tablero[1][6].setFicha(peon_n_1);
        tablero.tablero[1][7].setFicha(peon_n_1);
        tablero.tablero[0][4].setFicha(rey_n);
        tablero.tablero[7][4].setFicha(rey_b);
       
        return(tablero);  
    }
    
    /**Modificael turno*/
    public void setTurno(boolean turno){
        this.turno=turno;
    }
    /**Metodo que cambia el turno*/
    public void cambio_turno(){
        //Si el turno es False(BLANCAS) pasa a true(NEGRAS) y viceversa
        if(this.getTurno()) 
            this.setTurno(false);
        else this.setTurno(true);
    }
    
    /**Obtiene el turno de la partida, a quien le toca mover. False(0)-> Turno de Blancas
     True(1)-> Turno de Negras*/
    public boolean getTurno(){
        return(this.turno);
    }
    
    /**Busca la casilla solicitada en el tablero, si no la encuentra devuelve null*/
    public Casilla getCasilla(int fila, int columna){
        
        return(tablero[fila][columna]);
    }
    
    public void setCasilla(Casilla casilla, int fila, int columna){
        tablero[fila][columna]=casilla;
    }
    public boolean mover(int filaorigen, int columnaorigen, int filadestino, int columnadestino, Tablero tablero){
        
        boolean mov_per=comprobar_movimiento(filaorigen,columnaorigen,filadestino,columnadestino,tablero);
        if(mov_per){
                //Obtenemos las casillas
                Casilla origen=getCasilla(filaorigen,columnaorigen);
                Casilla destino=getCasilla(filadestino,columnadestino);
                //Ponemos en el destino la ficha del origen
                destino.setFicha(origen.getFicha());
                //Vaciamos la casilla origen y directamente, al colocar la ficha
                //en el destino, se pone ocupada a TRUE el destino.
                origen.setFicha(null);
                tablero.cambio_turno();
                System.out.println("Ficha movida.");
                
                if(turno)  System.out.println("ES EL TURNO DE LAS NEGRAS");
                else System.out.println("ES EL TURNO DE LAS BLANCAS");
                
                return(true);
                
        }else{
            System.out.println("No puede realizarse el movimiento solicitado.");
            return(false);
        }
        
        
    }
    
    public boolean dentro_tablero(int fila, int columna){
        if((fila>=0)&&(fila<=7)&&(columna<=7)&&(columna>=0)) 
            return(true);
        else return(false);
    }
    
    public boolean comprobar_movimiento(int filaorigen, int columnaorigen, 
        int filadestino, int columnadestino, Tablero tablero){
        
        System.out.println("Comprobando el movimiento.");
        
        //comprueba que el origen y el destino estan dentro del tablero
        boolean origen_dentro=dentro_tablero(filaorigen,columnaorigen); 
        boolean destino_dentro=dentro_tablero(filadestino,columnadestino);
        boolean origen_turno=ocupada_color(tablero,filaorigen,columnaorigen);
        
        //ORIGEN Y DESTINO DENTRO. Y ORIGEN OCUPADO POR FICHA DEL COLOR ADECUADO.
        if(origen_dentro&&destino_dentro&&origen_turno){
        
        System.out.println("Origen y Destino dentro del tablero.");
        System.out.println("La ficha de la casilla ORIGEN es de su color.");
        
        //Para comprobar el movimiento necesitamos saber la ficha que se mueve
        Ficha fichaorigen=tablero.tablero[filaorigen][columnaorigen].getFicha();
        Ficha fichadestino;
        boolean mcf;
        
        Casilla casilladestino = tablero.tablero[filadestino][columnadestino];
        
                if(fichaorigen.getColor()!=turno){ 
                    System.out.println("La ficha que se quiere mover no es del color del turno de la partida.");
                    return(false);
                }else if(!casilladestino.getOcupada()){
                                //origen del mismo color que el turno y casilla destino vacia
                                 System.out.println("Va a mover un/una: "+fichaorigen.getTipo_ficha()+". La casilla" +
                                         " destino esta vacia.");
                                 mcf=fichaorigen.movimiento_correspondiente_ficha(this,filaorigen,columnaorigen,filadestino,columnadestino);
                                 if(fichaorigen.getTipo_ficha().equals("peon")&&(mcf)) 
                                     ofrecer_cambio(tablero,filaorigen,columnaorigen,filadestino,columnadestino);
                                 return(mcf);
                      }else if(casilladestino.getFicha().getColor()!=tablero.getTurno()){
                                //origen=turno, y destino del color diferente. Se puede comer la ficha del destino.
                                fichadestino=casilladestino.getFicha();
                                mcf=fichaorigen.movimiento_correspondiente_ficha(this,filaorigen,columnaorigen,filadestino,columnadestino);
                                System.out.println("El/La "+fichaorigen.tipo_ficha+" a mover es de su color. Y la casilla" +
                                        " destino esta ocupada por un/una "+fichadestino.getTipo_ficha()+" del contrario.");
                                System.out.println("Ha comido un "+casilladestino.ficha.tipo_ficha+" contrario.");
                               return(mcf);
                            }else if(casilladestino.getFicha().getColor()==tablero.getTurno()){
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
    
  public boolean ocupada_color(Tablero tablero, int fo, int co){
      Ficha ficha;
      if(tablero.tablero[fo][co].getOcupada()) ficha=tablero.tablero[fo][co].getFicha();
      else return(false);
      if(ficha.color==tablero.turno) return(true);
      else return(false);
   }
  
  public void ofrecer_cambio(Tablero tablero, int fo, int co, int fd, int cd){
      if((fd==0)&&(fo==1)&&(tablero.getTurno()==tablero.tablero[fo][co].getFicha().color)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          try {
            System.out.println("Ha coronado un peon. ¿Que ficha desea obtener?(ej. 1)");
            System.out.println("1.- Reina");
            System.out.println("2.- Torre");
            System.out.println("3.- Alfil");
            System.out.println("4.- Caballo");
            //Leemos el numero
            int eleccion = Integer.parseInt(in.readLine());
            cambio_ficha(tablero,eleccion,fd,cd);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la ficha.");
        } 
          
      }else if((fd==7)&&(fo==6)&&(tablero.getTurno()==tablero.tablero[fo][co].getFicha().color)){
          //FD=ultima fila. FO=penultima. turno=color ficha a mover
          //Esta funcion comprueba que estamos en la ultima fila dependiendo del color.
          // ofrece el cambio y llama a cambio_ficha.
          BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
          try {
            System.out.println("Ha coronado un peon. ¿Que ficha desea obtener?(ej. 1)");
            System.out.println("1.- Reina");
            System.out.println("2.- Torre");
            System.out.println("3.- Alfil");
            System.out.println("4.- Caballo");
            //Leemos el numero
            int eleccion = Integer.parseInt(in.readLine());
            cambio_ficha(tablero,eleccion,fd,cd);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Entrada incorrecta de la ficha.");
        } 
          
      }
  }
    
  public Tablero cambio_ficha(Tablero tablero, int eleccion, int fd, int cd){
     //Esta funcion dependiendo de la ficha que el jugador haya escogido
      //crea la ficha y la mete en su sitio.
     
      switch(eleccion){
          case 1: tablero.tablero[fd][cd].setFicha(new Reina(33,tablero.getTurno()));
                    return(tablero);
          case 2: tablero.tablero[fd][cd].setFicha(new Torre(33,tablero.getTurno()));
                    return(tablero);
          case 3: tablero.tablero[fd][cd].setFicha(new Alfil(33,tablero.getTurno()));
                    return(tablero);
          case 4: tablero.tablero[fd][cd].setFicha(new Caballo(33,tablero.getTurno()));
                    return(tablero);
          default: return(tablero);
      }
  }
}
