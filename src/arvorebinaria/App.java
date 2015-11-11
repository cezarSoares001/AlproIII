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
public class App {
    
    public static void main(String[] args) {
    ArvoreBinariaDePesquisa arvore = new ArvoreBinariaDePesquisa();
//         arvore.inseriNaoAvl(1);
         arvore.inserirNaoAvl(1);
         arvore.inserirNaoAvl(5);
         arvore.inserirNaoAvl(50);
         arvore.inserirNaoAvl(51);
         
      
//        System.out.println(arvore.toString());
        System.out.println(arvore.printTree());
//        System.out.println(arvore.getAllElements());
//        System.out.println(arvore.getPathSizeTo(1));
//        System.out.println(arvore.consultar(21));
//      
    }    
}
