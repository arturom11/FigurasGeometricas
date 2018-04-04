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
public class Rectangulo extends Figura2D {
    private final double base;
    private final double altura;
    
    public Rectangulo(double base,double altura, Posicion2D pos) throws DimensionIncorrectaException{
        super(pos);
        if (base>=0){
            this.base=base;
        }
        else{
            throw new DimensionIncorrectaException("Base incorrecta");
        }
        if (altura>=0){
            this.altura=altura;
        }
        else{
            throw new DimensionIncorrectaException("Altura incorrecta");
        }
        
    }
    
    @Override
    public double Superficie(){
        return getBase()*getAltura();   
    }
    
    @Override
    public double Perimetro(){
        return 2*getBase()+2*getAltura();
    }
    
    public String MostrarBase() {
        return "La base del resctangulo es "+getBase();
    }
        
    public String MostrarAltura() {
        return "La altura del rectangulo es "+getAltura();
    }

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }
        
    @Override
    public boolean Pertenece(Posicion2D xy){
        double x1=xy.getX();
        double y1=xy.getY();
        double x=getPos().getX();
        double y=getPos().getY();
        return ((x1<=x+(getBase()/2)||x1>=x-(getBase()/2))&&(y1<=y+(getAltura()/2)||y1>=y-(getAltura()/2)));
    }

        
        @Override
    protected void CalcularExtremos(Posicion2D nueva)throws FueraDelPlanoException{
        Posicion2D Arizq=new Posicion2D(nueva.getX()-base/2,nueva.getY()+altura/2);
        Posicion2D Arder=new Posicion2D(nueva.getX()+base/2,nueva.getY()+altura/2);
        Posicion2D Abizq=new Posicion2D(nueva.getX()-base/2,nueva.getY()-altura/2);
        Posicion2D Abder=new Posicion2D(nueva.getX()+base/2,nueva.getY()-altura/2);
    }

    }
