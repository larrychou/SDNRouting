package SDNRouting;

import java.util.Arrays;

public class Individual {
    private int[] chromosome;
    private double fitness = -1;
    //求的路径信息--一条染色体
    public Individual(int[] chromosome) {
        this.chromosome = chromosome;
    }
    //染色体长度，即为业务总数
    public Individual (int chromosomeLength){

    }

    public int[] getChromosome() {
        return chromosome;
    }

    public int getChromosomeLength() {
        return chromosome.length;
    }

    public int getGene(int offset) {
        return this.chromosome[offset];
    }

    public void setGene(int offset, int gene) {
        this.chromosome[offset] = gene;
    }

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "chromosome=" + Arrays.toString(chromosome) +
                ", fitness=" + fitness +
                '}';
    }
}
