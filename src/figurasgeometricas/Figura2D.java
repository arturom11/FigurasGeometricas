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
public abstract class Figura2D extends Figura implements Movil {
   private Posicion2D pos;
     
   public abstract double Perimetro();
   public abstract boolean Pertenece(Posicion2D pos);
   
public Figura2D(Posicion2D pos){
    this.pos=pos;
}   

public double Distancia(Posicion2D p,Posicion2D q){
        double x1=p.getX();
        double y1=p.getY();
        double x=q.getX();
        double y=q.getY();
        return Math.sqrt(Math.pow((x1-x),2)+Math.pow((y1-y),2));
        }

 
   @Override
    public void MoverArriba(double dist)throws FueraDelPlanoException{
        try{
            Posicion2D nueva=new Posicion2D(getPos().getX(),getPos().getY()+dist);
            VerificarSiEstaDentroDelPlano(nueva);
            setPos(nueva);
        }
        catch(FueraDelPlanoException e){
            System.out.println("No se pudo mover fuera del plano");       
        }
    }
    

   @Override
    public void MoverAbajo(double dist)throws FueraDelPlanoException{
        try{
            Posicion2D nueva=new Posicion2D(getPos().getX(),getPos().getY()-dist);
            VerificarSiEstaDentroDelPlano(nueva);
            setPos(nueva);
        }
        catch(FueraDelPlanoException e){
            System.out.println("No se pudo mover fuera del plano");       
        }
    }
    

   @Override
    public void MoverDerecha(double dist)throws FueraDelPlanoException{
        try{
            Posicion2D nueva=new Posicion2D(getPos().getX()+dist,getPos().getY());
            VerificarSiEstaDentroDelPlano(nueva);
            setPos(nueva);
        }
        catch(FueraDelPlanoException e){
            System.out.println("No se pudo mover fuera del plano");       
        }
    }
    

   @Override
    public void MoverIzquierda(double dist)throws FueraDelPlanoException{
        try{
            Posicion2D nueva=new Posicion2D(getPos().getX()-dist,getPos().getY());
            VerificarSiEstaDentroDelPlano(nueva);
            setPos(nueva);
        }
        catch(FueraDelPlanoException e){
            System.out.println("No se pudo mover fuera del plano");       
        }
    }
     

   @Override
    public void Mover(Posicion2D nueva)throws FueraDelPlanoException{
        try{
            VerificarSiEstaDentroDelPlano(nueva);
            setPos(nueva);
        }
        catch(FueraDelPlanoException e){
            System.out.println("No se pudo mover fuera del plano");       
        }
    }
    

   @Override
    public void Mover(double distX,double distY)throws FueraDelPlanoException{
        try{
            Posicion2D nueva=new Posicion2D(getPos().getX()+distX,getPos().getY()+distY);
            Mover(nueva);
        }    
        catch(FueraDelPlanoException e){
            System.out.println("No se pudo mover fuera del plano");       
        }
    }
    
    protected abstract void CalcularExtremos(Posicion2D nueva)throws FueraDelPlanoException;
    
    private void VerificarSiEstaDentroDelPlano(Posicion2D nueva)throws FueraDelPlanoException{
        CalcularExtremos(nueva);
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

}
