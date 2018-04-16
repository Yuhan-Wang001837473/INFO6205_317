/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yumeng wang and yuhan wang
 */
public class Picture extends JPanel{
    
    private Chromosome chromosome;//image
    private int[][] pixelList;//array used for storing pixels
    private JFrame frame;
    
    public Picture(){
        
    }
    public   Picture(Chromosome chromosome, JFrame frame){
        this.chromosome = chromosome;
        this.frame = frame;    
    }
     public JPanel returnJPanel(){
        return this;
    }
    
     public int[][] realization(){
        frame.getContentPane().add(this);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(getChromosome().getL(), getChromosome().getW());
        frame.setVisible(true);
        return workPic(frame);
     }
    
    private int[][] workPic(JFrame ra) {
        //get the content of input jFrame
        Container content = ra.getContentPane();
        //create a BufferedImage to store the image on the jFrame
        BufferedImage be = new BufferedImage(ra.getWidth(), ra.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = be.createGraphics();
        content.printAll(g2d);
        int[] rgb = new int[3];
        int width = be.getWidth();
        int height = be.getHeight();
        int minx = be.getMinX();
        int miny = be.getMinY();
        setPixelList(new int[width][height]);

        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = be.getRGB(i, j); // store Blue value as pixel value  
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                getPixelList()[i][j] = rgb[0];
//                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
//                        + rgb[1] + "," + rgb[2] + ")");
            }
        }
        return getPixelList();
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < getChromosome().getGene().size(); i++){
            g.drawLine(chromosome.getGene().get(i).getX1(), getChromosome().getGene().get(i).getY1(), getChromosome().getGene().get(i).getX2(), getChromosome().getGene().get(i).getY2());
        }
    }

    /**
     * read RGB of a picture
     * @param image
     * @return
     * @throws Exception
     */
     public int[][] getImagePixel(String image) throws Exception {
        int[] rgb = new int[3];
        //read image from the file path
        File file = new File(image);
        BufferedImage be = null;
        try {
            be = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //process the image
        grayRealization(be);
        int width = be.getWidth();
        int height = be.getHeight();
        int minx = be.getMinX();
        int miny = be.getMinY();
        int[][] pixelList = new int[width][height];
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = be.getRGB(i, j); // get RGB and use Blue value as pixel value  
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                pixelList[i][j] = rgb[0];
                
            }
        }
        return pixelList;
    }
     
     /**
     * @param sourceImage
     * @description transfer a colored image into a gray-scaled one
     */
    
    private void grayRealization(BufferedImage sourceImage) {
        int width = sourceImage.getWidth();
        int height = sourceImage.getHeight();
        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);// BufferedImage.TYPE_BYTE_GRAY takes this piture as gray image 
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = sourceImage.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }
    }

    public Chromosome getChromosome() {
        return chromosome;
    }

    public void setChromosome(Chromosome chromosome) {
        this.chromosome = chromosome;
    }

    public int[][] getPixelList() {
        return pixelList;
    }

    public void setPixelList(int[][] pixelList) {
        this.pixelList = pixelList;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
}
