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
    
// @Test
     public void testeArvoreComApenaUmNodo() {
         arvore.inserirAvl(10);         
         String actual = arvore.printTree();
         String expected = "10 ";
         Assert.assertEquals(expected, actual);
     }
     
     public void testeArvoreAVLRealizandoBalanceamento(){
         arvore.inserirAvl(10);
         arvore.inserirAvl(20);
         arvore.inserirAvl(30);            
         String actual = arvore.printTree();
         String expected = "20" + "\n" + " 10 " + " 30 ";
         Assert.assertEquals(expected, actual);
     }
}
