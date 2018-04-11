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
    

    
    public Circulo(double radio, Posicion2D pos, int nroOrden) throws DimensionIncorrectaException, FueraDelPlanoException{
        super(pos,nroOrden);
        
        if (radio>=0){
            this.radio=radio;
        }
        else{
            throw new DimensionIncorrectaException("Radio Incorrecto");
        }
        CalcularExtremos(pos);
        
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
    
    
    @Override
    public boolean Pertenece(Posicion2D xy){
        double x1=xy.getX();
        double y1=xy.getY();
        double x=getPos().getX();
        double y=getPos().getY();
        return Math.pow((x1-x),2)+Math.pow((y1-y),2) <= Math.pow(getRadio(),2);
    }
   
    @Override
    protected void CalcularExtremos(Posicion2D nueva)throws FueraDelPlanoException{
        Posicion2D Arriba=new Posicion2D(nueva.getX(),nueva.getY()+radio);
        Posicion2D Abajo=new Posicion2D(nueva.getX(),nueva.getY()-radio);
        Posicion2D Derecha=new Posicion2D(nueva.getX()+radio,nueva.getY());
        Posicion2D Izquierda=new Posicion2D(nueva.getX()-radio,nueva.getY());
    }
       
    }
