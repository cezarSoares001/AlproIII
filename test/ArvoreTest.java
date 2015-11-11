/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import arvorebinaria.ArvoreBinariaDePesquisa;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class ArvoreTest extends TestCase{
       
    ArvoreBinariaDePesquisa arvore = new ArvoreBinariaDePesquisa();
    
    //Testes com Arvore AVL

    @Test(expected  = IllegalArgumentException.class)
    public void testeChaveDuplicada() {
        try{
            arvore.inserirAvl(10);
            arvore.inserirAvl(20);
            arvore.inserirAvl(10);               
            fail("Chave duplicada");
        } catch (IllegalArgumentException ex){            
        }
    }
    
// @Test um
     public void testeArvoreComApenaUmNodo() {
         arvore.inserirAvl(10);         
         String actual = arvore.printTree();
         String expected = "10 \n";
         Assert.assertEquals(expected, actual);
     }

     // @Test dois
     public void testeArvoreAVLRealizandoBalanceamento(){
         arvore.inserirAvl(10);
         arvore.inserirAvl(20);
         arvore.inserirAvl(30);            
         String actual = arvore.printTree();         
         String expected = "20 \n10 30 \n";
         Assert.assertEquals(expected, actual);
     }
     
     // @Test tres
     public void testeArvoreAVLComDoisNodos(){
         arvore.inserirAvl(10);
         arvore.inserirAvl(20);
         String actual = arvore.printTree();
         String expected = "10 \n20 \n";
         Assert.assertEquals(expected, actual);
     } 
     
     // @Test quatro
     public void testeArvoreAvlComCincoNodos(){
         arvore.inserirAvl(10);
         arvore.inserirAvl(20);
         arvore.inserirAvl(5);
         arvore.inserirAvl(3);         
         arvore.inserirAvl(1);
         String actual = arvore.printTree();
         String expected = "10 \n3 20 \n1 5 \n";
         Assert.assertEquals(expected, actual);
     }
     
     // @Test cinco
     public void testeArvoreAvlVazia(){
         String actual = arvore.printTree();
         String expected = "";
         Assert.assertEquals(expected, actual);
     }
     
     // Testes com arvore não balanceada
     
     public void testeArvoreComRaizUm(){
         arvore.inserirNaoAvl(1);
         arvore.inserirNaoAvl(10);
         arvore.inserirNaoAvl(5);
         arvore.inserirNaoAvl(50);
         
     } 
}
