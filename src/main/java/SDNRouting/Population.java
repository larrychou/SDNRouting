package SDNRouting;
import java.util.Arrays;
import java.util.Comparator;

public class Population {
    private Individual population[];
    private double populationFitness = -1;

    public Population(int populationSize) {
        this.population = new Individual[populationSize];
    }

    public Population(int populationSize, int chromosomeLength) {
        this.population = new Individual[populationSize];
        for(int individualCount = 0; individualCount< populationSize; individualCount++) {
            Individual individual = new Individual(chromosomeLength);
            this.population[individualCount] = individual;
        }
    }

    public Individual[] getPopulation() {
        return population;
    }

    public void setPopulation(Individual[] population) {
        this.population = population;
    }

    public double getPopulationFitness() {
        return populationFitness;
    }

    public void setPopulationFitness(double populationFitness) {
        this.populationFitness = populationFitness;
    }

    public int size() {
        return this.population.length;
    }
    //根据个体的适应度值排序，获取最优或最差的个体
    public Individual getFittest(int offset) {
        Arrays.sort (this.population, new Comparator<Individual>(){
            public int compare(Individual o1,Individual o2){
               return o1.getFitness()>o2.getFitness()?-1:1;
           }
        });
        return this.population[offset];
    }

    public Individual setIndividual(int offset, Individual individual) {
        return population[offset] = individual;
    }

    public Individual getIndividual(int offset) {
        return population[offset];
    }

    public void shuffle() {

    }
}
