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
public class DimensionIncorrectaException extends Exception {
    

    /**
     * Creates a new instance of <code>DimensionIncorrecta</code> without detail
     * message.
     */
    public DimensionIncorrectaException() {
    }

    /**
     * Constructs an instance of <code>DimensionIncorrecta</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public DimensionIncorrectaException(String msg) {
        super(msg);
    }
}
