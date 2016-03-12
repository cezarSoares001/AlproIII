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

    public int chave;

    public int altura;

    public Nodo esquerdo;
    public Nodo direito;

    public Nodo(int chave) {
        this.chave = chave;
        altura = 0;
        esquerdo = direito = null;
    }

}
