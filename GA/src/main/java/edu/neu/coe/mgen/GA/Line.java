/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

import java.util.Random;

/*
 *
 * @author yumeng wang and yuhan wang
 */
public class Line {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    //draw the line according to the given width and length
    public Line(int length,int width){
        x1 = (int)(Math.random()*length);
        y1 = (int)(Math.random()*width);
        x2 = (int)(Math.random()*length);
        y2 = (int)(Math.random()*width);
    }
    
    public void copyLine(Line line){
        x1=line.getX1();
        y1=line.getY1();
        x2=line.getX2();
        y2=line.getY2();
    }    

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }
}
