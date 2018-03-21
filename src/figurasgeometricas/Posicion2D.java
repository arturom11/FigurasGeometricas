/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

/**
 *
 * @author Alumno
 */
public class Posicion2D {
    private double x;
    private double y;

    public Posicion2D (double x,double y){
        this.x=x;
        this.y=y;
    }
    
    public double Distancia2D(Posicion2D pos){
        double x1=pos.getX();
        double y1=pos.getY();
        return Math.sqrt(Math.pow((x1-getX()),2)+Math.pow((y1-getY()),2));
    }
    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    

    
}
