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
        System.out.println(pb(30,40,valoresInteiros));
        int matriz[][] = {{2,3,5},{32,12,34},{0,2,4}};
        int matrizComZerosNaLinha[][] = {{2,3,5},{32,12,34},{0,0,0}};
        int matrizComZerosNaColuna[][] = {{0,3,5},{0,12,34},{0,3,2}};
        int[] v = somaDosValoresDeUmaMatriz(matriz);
        
        for(int i=0; i < v.length; i++){
            System.out.print("[" + v[i] + "]");
        }
        
        System.out.println("matriz sem zeros na linha e coluna " + 
                LinhaOuColunaComSomenteZeros(matriz));
        
        System.out.println("matriz com zeros na linha " + 
                LinhaOuColunaComSomenteZeros(matrizComZerosNaLinha));
        
        System.out.println("matriz com zeros na coluna " + 
                LinhaOuColunaComSomenteZeros(matrizComZerosNaColuna));
    }
    
    public static int[] somaDosValoresDeUmaMatriz(int [][]matriz){        
        int[] somaDeCadaLinha = new int[matriz.length];
        for(int i = 0; i < matriz.length; i++){
            int soma = 0;
            for(int j = 0; j < matriz[i].length; j++){
                soma = soma + matriz[i][j];
            }
            somaDeCadaLinha[i] = soma;
        }
        return somaDeCadaLinha;
    }
    
    public static boolean LinhaOuColunaComSomenteZeros(int [][] matriz){
        // percorre linha
        for(int i = 0; i < matriz.length; i++){
            int soma = 0;
            for(int j = 0; j < matriz[i].length; j++){                
                soma = soma + matriz[i][j];
            }
            if(soma == 0){
                return true;
            }
        }
        // percorre colunas
        for(int i = 0; i < matriz[0].length; i++){
            int soma = 0;
            for(int j = 0; j < matriz.length; j++){                
                soma = soma + matriz[j][i];                                    
            }
            if(soma == 0){
                return true;
            }
        }
        return false;
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
        if(low > high){
            return -1;
        }
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
        if(low > high){
            return -1;
        }
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
