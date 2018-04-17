/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;
import java.util.*;
/**
 *
 * @author utku31
 */
public class Plano {
    ArrayList<Figura2D> figuras;
    ArrayList<Circulo> circulos;
    ArrayList<Rectangulo> rectangulos;
    
    public Plano(){
        figuras=new ArrayList<>();
        circulos=new ArrayList<>();
        rectangulos=new ArrayList<>();
        
        IniciarPlano();
    }
    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
  
    Plano plano=new Plano();
    plano.ListarPorPerimetro();
    plano.ListarPorSuperficie();
    
}  

public void IniciarPlano(){
    try {
        Rectangulo rect=new Rectangulo(3,1,new Posicion2D(1,1),001);
        figuras.add(rect);
        rectangulos.add(rect);
        } 
    catch (DimensionIncorrectaException | FueraDelPlanoException ex) {
        }
    try {
        Rectangulo rect=new Rectangulo(4,2,new Posicion2D(0,0),002);
        figuras.add(rect);
        rectangulos.add(rect);
    } 
    catch (DimensionIncorrectaException | FueraDelPlanoException ex) {
    }
    if (Solapamiento(rectangulos.get(0),rectangulos.get(1))){
        System.out.println("Se solapan");
    }
    else{
        System.out.println("No se solapan");
    } 
    try{
        rectangulos.get(0).Mover(997.5,2);
    }
    catch(FueraDelPlanoException e){
    }
    try{
        Circulo cir =new Circulo(2,new Posicion2D(2,1),003);
        figuras.add(cir);
        circulos.add(cir);
    }
    catch(FueraDelPlanoException | DimensionIncorrectaException e){
        System.out.println("No se pudo crear algo fuera del plano");
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

    private void ListarPorPerimetro(){
        List PorPerimetros=OrdenarPorPerimetro();
        for(Object f: PorPerimetros){
            System.out.println(f);
        }
    }  
  
    private void ListarPorSuperficie(){
        List PorSuperficies=OrdenarPorSuperficie();
        for(Object f: PorSuperficies){
            System.out.println(f);
        }
    } 
       /*FALTA DAR FORMATO A STRINICIAL*/ 
    private List OrdenarPorPerimetro(){
        TreeMap<String,Figura2D> mapa =new TreeMap<>();
        
        for(Figura2D f: figuras){
            String strinicial=String.format("|%020f|", f.Perimetro());
            strinicial=strinicial+Integer.toString(f.getNroOrden());
            mapa.put(strinicial,f); 
        }
        return new ArrayList<>(mapa.values());
    }
  
    private List OrdenarPorSuperficie(){
        TreeMap<String,Figura2D> mapa =new TreeMap<>();
        
        for(Figura2D f: figuras){
            String strinicial=String.format("|%020f|", f.Superficie());
            strinicial=strinicial+Integer.toString(f.getNroOrden());
            mapa.put(strinicial,f); 
        }

        return new ArrayList<>(mapa.values());
    }
}

