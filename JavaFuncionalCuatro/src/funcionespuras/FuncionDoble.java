/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionespuras;

/**
 *
 * @author sdelaot
 * @param <T> lo devuelto
 * @param <U> primer argumento
 * @param <V> segundo argumento
 */
public interface FuncionDoble<T, U, V> {
    T operar(U x, V y);
}
