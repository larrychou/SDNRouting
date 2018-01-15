package SDNRouting;

import Bean.Link;
import Bean.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static int populationSize;
    public static int chromosomeLength;
    public static double mutationRate;
    public static double crossoverRate;
    public static int elitismCount;
    public static int maxGeneration = 500;


    public static void main(String[] args) {
        //读取节点与链路信息
        String path = "config\\test.txt";
        //readFile(path);
        //创建GA对象
        GeneticAlgorithm ga = new GeneticAlgorithm(populationSize,mutationRate,crossoverRate,elitismCount);
        //获得初始种群
        Population population = ga.initPopulation(chromosomeLength);
        int generation = 0;

        while(ga.isTerminateConditionMet(population) == false && generation < maxGeneration){
            population = ga.crossoverPopulation(population);

            population = ga.mutatePopulation(population);

            generation++;
        }
        System.out.println(population.getIndividual(0).getFitness());

    }
}
