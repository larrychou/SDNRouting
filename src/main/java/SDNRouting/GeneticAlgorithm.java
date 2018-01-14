package SDNRouting;

public class GeneticAlgorithm {
    //种群大小
    private int pupulationSize;
    //突变率
    private double mutationRate;
    //交叉率
    private double crossoverRate;
    //精英主义（保留精英的数量）
    private int elitismCount;

    //初始化种群
    public Population initPopulation(int chromosomeLength) {
        Population population = new Population(this.pupulationSize,chromosomeLength);
        return population;
    }

    public GeneticAlgorithm(int pupulationSize, double mutationRate, double crossoverRate, int elitismCount) {
        this.pupulationSize = pupulationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.elitismCount = elitismCount;
    }

    //计算个体的适应度值
    public double calcFitness (Individual individual) {
        double fitness = 0;

        return fitness;
    }

    //判断终止遗传算法迭代
    public boolean isTerminateConditionMet(Population population){

        return false;
    }
    //交叉操作
    public Population crossoverPopulation(Population population) {

        return population;
    }

    //变异操作
    public Population mutatePopulation(Population population) {

        return population;
    }

    public int getPupulationSize() {
        return pupulationSize;
    }

    public void setPupulationSize(int pupulationSize) {
        this.pupulationSize = pupulationSize;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(double mutationRate) {
        this.mutationRate = mutationRate;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    public int getElitismCount() {
        return elitismCount;
    }

    public void setElitismCount(int elitismCount) {
        this.elitismCount = elitismCount;
    }

}
