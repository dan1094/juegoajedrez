/*
 * Rey.java
 *
 * Created on 19 de septiembre de 2007, 13:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Pablo
 */
public class Rey extends Ficha{
    
    protected boolean puede_enrocar;
    
    /** Creates a new instance of Rey */
    public Rey(int id_ficha, boolean color){
        super(id_ficha,color);
        this.setTipo_ficha("rey");
        this.puede_enrocar=true;
  
        
    }
    
    public boolean getPuede_enrocar(){
        return(this.puede_enrocar);
    }
    public void setPuede_enrocar(boolean enrocar){
        this.puede_enrocar=enrocar;
    }
  
    /**Funcion que comprueba que el rey puede mover a la casilla destino. ESto se 
     *debe a que puede estar amenazada por una ficha del oponente*/
    public boolean esta_amenazada(Tablero tablero, int fd, int cd){
        //Tengo que tener en cuenta el color de la ficha.
        if(this.getColor()) return(tablero.tablero[fd][cd].getAmenazada_por_blancas());
        else return(tablero.tablero[fd][cd].getAmenazada_por_negras());
        
    }
    
    
    
    public boolean movimiento_correspondiente_ficha(Tablero tablero,int fo,int co,int fd,int cd){
       //Hay que comprobar que mueve solo de uno en uno y que la posición no esta amenazada.
       boolean destino_jaque=false,origen_jaque=false,camino_libre=true, no_ha_movido=true;
       
       if((fd==fo)&&(co==cd)){
           //ORIGEN=DESTINO
           return(false);
       }else if(((fd==fo-1)||(fd==fo)||(fd==fo+1))&&((cd==co-1)||(cd==co)||(cd==co+1))){
                //MOVIMIENTO NORMAL
                destino_jaque=esta_amenazada(tablero,fd,cd);
                return(!destino_jaque);
             }else if(((fo==7)&&(co==4)&&(fd==7)&&(cd==6))||((fo==0)&&(co==4)&&(fd==0)&&(cd==6))){
                    //Enroque Corto de BLANCAS Y NEGRAS. Comprueba que el origen no esta en jaque, comprueba
                    //que el destino tampoco esta en jaque. Comprueba que no hay fichas impidiendo el paso.
                    //Y comprueba que el rey puede hacer enroque(no ha movido anteriormente)
                    origen_jaque=esta_amenazada(tablero,fo,co);
                    destino_jaque=esta_amenazada(tablero,fd,cd);
                    no_ha_movido=this.getPuede_enrocar();
                    camino_libre=camino_libre(tablero,fo,co,fd,cd,false); //false=enroque_corto
                    if((!origen_jaque)&&(!destino_jaque)&&(no_ha_movido)&&(camino_libre)) {
                        //condiciones necesarias para hacer ENROQUE CORTO
                        enroque(tablero,fo,co,fd,cd,false);
                        return(true);
                    }else return(false); //no se dan las condiciones, no puede mover asi.
             }else if(((fo==7)&&(co==4)&&(fd==7)&&(cd==2))||((fo==0)&&(co==4)&&(fd==0)&&(cd==2))){
                    //Enroque largo de BLANCAS Y NEGRAS
                    
                    enroque(tablero,fo,co,fd,cd,true);
                    return(true);
             }else return(false);
    }
    
    /**Esta funcion lo que hace es: una vez llamada (situacion correcta de enroque) mueve la torre
     *al sitio correspondiete. Por el contrario, el rey, se mueve posteriormente, como si hubiese sido
     *un movimiento normal. Si el enroque es largo(true), si es corto(false)*/
    public void enroque(Tablero tablero, int fo, int co, int fd, int cd, boolean tipo_enroque){
           if(tipo_enroque) {
                    tablero.tablero[fo][3].setFicha(tablero.tablero[fo][0].getFicha());
                    tablero.tablero[fo][0].setFicha(null);
               
           }else {
                    //Colocamos la torre correspondiente al lado del rey.
                    tablero.tablero[fo][5].setFicha(tablero.tablero[fo][7].getFicha());
                    tablero.tablero[fo][7].setFicha(null);
           }
    }
    
    /**Comprueba que el camino entre el rey y el enroque esta libre, de forma que no haya fichas
     *impidiendo el paso*/
    public boolean camino_libre(Tablero tablero, int fo, int co, int fd, int cd, boolean tipo_enroque){
        //Si tipo_enroque => false=enroque corto, true=enroque largo
        if(tipo_enroque) { return((!tablero.tablero[fo][1].getOcupada())&&(!tablero.tablero[fo][2].getOcupada())&&(!tablero.tablero[fo][3].getOcupada()));
            }else return((!tablero.tablero[fo][5].getOcupada())&&(!tablero.tablero[fo][6].getOcupada()));
    }
    
   public Tablero amenazar_casillas(Tablero tablero, int fila, int columna){
        if(this.getColor()){
            if(super.dentro(fila-1,columna-1)) tablero.tablero[fila-1][columna-1].setAmenazada_por_negras(true);
            if(super.dentro(fila-1,columna)) tablero.tablero[fila-1][columna].setAmenazada_por_negras(true);
            if(super.dentro(fila-1,columna+1)) tablero.tablero[fila-1][columna+1].setAmenazada_por_negras(true);
            if(super.dentro(fila,columna-1)) tablero.tablero[fila][columna-1].setAmenazada_por_negras(true);
            if(super.dentro(fila,columna+1)) tablero.tablero[fila][columna+1].setAmenazada_por_negras(true);
            if(super.dentro(fila+1,columna-1)) tablero.tablero[fila+1][columna-1].setAmenazada_por_negras(true);
            if(super.dentro(fila+1,columna)) tablero.tablero[fila+1][columna].setAmenazada_por_negras(true);
            if(super.dentro(fila+1,columna+1)) tablero.tablero[fila+1][columna+1].setAmenazada_por_negras(true);
            
        }else{
             if(super.dentro(fila-1,columna-1)) tablero.tablero[fila-1][columna-1].setAmenazada_por_blancas(true);
            if(super.dentro(fila-1,columna)) tablero.tablero[fila-1][columna].setAmenazada_por_blancas(true);
            if(super.dentro(fila-1,columna+1)) tablero.tablero[fila-1][columna+1].setAmenazada_por_blancas(true);
            if(super.dentro(fila,columna-1)) tablero.tablero[fila][columna-1].setAmenazada_por_blancas(true);
            if(super.dentro(fila,columna+1)) tablero.tablero[fila][columna+1].setAmenazada_por_blancas(true);
            if(super.dentro(fila+1,columna-1)) tablero.tablero[fila+1][columna-1].setAmenazada_por_blancas(true);
            if(super.dentro(fila+1,columna)) tablero.tablero[fila+1][columna].setAmenazada_por_blancas(true);
            if(super.dentro(fila+1,columna+1)) tablero.tablero[fila+1][columna+1].setAmenazada_por_blancas(true);
        }
        
        return(tablero);
    }   
    
}
