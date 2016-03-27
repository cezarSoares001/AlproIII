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
//        bubbleSort(lista);                
//        bubbleSortVersaoMelhorada(lista);
//        insertionSort(lista);
        quickSort(lista, 0, lista.length-1);
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
    
    /**
     * pior caso: (vetor já ordenado) O(n²)
     * melhor caso: O(n x log n)
     * caso médio: O(n X log n)
     * este algoritmo não é eficiente quando o vetor está ordenando
     * pois ele sempre pega um pivô da ponta do vetor, então a partição não
     * funcionará com eficiencia 
     * @param v
     * @param low
     * @param high 
     */
    public static void quickSort(int[] v, int low, int high) {        
        if((high - low) > 0) {
            int pivot = partition(v, low, high);
            quickSort(v, low, pivot-1);
            quickSort(v, pivot+1, high);
        }       
    }
    
    private static int partition(int[] v, int low, int high) {
        int firsthigh = low;
        int pivot = high;
        for(int i = low; i < high; i++){
            if(v[i] < v[pivot]){
                troca(v, i, firsthigh);
                firsthigh++;
            }                        
        }
        troca(v, pivot, firsthigh);
        return firsthigh;
    }
    
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
