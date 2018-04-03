/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figurasgeometricas;

/**
 *
 * @author Alumno
 */
public interface Movil {
    public void MoverArriba(double dist);
    public void MoverAbajo(double dist);
    public void MoverDerecha(double dist);
    public void MoverIzquierda(double dist);
    public void Mover(double distX,double distY);
    public void Mover(Posicion2D pos)throws FueraDelPlanoException;
}
