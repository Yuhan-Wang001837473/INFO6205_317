# INFO6205_317
Genetic Algorithm: Draw a picture according to the given picture

Yuhan Wang:  NUID:001837473
Yumeng Wang:   NUID: 001828064
Group number: #317


Problem:
We use  genetic algorithm to draw a picture according to the given picture.  

Design logic
1. We use the function Line (length, width) to represent a line, that is to say the gene expression is a line of an image on the panel.We use an image as an individual and the image is composed of hundreds of lines.  In other words, a gene is a line and a chromosome is an image  which has 200 lines.
2. Each population is composed of 250 images, we sort the fitness value of each population in a descending order. Then, we select the top 10% of the value and choose two of them randomly to crossover to generate the next generation.
3. To realize the variety of the population, we also use the mutation function to change the line in the image. In mutation function, mutation rate is a key point, we set it as 0.8 when the generation is less than 2000, however, when the generation grows, we set the mutation rate as 0.7.
4. The fitness score is calculated according to the RGB value of the pixel point and we choose the surrounding 4 points around the drawn point and compare their RGB value with the target point on the raw image. To different situation, we change the value accordingly to get a reasonable evaluation of the drawn point.

