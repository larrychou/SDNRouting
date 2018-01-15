package Bean;

public class Link {
    private int id;
    private int n_index1;
    private int n_index2;
    private int capacity;
    private int delay;
    private int cost;

    public Link(int id, int n_index1, int n_index2, int capacity, int delay, int cost) {
        this.id = id;
        this.n_index1 = n_index1;
        this.n_index2 = n_index2;
        this.capacity = capacity;
        this.delay = delay;
        this.cost = cost;
    }

    public String toString() {
        return "Link{" +
                "id=" + id +
                ", n_index1=" + n_index1 +
                ", n_index2=" + n_index2 +
                ", capacity=" + capacity +
                ", delay=" + delay +
                ", cost=" + cost +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN_index1() {
        return n_index1;
    }

    public void setN_index1(int n_index1) {
        this.n_index1 = n_index1;
    }

    public int getN_index2() {
        return n_index2;
    }

    public void setN_index2(int n_index2) {
        this.n_index2 = n_index2;
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
