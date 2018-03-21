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
public class Esfera extends Figura3D {
    private final double radio;
    
    public Esfera(double radio){
        this.radio=radio;
    }
    
    @Override
    public double Superficie(){
        return 4*Math.PI*getRadio()*getRadio();   
    }
    
    @Override
    public double Volumen(){
        return 4*Math.PI*getRadio()*getRadio()*getRadio()/3;
    }
    
    public String MostrarRadio() {
        return "El radio de la esfera es "+getRadio();
    } 

    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

  }
    