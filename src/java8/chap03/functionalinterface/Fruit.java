package java8.chap03.functionalinterface;

public abstract class Fruit {
    private String type;
    private int weight;

    public Fruit(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + "{weight=" + weight + "}";
    }
}
