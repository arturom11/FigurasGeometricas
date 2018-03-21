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
public class Paralelepipedo extends Figura3D {
    private final double a;
    private final double b;
    private final double c;
    
    public Paralelepipedo(double a,double b,double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    
    @Override
    public double Superficie(){
        return 2*(getA()*getB()+getA()*getC()+getB()*getC());   
    }
    
    @Override
    public double Volumen(){
        return getA()*getB()*getC();
    }
    
    public String MostrarA() {
        return "La arista 1 del paralelepipedo es "+getA();
    }
     
    public String MostrarB() {
        return "La arista 2 del paralelepipedo es "+getB();
    }
    
    public String MostrarC() {
        return "La arista 3 del paralelepipedo es "+getC();
    }   
    /**
     * @return the a
     */
    public double getA() {
        return a;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @return the c
     */
    public double getC() {
        return c;
    }
  }
    