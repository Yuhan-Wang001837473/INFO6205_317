/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

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
public class LineTest {
    
    public LineTest() {
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
     * Test of copyLine method, of class Line.
     */
    
    @Test
    public void testCopyLine() {
        System.out.println("genLine");
        Line line = new Line(10,10);
        Line instance = new Line(10,10);
        instance.copyLine(line);
        // TODO review the generated test code and remove the default call to fail.
     assert(line.getX1()==instance.getX1() && line.getY1()==instance.getY1()&& line.getX2()==instance.getX2()&& line.getY2()==instance.getY2());
    }

}