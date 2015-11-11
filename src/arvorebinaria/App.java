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
        arvore.inserirAvl(10);
        arvore.inserirAvl(20);
        arvore.inserirAvl(30);
//        arvore.inserirAvl(3);
//        arvore.inserirAvl(21);
//        arvore.inserirAvl(14);
//        arvore.inserirAvl(57);
//        arvore.inserirAvl(2);        
//        System.out.println(arvore.toString());
        System.out.println(arvore.printTree());
//        System.out.println(arvore.getAllElements());
//        System.out.println(arvore.getPathSizeTo(1));
//        System.out.println(arvore.consultar(21));
//      
    }    
}
