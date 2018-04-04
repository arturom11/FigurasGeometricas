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

 
    public void MoverArriba(double dist)throws FueraDelPlanoException{
        Posicion2D nueva=new Posicion2D(getPos().getX(),getPos().getY()+dist);
        VerificarSiEstaDentroDelPlano(nueva);
        setPos(nueva);
    }
    

    public void MoverAbajo(double dist)throws FueraDelPlanoException{
        Posicion2D nueva=new Posicion2D(getPos().getX(),getPos().getY()-dist);
        VerificarSiEstaDentroDelPlano(nueva);
        setPos(nueva);
    }
    

    public void MoverDerecha(double dist)throws FueraDelPlanoException{
        Posicion2D nueva=new Posicion2D(getPos().getX()+dist,getPos().getY());
        VerificarSiEstaDentroDelPlano(nueva);
        setPos(nueva);
    }
    

    public void MoverIzquierda(double dist)throws FueraDelPlanoException{
        Posicion2D nueva=new Posicion2D(getPos().getX()-dist,getPos().getY());
        VerificarSiEstaDentroDelPlano(nueva);
        setPos(nueva);
    }
     

    public void Mover(Posicion2D nueva)throws FueraDelPlanoException{
        VerificarSiEstaDentroDelPlano(nueva);
        setPos(nueva);
    }
    

    public void Mover(double distX,double distY)throws FueraDelPlanoException{
        Posicion2D nueva=new Posicion2D(getPos().getX()+distX,getPos().getY()+distY);
        Mover(nueva);
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
