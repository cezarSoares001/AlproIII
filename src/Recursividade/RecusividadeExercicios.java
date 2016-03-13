/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividade;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class RecusividadeExercicios {

    public static void main(String[] args) {
        System.out.println("somatorio de 5: " + somatorioDeN(5));
        System.out.println("de 1 a 5: " + somatorioDeKaJ(1,5));
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(20);
        lista.add(30);
        lista.add(10);
        System.out.println("somatorio da lista: " + somatorioDeUmArrayList(lista));
        System.out.println("Maior valor da lista: " + findBiggest(lista));
    }

    public static int somatorioDeN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("valor não pode ser menor que zero");
        }
        return somatorioDeN0(n);
    }

    private static int somatorioDeN0(int n) {
//        return (n == 0) ? 0 : somatorioDeN0(n-1) + n;       
        if (n == 0) {
            return 0;
        }
        return somatorioDeN0(n - 1) + n;
    }

    public static int somatorioDeKaJ(int k, int j) {
        if (k > j) {
            throw new IllegalArgumentException("valor de k não pode ser maior que j");
        }
        if (k == j) {
            return 0;
        }
        return somatorioDeKaJ0(k, j);
    }

    private static int somatorioDeKaJ0(int k, int j) {
        if (k == j) {
            return j;
        }
        return somatorioDeKaJ0(k + 1, j) + k;
    }

    public static int somatorioDeUmArrayList(ArrayList<Integer> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("lista não pode ser null");
        }
        if (lista.isEmpty()) {
            return 0;
        }
        return somatorioDeUmArrayList0(lista, 0);
    }

    private static int somatorioDeUmArrayList0(ArrayList<Integer> lista, int i) {
        if (i == lista.size()) {
            return 0;
        }
        return somatorioDeUmArrayList0(lista, i + 1) + lista.get(i);
    }

    public static int findBiggest(ArrayList<Integer> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("lista não pode ser null");
        }
        if (lista.isEmpty()) {
            return 0;
        }
        return findBiggest0(lista, 0, 0);
    }

    private static int findBiggest0(ArrayList<Integer> lista, int i, int biggest) {
        if(i < lista.size()){
            if (lista.get(i) > lista.get(biggest)) {
                // caso o valor na posição "i" seja maior que da posição "biggest"
                return findBiggest0(lista, i + 1, i);
            }        
            return findBiggest0(lista, i + 1, biggest);
        }
        return lista.get(biggest);
    }

    public static boolean isPal(String s) {
        if (s == null) {
            throw new IllegalArgumentException("String null");
        }
        return isPal0(s);
    }

    private static boolean isPal0(String palavraReduzida) {
        if (palavraReduzida.length() <= 1) {
            return true;
        }
        String ultimaLetra = palavraReduzida.substring(palavraReduzida.length() - 1, palavraReduzida.length());
        String primeiraLetra = palavraReduzida.substring(0, 1);
        
        
        if (!(primeiraLetra.equalsIgnoreCase(ultimaLetra))) {
            return false;
        }
        palavraReduzida = palavraReduzida.substring(1, palavraReduzida.length()-1);
        return isPal0(palavraReduzida);

    }
}
