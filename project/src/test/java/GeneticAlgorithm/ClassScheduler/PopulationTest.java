/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.ClassScheduler;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ankit
 */
public class PopulationTest {



    /**
     * Test of getAvgFitness method, of class Population.
     */
    @Test
    public void testGetAvgFitness() {
        System.out.println("getAvgFitness");
             int[] a = {0, 1, 2, 3};
        Individual i = new Individual(a);
        i.setFitness(0.20);

        int[] b = {4, 3, 2, 1};
        Individual j = new Individual(b);
        j.setFitness(0.50);
        Population instance = new Population(2);
        instance.setIndividual(0, i);
        instance.setIndividual(1, j);
        
        double expResult = 0.35;
        double result = instance.getAvgFitness();
        assertEquals(expResult, result, 0.0);
    }


    /**
     * Test of getFittest method, of class Population.
     */
    @Test
    public void testGetFittest() {
        System.out.println("getFittest");
        int offset = 0;
        int[] a = {0, 1, 2, 3};
        Individual i = new Individual(a);
        i.setFitness(0.20);

        int[] b = {4, 3, 2, 1};
        Individual j = new Individual(b);
        j.setFitness(0.50);
        Population instance = new Population(2);
        instance.setIndividual(0, i);
        instance.setIndividual(1, j);
        
        Individual expResult = j;
        Individual result = instance.getFittest(offset);
        assertEquals(expResult, result);
    }



    /**
     * Test of getPopulationFitness method, of class Population.
     */
    @Test
    public void testGetPopulationFitness() {
        System.out.println("getPopulationFitness");
             int[] a = {0, 1, 2, 3};
        Individual i = new Individual(a);
        i.setFitness(0.20);

        int[] b = {4, 3, 2, 1};
        Individual j = new Individual(b);
        j.setFitness(0.50);
        Population instance = new Population(2);
        instance.setIndividual(0, i);
        instance.setIndividual(1, j);
        
        instance.getAvgFitness();
        double expResult = 0.70;
        double result = instance.getPopulationFitness();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of size method, of class Population.
     */
    @Test
    public void testSize() {
        System.out.println("size");
             int[] a = {0, 1, 2, 3};
        Individual i = new Individual(a);
        i.setFitness(0.20);

        int[] b = {4, 3, 2, 1};
        Individual j = new Individual(b);
        j.setFitness(0.50);
        Population instance = new Population(2);
        instance.setIndividual(0, i);
        instance.setIndividual(1, j);
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);
    }



}
