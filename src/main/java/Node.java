public class Node {
    private int index;
    private String name;
    private int capacity;
    private int delay;
    private int cost;

    @Override
    public String toString() {
        return "Node{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", delay=" + delay +
                ", cost=" + cost +
                '}';
    }

    public Node(int index, String name, int capacity, int delay, int cost) {
        this.index = index;
        this.name = name;
        this.capacity = capacity;
        this.delay = delay;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
