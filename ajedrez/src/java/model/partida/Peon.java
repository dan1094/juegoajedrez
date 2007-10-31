/*
 * Peon.java
 *
 * Created on 19 de septiembre de 2007, 13:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package model.partida;


/**
 *
 * @author Pablo
 */
public class Peon extends Ficha{
    
    
    /** Creates a new instance of Peon */
    public Peon(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("peon");
    }
    
   public boolean movimiento_correspondiente_ficha(Tablero tablero, 
           int fo,int co,int fd, int cd){
       
       System.out.println("Entra en el peon.");
       //Se debe comprobar que el movimiento es hacia delante. Puede ser sencillo, o doble,
       //si se trata del primer movimiento.
       // Hay que mirar el color del peon, para saber si mueve hacia arriba o hacia
       //abajo, y asi saber si puede ser movimiento simple o doble.
       
       boolean color=tablero.tablero[fo][co].getFicha().getColor();
       if(!color){
           //PEON BLANCO, MUEVE HACIA ARRIBA. Estos mvimientos puedes reducirse
           //ya que unos estan dentro de otros. P ej. el SIMPLE ES IGUAL DESDE
           //EL ORIGEN QUE EN CUALQUIER PARTE DEL TABLERO
           if((fo==6)&&(fd==5)&&(cd==co)){
               //Movimiento simple desde el origen y en vertical. Tiene que estar vacia
               return(!tablero.tablero[fd][cd].getOcupada());
           }else if((fo==6)&&(fd==4)&&(cd==co)){
               //Movimiento doble desde el origen en vertical, tienen que estar las dos vacias
               return((!tablero.tablero[5][cd].getOcupada())&&(!tablero.tablero[4][cd].getOcupada()));
           }else if((fd==fo-1)&&(cd==co-1)){
               //Movimiento diagonal a la izquierda. COMIENDO
               return(tablero.tablero[fd][cd].getOcupada());
           }else if((fd==fo-1)&&(cd==co+1)){
               //Movimiento diagonal a la derecha. COMIENDO
               return(tablero.tablero[fd][cd].getOcupada());
           }else if((fd==fo-1)&&(cd==co)){
               //Movimiento simple desde cualquier parte del tablero
               return(!tablero.tablero[fd][cd].getOcupada());
           }else return(false);
       }else if(color){
           //PEON NEGRO, MUEVE HACIA ABAJO.
           if((fo==1)&&(fd==2)&&(cd==co)){
               //Movimiento simple desde el origen y en vertical. Tiene que estar vacia
               return(!tablero.tablero[fd][cd].getOcupada());
           }else if((fo==1)&&(fd==3)&&(cd==co)){
               //Movimiento doble desde el origen en vertical, tienen que estar las dos vacias
               return((!tablero.tablero[2][cd].getOcupada())&&(!tablero.tablero[3][cd].getOcupada()));
           }else if((fd==fo+1)&&(cd==co-1)){
               //Movimiento diagonal a la izquierda. COMIENDO
               return(tablero.tablero[fd][cd].getOcupada());
           }else if((fd==fo+1)&&(cd==co+1)){
               //Movimiento diagonal a la derecha. COMIENDO
               return(tablero.tablero[fd][cd].getOcupada());
           }else if((fd==fo+1)&&(cd==co)){
               //Movimiento simple desde cualquier parte del tablero
               return(!tablero.tablero[fd][cd].getOcupada());
           }else return(false);
       }else return(false);
    }
    
   public Tablero amenazar_casillas(Tablero tablero, int fila, int columna){
       //Las casillas amenazadas son diferentes, segun el color de la ficha.
       //En el caso de los peones, amenazan las casillas en diagonal. Teniendo
       //en cuenta que pueden estar en la primera/ultima columna.
       if(this.getColor()){ //FICHA NEGRA
           if(super.dentro_amenaza(fila+1,columna+1)) tablero.tablero[fila+1][columna+1].setAmenazada_por_negras(true);
           if(super.dentro_amenaza(fila+1,columna-1)) tablero.tablero[fila+1][columna-1].setAmenazada_por_negras(true);
          
       }else { //FICHA BLANCA
           if(super.dentro_amenaza(fila-1,columna+1)) tablero.tablero[fila-1][columna+1].setAmenazada_por_blancas(true);
           if(super.dentro_amenaza(fila-1,columna-1)) tablero.tablero[fila-1][columna-1].setAmenazada_por_blancas(true);
       }
        
        return(tablero);
    }   
        
    
}

	    
	   