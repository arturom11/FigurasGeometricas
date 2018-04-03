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
public class Triangulo extends Figura2D {
    private Posicion2D A;
    private Posicion2D B;
    private Posicion2D C;
    private final double l_a=Distancia(getA(),getB());
    private final double l_b=Distancia(getB(),getC());
    private final double l_c=Distancia(getC(),getA());
    
    public Triangulo(Posicion2D A,Posicion2D B,Posicion2D C, Posicion2D pos){
        this.A=A;
        this.B=B;
        this.C=C;
    }
    
    @Override
    public double Superficie(){
        return FormuladeHeron(l_a, l_b, l_c);
    }
    

    private double FormuladeHeron(double x,double y,double z){
        double semip=(x+y+z)/2;
        return Math.sqrt(semip*(semip-x)*(semip-y)*(semip-z));
        }
    
    @Override
    public double Perimetro(){
        return l_a+l_b+l_c;
    }

    /**
     * @return the a
     */
    public String MostrarA() {
        return "El lado 1 del triangulo es "+l_a;
    }

    /**
     * @return the b
     */
    public String MostrarB() {
        return "El lado 2 del triangulo es "+l_b;
    }

    /**
     * @return the c
     */
    public String MostrarC() {
        return "El lado 3 del triangulo es "+l_c;
    }
    
    @Override
    public boolean Pertenece(Posicion2D xy){
        boolean Tri=Orientacion(getA(),getB(),getC());
        boolean Tri1=Orientacion(getA(),getB(),xy);
        boolean Tri2=Orientacion(getB(),getC(),xy);
        boolean Tri3=Orientacion(getC(),getA(),xy);
        return Tri&&Tri1&&Tri2&&Tri3;
    }
    
    private Posicion2D Centro()throws FueraDelPlanoException{
        double x1=A.getX();
        double y1=A.getY();
        double x2=B.getX();
        double y2=B.getY();
        double x3=C.getX();
        double y3=C.getY();
        double xc=(x1+x2+x3)/3;
        double yc=(y1+y2+y3)/3;
        return new Posicion2D(xc,yc);
    }
    
    private boolean Orientacion(Posicion2D p,Posicion2D q,Posicion2D r){
        double x1=p.getX();
        double y1=p.getY();
        double x2=q.getX();
        double y2=q.getY();
        double x3=r.getX();
        double y3=r.getY();
        return (x1-x3)*(y2-y3)-(y1-y3)*(x2-x3)>=0;
    }

    /**
     * @return the A
     */
    public Posicion2D getA() {
        return A;
    }

    /**
     * @return the B
     */
    public Posicion2D getB() {
        return B;
    }

    /**
     * @return the C
     */
    public Posicion2D getC() {
        return C;
    }
     public void MoverArriba(double dist)throws FueraDelPlanoException{
    if (A.getLimMaxY()<= A.getY()+dist || B.getLimMaxY()<= B.getY()+dist || C.getLimMaxY()<= C.getY()+dist ){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        A.setY(A.getY()+dist);
        B.setY(B.getY()+dist);
        C.setY(C.getY()+dist);
    }
    }
    
    @Override
    public void MoverAbajo(double dist)throws FueraDelPlanoException{
    if (A.getLimMinY()>= A.getY()-dist || B.getLimMinY()>= B.getY()-dist || C.getLimMinY()>= C.getY()-dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        A.setY(A.getY()-dist);
        B.setY(B.getY()-dist);
        C.setY(C.getY()-dist);
    }
    }
    
    @Override
    public void MoverDerecha(double dist)throws FueraDelPlanoException{
    if (A.getLimMaxX()<= A.getX()+dist || B.getLimMaxX()<= B.getX()+dist || C.getLimMaxX()<= C.getX()+dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        A.setX(A.getX()+dist);
        B.setX(B.getX()+dist);
        C.setX(C.getX()+dist);
    }
    }
    
    @Override
    public void MoverIzquierda(double dist)throws FueraDelPlanoException{
    if (A.getLimMinX()>= A.getX()+dist || B.getLimMinX()>= B.getX()+dist || C.getLimMinX()>= C.getX()+dist){
        throw new FueraDelPlanoException("Fuera del Plano");
    }
    else{
        A.setX(A.getX()+dist);
        B.setX(B.getX()+dist);
        C.setX(C.getX()+dist);
    }
    }

    @Override
    public void Mover(double distX,double distY) throws FueraDelPlanoException{
    if (
        (A.getX()+distX) > A.getLimMaxX() ||
        (B.getX()+distX) > B.getLimMaxX() ||
        (C.getX()+distX) > C.getLimMaxX() ||
        (A.getY()+distY) > A.getLimMaxY() ||
        (B.getY()+distY) > B.getLimMaxY() ||
        (C.getY()+distY) > C.getLimMaxY()){
        throw new FueraDelPlanoException("Fuera del Plano");
    }   
    else{
        A.setX(A.getX()+distX);
        B.setX(B.getX()+distX);
        C.setX(C.getX()+distX);
        A.setY(A.getY()+distY);
        B.setY(B.getY()+distY);
        C.setY(C.getY()+distY);
    }
    }
    
    
    @Override
     public void Mover(Posicion2D pos)throws FueraDelPlanoException{
        double distX=pos.getX()-Centro().getX();
        double distY=pos.getY()-Centro().getY();
        Mover(distX,distY);
    }    

    /**
     * @param A the A to set
     */
    public void setA(Posicion2D A) {
        this.A = A;
    }

    /**
     * @param B the B to set
     */
    public void setB(Posicion2D B) {
        this.B = B;
    }

    /**
     * @param C the C to set
     */
    public void setC(Posicion2D C) {
        this.C = C;
    }

}
