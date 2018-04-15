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
public class GeneticAlgorithmTest {
    

    /**
     * Test of calcFitness method, of class GeneticAlgorithm.
     */
    @Test
    public void testCalcFitness() {
        Schedule schedule = ConfigFile.initializeSchedule();

        Individual individual = new Individual(schedule) ;
        GeneticAlgorithm instance = new GeneticAlgorithm(100, 0.01, 0.9, 2, 5);;
        Population pop = instance.initPopulation(schedule);
       
        double result = instance.calcFitness(individual, schedule);
        double expResult= individual.getFitness();
        assertEquals(expResult, result, 0.0);
    }





    
}
