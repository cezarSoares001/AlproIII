/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciciosDeProva;

/**
 *
 * @author Lucas
 */
public class P1 {
    public static void main(String[] args) {        
        int valoresInteiros[] = {1,2,4,7,12,34,76};
        System.out.println(pb(4,7,valoresInteiros));
    }
    
    
    
    /**
     * Questão 5 da p1 de alpro
     * @param val1
     * @param val2
     * @param v
     * @return 
     */
    public static String pb(int val1, int val2, int[] v){
        int low = 0;
        int high = v.length-1;
        int p = low - ((high - low)/2);
        int posicao = -1; int valor = -1;
        posicao = pbPosicao(low, high, val1, v);
        valor = pbValor(low, high, val2, v);
        return "posicao do val1: " + posicao + "valor do val2: " + valor; 
    }
    
    private static int pbPosicao(int low, int high, int val1, int[] v){
        int p = low + ((high - low) /2);
        if(val1 < v[p]){
            return pbPosicao(low, p - 1, val1, v);
        }
        else if(val1 > v[p]){
            return pbPosicao(p + 1, high, val1, v);
        }
        else {
            return p;
        } 
    }

    private static int pbValor(int low, int high, int val2, int[] v) {
        int p = low + ((high - low) /2);
        if(val2 < v[p]){
            return pbPosicao(low, p - 1, val2, v);
        }
        else if(val2 > v[p]){
            return pbPosicao(p + 1, high, val2, v);
        }
        else {
            return v[p];
        } 
    }
}
