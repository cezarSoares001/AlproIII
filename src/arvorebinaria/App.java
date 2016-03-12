/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvorebinaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Lucas
 */
public class App {

    public static void main(String[] args) {
        ArvoreBinariaDePesquisa arvore = new ArvoreBinariaDePesquisa();
        try {
            BufferedWriter str = new BufferedWriter(
                    new FileWriter(
                            "C:\\Users\\Lucas\\Documents\\NetBeansProjects\\ArvoreBinaria\\arvoreNaoAvlBinaria.csv"
                    )
            );
            str.write("número de nodos;total de operações\n");
            for (int i = 1; i < 1001; i++) {
                int cont = 0;
                for (int j = 0; j < i; j++) {
                    Random numeros = new Random();
                    int num = numeros.nextInt();
                    arvore.inserirNaoAvl(num);
                }
                arvore.printTree();
                cont = arvore.contador;
                str.write(" " + i + "; " + cont + "\n");
            }

            str.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
