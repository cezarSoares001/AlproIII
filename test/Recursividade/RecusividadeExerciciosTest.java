/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividade;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas
 */
public class RecusividadeExerciciosTest {
    
    /**
     * Test of somatorioDeN method, of class RecusividadeExercicios.
     */
    @Test
    public void testSomatorioDeN() {
        System.out.println("somatorioDeN");
        int n = 5;
        int expResult = 15;
        int result = RecusividadeExercicios.somatorioDeN(n);
        assertEquals(expResult, result);      
        
    }

    /**
     * Test of somatorioDeKaJ method, of class RecusividadeExercicios.
     */
    @Test
    public void testSomatorioDeKaJ() {
        System.out.println("somatorioDeKaJ");
        int k = 1;
        int j = 3;
        int expResult = 6;
        int result = RecusividadeExercicios.somatorioDeKaJ(k, j);
        assertEquals(expResult, result);        
        
    }

    /**
     * Test of somatorioDeUmArrayList method, of class RecusividadeExercicios.
     */
    @Test
    public void testSomatorioDeUmArrayList() {
        System.out.println("somatorioDeUmArrayList");
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        int expResult = 6;
        int result = RecusividadeExercicios.somatorioDeUmArrayList(lista);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findBiggest method, of class RecusividadeExercicios.
     */
    @Test
    public void testFindBiggest() {
        System.out.println("findBiggest");
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(20);
        lista.add(30);
        lista.add(10);
        int expResult = 30;
        int result = RecusividadeExercicios.findBiggest(lista);
        assertEquals(expResult, result);
         
        
    }

    /**
     * Test of isPal method, of class RecusividadeExercicios.
     */
    @Test
    public void testIsPal() {
        System.out.println("isPal");
        String s = "ovo";
        boolean expResult = true;
        boolean result = RecusividadeExercicios.isPal(s);
        assertEquals(expResult, result);
        
    }
    
}
