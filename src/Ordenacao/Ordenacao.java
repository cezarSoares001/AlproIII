/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenacao;

/**
 *
 * @author Lucas
 */
public class Ordenacao {
    
    public static void main(String[] args) {
        int[] lista = {2,5,3,6,1,4,6};        
        bubbleSort(lista);                
        bubbleSortVersaoMelhorada(lista);
        insertionSort(lista);
        toString(lista);
    }
    
    /**
     * Complexidade sempre vai ser O(n²)
     * @param lista 
     */
    public static void bubbleSort(int [] lista){
        for(int i = 0; i < lista.length; i++) {
            for(int j = 0; j < lista.length-1; j++) {
                if(lista[j] > lista[j + 1]){
                    troca(lista, j, j+1);
                }
            }
        }        
    }
    
    /**     
     * Versão melhorada do BubbleSort 
     * pior caso O(n²)
     * melhor caso O(n log n)     
     * @param lista 
     */
    public static void bubbleSortVersaoMelhorada(int [] lista){
        boolean trocou = true;
        while(trocou){
            trocou = false;
            for(int i=0; i < lista.length-1; i++){
                if(lista[i] > lista[i+1]){
                    troca(lista, i, i+1);
                    trocou = true;
                }
            }
        }
    }
    
    /**
     * Pior caso O(n²)     
     * melhor caso O(n)
     * @param lista 
     */
    public static void insertionSort(int [] lista){
        int i, chave;
        for(int j = 1; j < lista.length; j++) {
            chave = lista[j];
            i = j - 1;
            while(i >= 0 && lista[i] > chave) {
                lista[i+1] = lista[i];
                i--;
            }
            lista[i+1] = chave;
        }
    }
    
    public static void 
    
    private static void troca(int[] lista, int j, int i) {
        int aux = lista[j];
        lista[j] = lista[i];
        lista[i] = aux;
    }
    
    public static void toString(int [] lista) {        
        for(int i = 0; i < lista.length; i++){
            System.out.print(lista[i] + ",");
        }        
    }
}
