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
    private Posicion2D pos;
    
    public Rectangulo(double base,double altura, Posicion2D pos) throws DimensionIncorrectaException{
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
        this.pos=pos;
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

    /**
     * @return the pos
     */
    public Posicion2D getPos() {
        return pos;
    }
    
 public void MoverArriba(double dist)throws FueraDelPlanoException{
    if (pos.getLimMaxY()<= pos.getY()+dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        pos.setY(pos.getY()+dist);
    }
    }
    
    @Override
    public void MoverAbajo(double dist)throws FueraDelPlanoException{
    if (pos.getLimMinY()>= pos.getY()-dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        pos.setY(pos.getY()-dist);
    }
    }
    
    @Override
    public void MoverDerecha(double dist)throws FueraDelPlanoException{
    if (pos.getLimMaxX()<= pos.getX()+dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        pos.setX(pos.getX()+dist);
    }
    }
    
    @Override
    public void MoverIzquierda(double dist)throws FueraDelPlanoException{
    if (pos.getLimMinX()>= pos.getX()+dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        pos.setX(pos.getX()+dist);
    }
    }
     
    @Override
    public void Mover(Posicion2D nueva)throws FueraDelPlanoException{
        setPos(nueva);
    }
    
     public void setPos(Posicion2D pos) {
        this.pos = pos;
    }
    
    @Override
    public void Mover(double distX,double distY)throws FueraDelPlanoException{
    if ((pos.getY()+distY)>pos.getLimMaxY() ||(pos.getX()+distX)>pos.getLimMaxX()||(pos.getX()+distX)<pos.getLimMinX() ||(pos.getY()+distY)<pos.getLimMinY()  ){
        throw new FueraDelPlanoException("Fuera del plano");
    }
    else{
        pos.setY(pos.getY()+distY);
        pos.setX(pos.getX()+distX);
    }
    }
}

