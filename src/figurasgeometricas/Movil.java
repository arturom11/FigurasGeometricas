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
    public void MoverArriba(double dist)throws FueraDelPlanoException;
    public void MoverAbajo(double dist)throws FueraDelPlanoException;
    public void MoverDerecha(double dist)throws FueraDelPlanoException;
    public void MoverIzquierda(double dist)throws FueraDelPlanoException;
    public void Mover(double distX,double distY)throws FueraDelPlanoException;
    public void Mover(Posicion2D pos)throws FueraDelPlanoException;
}
