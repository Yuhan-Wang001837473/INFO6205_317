/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.mgen.GA;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;



/**
 *
 * @author yumengwang and yuhan wang
 */
public class GeneticAlgorithm {
    private JFrame frame;

    private List<Chromosome> population = new ArrayList<Chromosome>();
    private int imageNumber=250;// population composed of 100 images
    private int geneNumber;//chromosome length
    
    private double mutationRate = 0.8;
    private int maxMutationNumeber = 15;
    private int generation ;
    private int maxIterateNum = 20000;
    
    private double bestScore;//best score 
    private int[][] targetPixelList; //target picture which I want to draw
   
    
    public GeneticAlgorithm(int geneNumber, int[][] p) {
        this.geneNumber = geneNumber;
        this.targetPixelList = p;
    }
    
    public void process() { 
        init(); //1.innitiate the population
        setFrame(new JFrame());
        for (generation=0; generation< getMaxIterateNum(); generation++) {//2.calculate chromosomefitness
        bestScore=population.get(0).getScore();
            for(Chromosome chmo : getPopulation()){
               setChromosomeFitness(chmo);
               if (chmo.getScore() > getBestScore()) { //set the best score and the relating gene 
                setBestScore(chmo.getScore());
            }
            }
       //3.crossover 
       evolve();
       //4.mutation  
       mutation();
       
        System.out.println("--------------------------------");
        System.out.println("Generation " + getGeneration()+" Best score " + getBestScore());
        }
    }
    
    /**
     * @Description: population initiation
     */
    public void init() {
        
        setPopulation(new ArrayList<Chromosome>());
        for (int i = 0; i <getImageNumber(); i++) {
            Chromosome chmo = new Chromosome(geneNumber);
            population.add(chmo);
        }
    }
    
       
     
    
    public double setChromosomeFitness(Chromosome chmo) {
        if (chmo == null) {
            return 0;
        }
        double fitness = 0;
        Picture drawPicture = new Picture(chmo, getFrame());
        frame.getContentPane().add(drawPicture.returnJPanel());
        int[][] pixelList = drawPicture.realization();
        for (int i = 1; i < chmo.getL() ; i++) {
            for (int j = 1; j < chmo.getW() ; j++) {
                int k, d;
                //based on pixellist[i][j] to draw to square,compare with targetPixelList[i][j] to caculate pixellist[i][j] fitness in this square.
                for (k = i - 1; k <=i ; k++) {
                    for (d = j - 1; d <= j; d++) {
                        if (k != i || d != j) {// if pixelList[k][d] is not pixelList[i][j], they have less influence to fitness than pixelList[i][j]
                            //paint black, target black
                            if ((pixelList[k][d] < 180) && (targetPixelList[i][j] < 180)) {
                                fitness += 0.01;
                            } //paint black, target white
                            else if ((pixelList[k][d] < 180) && (targetPixelList[i][j] > 180)) {
                                fitness -= 0.01;
                            } //paint white, target black
                            else if ((pixelList[k][d] > 180) && (targetPixelList[i][j] < 180)) {
                                fitness -= 0.005;
                            } //paint whit ,pixel target white 
                            else if ((pixelList[k][d] > 180) && (targetPixelList[i][j] > 180)) {
                                fitness += 0.005;
                            }
                        } else {
                            if ((pixelList[k][d] < 180) && (targetPixelList[i][j] < 180)) {
                                fitness += 1;
                            } //paint black, target white
                            else if ((pixelList[k][d] < 180) && (targetPixelList[i][j] > 180)) {
                                fitness -= 1;
                            } //paint white, target black
                            else if ((pixelList[k][d] > 180) && (targetPixelList[i][j] < 180)) {
                                fitness -= 0.5;
                            } //paint whit ,pixel target white 
                            else if ((pixelList[k][d] > 180) && (targetPixelList[i][j] > 180)) {
                                fitness += 0.5;
                            }
                        }
                    }
                }

            }
        }
        this.frame.getContentPane().remove(drawPicture);
        chmo.setScore(fitness);
        return fitness;

    }

    /**
     * @return @Description: the parent is the top 10% of image score 
     */
    
       public Chromosome getParentChromosome() {
        Collections.sort(population);//sort in descending order and get the first one, which holds the greatest score
        Random r=new Random();
        int range=(int)(population.size()*0.1);
        int number=r.nextInt(range);
        Chromosome bestChmo = getPopulation().get(number);

        return bestChmo;
       }
       
      
    
    /**
     * @Description:crossover
     */
    public void evolve() {
        List<Chromosome> childPopulation = new ArrayList<Chromosome>();
        //generate next generation  
         while (childPopulation.size() < getImageNumber()) {
            //according to the first 3 best chromosome to choose parents randomly
            Chromosome parent = getParentChromosome();
            Chromosome parent1 = getParentChromosome();
            //mate and give birth to the child
            List<Chromosome> children = Chromosome.genetic(parent, parent1);
            if (children != null) {
                //fill up childPopulation
                for (Chromosome chmo : children) {
                    childPopulation.add(chmo);
                }
            }
        }
        
        //replace the old population with the newly generated one  
        getPopulation().clear();
        setPopulation(childPopulation);
    }
    
        /**
     * mutation
     */
    public void mutation() {
        if(generation<2000){//mutation happening  
        for (Chromosome chmo : getPopulation()) {
            if (Math.random() < getMutationRate()) { 
                int mutationNum = (int) (Math.random() * getMaxMutationaNumeber() );
                chmo.mutation(mutationNum);
            }
        }
    }
    
    else{
         mutationRate=0.7;   //after 2000 generation,picture is almost steady, reduce the mutation Rate help increase the chance to draw correct line.
    for (Chromosome chmo : getPopulation()) {
            if (Math.random() < mutationRate) { //mutation happening  
                int mutationNum = (int) (Math.random() * getMaxMutationaNumeber() );
                chmo.mutation(mutationNum);
            }
        }
        }
}
    
    

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * @return the population
     */
    public List<Chromosome> getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(List<Chromosome> population) {
        this.population = population;
    }

    /**
     * @return the imageNumber
     */
    public int getImageNumber() {
        return imageNumber;
    }

    /**
     * @param imageNumber the imageNumber to set
     */
    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    /**
     * @return the geneNumber
     */
    public int getGeneNumber() {
        return geneNumber;
    }

    /**
     * @param geneNumber the geneNumber to set
     */
    public void setGeneNumber(int geneNumber) {
        this.geneNumber = geneNumber;
    }

    /**
     * @return the mutationRate
     */
    public double getMutationRate() {
        return mutationRate;
    }

    /**
     * @param mutationRate the mutationRate to set
     */
    
    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }
          
    /**
     * @return the maxMutationaNumeber
     */
    
    public int getMaxMutationaNumeber() {
        return maxMutationNumeber;
    }

    /**
     * @param maxMutationaNumeber the maxMutationaNumeber to set
     */
    
    public void setMaxMutationaNumeber(int maxMutationaNumeber) {
        this.maxMutationNumeber = maxMutationaNumeber;
    }

    /**
     * @return the generation
     */
    
    public int getGeneration() {
        return generation;
    }

    /**
     * @param generation the generation to set
     */
    
    public void setGeneration(int generation) {
        this.generation = generation;
    }

    /**
     * @return the maxIterateNum
     */
    public int getMaxIterateNum() {
        return maxIterateNum;
    }

    /**
     * @param maxIterateNum the maxIterateNum to set
     */
    public void setMaxIterateNum(int maxIterateNum) {
        this.maxIterateNum = maxIterateNum;
    }

    /**
     * @return the targetPixelList
     */
    public int[][] getTargetPixelList() {
        return targetPixelList;
    }

    /**
     * @param targetPixelList the targetPixelList to set
     */
    public void setTargetPixelList(int[][] targetPixelList) {
        this.targetPixelList = targetPixelList;
    }

    /**
     * @return the bestScore
     */
    public double getBestScore() {
        return bestScore;
    }

    /**
     * @param bestScore the bestScore to set
     */
    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }

    
   
   
    
    
    
    
}
