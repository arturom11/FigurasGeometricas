/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

/**
 *
 * @author utku31
 */
public abstract class Figura2D extends Figura implements Movil {
    
   public abstract double Perimetro();
   public abstract boolean Pertenece(Posicion2D pos);
   
public double Distancia(Posicion2D p,Posicion2D q){
        double x1=p.getX();
        double y1=p.getY();
        double x=q.getX();
        double y=q.getY();
        return Math.sqrt(Math.pow((x1-x),2)+Math.pow((y1-y),2));
        }

}
