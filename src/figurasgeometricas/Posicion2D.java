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
    private static final double limMaxX=1000;
    private static final double limMaxY=1000;
    private static final double limMinY=-1000;
    private static final double limMinX=-1000;
    private double x;
    private double y;

    public Posicion2D (double x,double y) throws FueraDelPlanoException{
        if (x<=limMaxX && x>=limMinX){
            this.x=x;
            }
        else{
            throw new FueraDelPlanoException("Fuera del plano en el eje X");
        }
        if (y<=limMaxY && x>=limMinY){
            this.y=y;
            }
        else{
            throw new FueraDelPlanoException("Fuera del plano en el eje Y");
        }    
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

    /**
     * @return the limMaxX
     */
    public static double getLimMaxX() {
        return limMaxX;
    }

    /**
     * @return the limMaxY
     */
    public static double getLimMaxY() {
        return limMaxY;
    }

    /**
     * @return the limMinY
     */
    public static double getLimMinY() {
        return limMinY;
    }

    /**
     * @return the limMinX
     */
    public static double getLimMinX() {
        return limMinX;
    }

}
