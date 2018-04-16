/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yumengwang
 */
public class ChromosomeTest {
    
    public ChromosomeTest() {
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
    
    
    /**
     * Test of clone method, of class Chromosome.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Chromosome e = new  Chromosome(10);
        Chromosome result = Chromosome.clone(e);
        for(int i = 0; i < e.getGene().size(); i++){
            assertEquals(e.getGene().get(i).getX1(),result.getGene().get(i).getX1());    
            assertEquals(e.getGene().get(i).getY1(),result.getGene().get(i).getY1());    
            assertEquals(e.getGene().get(i).getX2(),result.getGene().get(i).getX2());    
            assertEquals(e.getGene().get(i).getY2(),result.getGene().get(i).getY2());    
    }
    }
    /**
     * Test of genetic method, of class Chromosome.
     */
    @Test
    public void testGenetic1() {
        System.out.println("genetic1");
        Chromosome e1 = new Chromosome(10);
        Chromosome e2 = new Chromosome(20);
        List<Chromosome> child=Chromosome.genetic(e1,e2);
         assertEquals(child,null);
        
    }
    
    @Test
    public void testGenetic2() {
        System.out.println("genetic2");
        Chromosome e1 = new Chromosome(10);
        Chromosome e2 = null;
         List<Chromosome> child=Chromosome.genetic(e1,e2);
         assertEquals(child,null);
        
    }
     @Test
    public void testGenetic3() {
        System.out.println("genetic3");
        Chromosome e1 = new Chromosome(10);
        Chromosome e2 = new Chromosome(10);
        List<Chromosome> child=Chromosome.genetic(e1,e2);
        for(int i=0;i<child.size();i++){
         assertNotEquals(child,null);
        }
          
    }
    
   

    /**
     * Test of mutation method, of class Chromosome.
     */
    @Test
    public void testMutation() {
        System.out.println("mutation");
        Chromosome c1=new Chromosome(10);
        Chromosome c2=Chromosome.clone(c1);
        for(int i=0;i<10;i++){
        assertEquals(c1.getGene().get(i).getX1(),c2.getGene().get(i).getX1());
        assertEquals(c1.getGene().get(i).getY1(),c2.getGene().get(i).getY1());    
        assertEquals(c1.getGene().get(i).getX2(),c2.getGene().get(i).getX2());    
        assertEquals(c1.getGene().get(i).getY2(),c2.getGene().get(i).getY2());   
        }
        c2.mutation(5);
        boolean flag=true;
        for(int j=0;j<10;j++){
        if(c2.getGene().get(j).getX1()!=c1.getGene().get(j).getX1()||c2.getGene().get(j).getY1()!=c1.getGene().get(j).getY1()||c2.getGene().get(j).getX2()!=c1.getGene().get(j).getX2()||c2.getGene().get(j).getY2()!=c1.getGene().get(j).getY2())
            flag=false;   
        }
        assertEquals(flag,false);
        
    }
}

