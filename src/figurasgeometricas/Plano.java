/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

import java.util.ArrayList;


/**
 *
 * @author utku31
 */
public class Plano {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    ArrayList<ArrayList> figuras = new ArrayList<>();
    ArrayList<Circulo> circulos = new ArrayList<>();
    figuras.add(circulos);
    ArrayList<Rectangulo> rectangulos = new ArrayList<>();
    figuras.add(rectangulos);
   
    try {
        rectangulos.add(new Rectangulo(3,1,new Posicion2D(1,1)));
        } 
    catch (DimensionIncorrectaException | FueraDelPlanoException ex) {
        }
    try {
        rectangulos.add(new Rectangulo(4,2,new Posicion2D(0,0)));
    } 
    catch (DimensionIncorrectaException | FueraDelPlanoException ex) {
    }
    if (Solapamiento(rectangulos.get(0),rectangulos.get(1))){
        System.out.println("Se solapan");
    }
    else{
        System.out.println("No se solapan");
    } 
    try {
    rectangulos.get(0).Mover(1010,2);
    }
    catch (FueraDelPlanoException ex){
        System.out.println("No se puede mover Fuera del Plano");
    }
}
  
 static boolean Solapamiento(Circulo cir1, Circulo cir2){
    return cir1.getPos().Distancia2D(cir2.getPos()) <= (cir1.getRadio()+cir2.getRadio());     
 }
 static boolean Solapamiento(Circulo cir, Rectangulo rect){
    if (cir.getPos().Distancia2D(rect.getPos())> (cir.getRadio()+rect.getBase()*0.5)){
        return false; 
    }
    else if (cir.getPos().Distancia2D(rect.getPos()) < (cir.getRadio()+rect.getAltura()*0.5)){
        return true;  
    }
    else{
        double ang=Math.asin(Math.abs(cir.getPos().getY()-rect.getPos().getY())/cir.getPos().Distancia2D(rect.getPos()));
        double hip=rect.getBase()*0.5/Math.cos(ang);
        return cir.getPos().Distancia2D(rect.getPos())< hip+cir.getRadio();
    }
 }
  static boolean Solapamiento(Rectangulo rect1,Rectangulo rect2){
    boolean a=Math.abs(rect1.getPos().getX()-rect2.getPos().getX())<= 0.5*(rect1.getBase()+rect2.getBase());
    boolean b=Math.abs(rect1.getPos().getY()-rect2.getPos().getY())<= 0.5*(rect1.getAltura()+rect2.getAltura());
    return a && b;     
 }
}

