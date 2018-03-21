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
public class Circulo extends Figura2D {
    private final double radio;
    private Posicion2D pos;

    
    public Circulo(double radio, Posicion2D pos) throws DimensionIncorrectaException {
        if (radio>=0){
            this.radio=radio;
        }
        else{
            throw new DimensionIncorrectaException("Radio Incorrecto");
        }
        this.pos=pos;
    }
    
      public String MostrarRadio() {
        return "El radio del circulo es "+getRadio();
    }
    
    @Override
    public double Superficie(){
        return Math.PI*getRadio()*getRadio();  
    }
    
    @Override
    public double Perimetro(){
        return Math.PI*2*getRadio();
    }
    
    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }
    
    /**
     * @return the pos
     */
    public Posicion2D getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(Posicion2D pos) {
        this.pos = pos;
    }
    
    @Override
    public boolean Pertenece(Posicion2D xy){
        double x1=xy.getX();
        double y1=xy.getY();
        double x=pos.getX();
        double y=pos.getY();
        return Math.pow((x1-x),2)+Math.pow((y1-y),2) <= Math.pow(getRadio(),2);
    }
}
