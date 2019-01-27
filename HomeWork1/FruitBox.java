import java.util.ArrayList;

public class FruitBox<T extends Fruit> {

    private ArrayList<T> fruits;
    private float totalWeight;

    public FruitBox() {
        fruits = new ArrayList<>();
    }

    public FruitBox(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public FruitBox(T fruit) {
        fruits = new ArrayList<>();
        fruits.add(fruit);
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public float getWeight() {
        if (fruits.size() != 0) {
            int i = 0;
            totalWeight = fruits.size() * fruits.get(i).getWeight();
        } else {
            System.out.println("Box is empty");
        }
        return totalWeight;
    }

    public boolean compare(FruitBox<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void replaceAllFruitsToOtherBox(FruitBox<T> otherBox) {
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    public void addFruit(T fruitToAdd) {
        fruits.add(fruitToAdd);

    }
}
