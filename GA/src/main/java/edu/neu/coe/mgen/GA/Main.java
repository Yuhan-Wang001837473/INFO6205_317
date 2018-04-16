/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

/**
 *
 * @author yumengwang and yuhan wang
 */
public class Main {
     public static void main(String[] args) throws Exception{
     int size = 200;
        //read "123.png" and receive its pixel information stored in a two-dimensional array
        Picture rc = new Picture();
        int[][] pixels = rc.getImagePixel("123.jpg");
        //run GA
        GeneticAlgorithm gm = new GeneticAlgorithm(size, pixels) {};
        gm.process();
    }
}

