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
public class Cilindro extends Figura3D {
    private final double radio;
    private final double altura;
    
    public Cilindro(double radio,double altura){
        this.radio=radio;
        this.altura=altura;
    }
    
    @Override
    public double Superficie(){
        return 2*Math.PI*getRadio()*(getRadio()+getAltura());   
    }
    
    @Override
    public double Volumen(){
        return 2*Math.PI*getRadio()*getRadio()*getAltura();
    }
    
    public String MostrarRadio() {
        return "El radio del cilindro es "+getRadio();
    }
     
    public String MostrarAltura() {
        return "La altura del cilindro es "+getAltura();
    } 

    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

  }
    