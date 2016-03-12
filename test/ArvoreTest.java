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
         String expected = "   10\n";
         Assert.assertEquals(expected, actual);
     }

     // @Test dois
     public void testeArvoreAVLRealizandoBalanceamento(){
         arvore.inserirAvl(10);
         arvore.inserirAvl(20);
         arvore.inserirAvl(30);            
         String actual = arvore.printTree();         
         String expected = "   |-20-|\n   10  30\n";
         Assert.assertEquals(expected, actual);
     }
     
     // @Test tres
     public void testeArvoreAVLComDoisNodos(){
         arvore.inserirAvl(10);
         arvore.inserirAvl(20);
         String actual = arvore.printTree();
         String expected = "   10-|\n     20\n";
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
         String expected = "   |--10-|\n  |3|   20\n  1 5\n";
         Assert.assertEquals(expected, actual);
     }
     
     // @Test cinco
     public void testeArvoreAvlVazia(){
         String actual = arvore.printTree();
         String expected = "\n";
         Assert.assertEquals(expected, actual);
     }
     
     // Testes com arvore não balanceada
     
     public void testeArvoreComRaizUm(){
         arvore.inserirNaoAvl(1);
         arvore.inserirNaoAvl(10);
         arvore.inserirNaoAvl(5);
         arvore.inserirNaoAvl(50);
         String actual = arvore.printTree();
         String expected = "  1--|\n   |-10-|\n   5   50\n";
         Assert.assertEquals(expected, actual);
     } 
     
     public void testeArvoreComRaizMaiorQueTodosFilhos() {
         arvore.inserirNaoAvl(10);
         arvore.inserirNaoAvl(9);
         arvore.inserirNaoAvl(7);
         arvore.inserirNaoAvl(5);
         arvore.inserirNaoAvl(3);
         String actual = arvore.printTree();
         String expected = "     |-10\n    |9\n"
                 + "   |7\n  |5\n  3\n";
         Assert.assertEquals(expected, actual);
     }
     
     public void testeArvoreComDuasListasDivididasPeloRaiz(){
         arvore.inserirNaoAvl(10);
         arvore.inserirNaoAvl(9);
         arvore.inserirNaoAvl(11);
         arvore.inserirNaoAvl(8);
         arvore.inserirNaoAvl(12);
         arvore.inserirNaoAvl(7);
         arvore.inserirNaoAvl(13);
         String actual = arvore.printTree();
         String expected = "    |-10-|\n   |9   11-|\n  |8      " +
                 "12-|\n  7         13\n";
         Assert.assertEquals(expected, actual);
     }
     
     public void testeArvoreComAlturaDois() {
         arvore.inserirNaoAvl(10);
         arvore.inserirNaoAvl(20);
         arvore.inserirNaoAvl(30);
         String actual = arvore.printTree();
         String expected = "   10-|\n     20-|\n       30\n";
         Assert.assertEquals(expected, actual);
         Assert.assertEquals(2, arvore.getAltura());
     }
     
     public void testeArvoreComApenasUmValorMenorQueORaiz() {
         arvore.inserirNaoAvl(2);
         arvore.inserirNaoAvl(1);
         arvore.inserirNaoAvl(13);
         arvore.inserirNaoAvl(4);
         arvore.inserirNaoAvl(6);
         arvore.inserirNaoAvl(20);
         String actual = arvore.printTree();
         String expected = "  |2---|\n  1 |--13-|\n    " +
                 "4|   20\n     6\n";
         Assert.assertEquals(expected, actual);
     }     
}
