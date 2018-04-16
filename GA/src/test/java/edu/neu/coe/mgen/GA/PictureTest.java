/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
public class PictureTest {
   Chromosome chromosome;
   JFrame jf;
    public PictureTest() {
        chromosome = new Chromosome(5);
        jf = new JFrame();
        
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
     * Test of returnJPanel method, of class DrawLine.
     */
    @Test
    public void testReturnJPanel() {
        System.out.println("returnJPanel");
        Picture instance = new Picture(chromosome, jf);
        JPanel result = instance.returnJPanel();
        assertEquals(result,instance);
    }

    /**
     * Test of realization method, of class DrawLine.
     */
    @Test
    public void testRealization() {
        System.out.println("realization");
        Picture instance = new Picture(chromosome, jf);
        int[][] result = instance.realization();
        assertNotEquals(result,null);       
    }

   
}
