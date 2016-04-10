/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class Matrizes {
    public static void main(String[] args) {
        somarMatriz();
        multiplicarMatriz();
    }
    
    public static void somarMatriz(){
        int[][] matriz = new int[5][6];
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i + j;
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    
    public static void multiplicarMatriz(){
        int[][] m1 = {{1,2},{3,4}};
        int[][] m2 = {{-1,3},{4,2}};
        int[][] r = new int [m1.length][m2[0].length];
        int soma = 0;
        if(m1.length != m2[0].length){
            throw new IllegalArgumentException("Erro");
        }        
        for(int i = 0; i < m1.length; i++) {
            for(int j = 0; j < m2[0].length; j++){
                soma = 0;
                for(int k = 0; k < m1[0].length; k++){
                    soma = soma + m1[i][k] * m2[k][i];
                }
                r[i][j] = soma;
                System.out.print(r[i][j] + " | ");
            }
            System.out.println("");
        }        
    }
    
    

}
