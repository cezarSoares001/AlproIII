/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

/**
 *
 * @author Lucas
 */
public class Nodo<T> {

    public T chave;

    public int altura;

    public Nodo<T> esquerdo;
    public Nodo<T> direito;

    public Nodo(T chave) {
        this.chave = chave;
        altura = 0;
        esquerdo = direito = null;
    }

}
