/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

import java.util.List;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yumengwang
 */
public class GeneticAlgorithmTest {
    
    public GeneticAlgorithmTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    int number =250;
    Picture rp = new Picture();
    /**
     * Test of init method, of class GeneticAlgorithm.
     */
    @Test
    public void testInit() throws Exception{
        System.out.println("init");
        //run GA
       
        int[][] pixels = rp.getImagePixel("123.jpg");
        GeneticAlgorithm gam = new GeneticAlgorithm(250, pixels) {};
        gam.init();
        // TODO review the generated test code and remove the default call to fail.
        assertNotEquals(gam.getPopulation(),null);
    }
    
    
    
    @Test
    public void testGetParentChromosome() throws Exception {
        int[][] pixels = rp.getImagePixel("123.jpg");
        GeneticAlgorithm gam = new GeneticAlgorithm(250, pixels) {};
        // TODO review the generated test code and remove the default call to fail.
        gam.init();
        Chromosome parent2 = gam.getParentChromosome();
            Chromosome parent1 = gam.getParentChromosome();
        assertNotEquals(parent1,null);
        assertNotEquals(parent2,null);
    }
    
    /**
     * Test of setGeneSize method, of class GeneticAlgorithm.
     * @throws java.lang.Exception
     */
    @Test
    public void testEvolve() throws Exception {
        int[][] pixels = rp.getImagePixel("123.jpg");
        GeneticAlgorithm gam = new GeneticAlgorithm(250, pixels) {};
        // TODO review the generated test code and remove the default call to fail.
        gam.init();
        gam.evolve();
        assertNotEquals(gam.getPopulation(),null);
    }

       /**
     * Test of setPopulation method, of class GeneticAlgorithm.
     * @throws java.lang.Exception
     */
    @Test
    public void testMutation() throws Exception {
        int[][] pixels = rp.getImagePixel("123.jpg");
        GeneticAlgorithm gam = new GeneticAlgorithm(number, pixels) {};
        // TODO review the generated test code and remove the default call to fail.
        gam.mutation();
        assertNotEquals(gam.getPopulation(),null);
    }
}
