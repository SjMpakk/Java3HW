/**
 *
 * Java 3 home work 1
 *
 * @author Denisov Alexey
 * @version dated Jan 20, 2019
 */

public class HomeWork1 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Orange> orangeBox = new FruitBox<>();

        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();

        appleBox.addFruit(a1);
        appleBox.addFruit(a2);
        appleBox.addFruit(a3);
        orangeBox.addFruit(o1);
        orangeBox.addFruit(o2);

        System.out.println("\nappleBox weight is: " + appleBox.getWeight());
        System.out.println("orangeBox weight is: " + orangeBox.getWeight());

        System.out.println("Compare weights: " + appleBox.compare(orangeBox) + "\n");

        FruitBox<Apple> appleBox2 = new FruitBox<>();
        appleBox.replaceAllFruitsToOtherBox(appleBox2);

        System.out.println("Apple boxes weights after replacing: ");
        System.out.println("appleBox weight: " + appleBox.getWeight());
        System.out.println("appleBox2 weight: " + appleBox2.getWeight());

        Apple a4 = new Apple();
        appleBox.addFruit(a4);
        System.out.println("\nNew apple box weight is " + appleBox.getWeight());


        //Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);

        Part1And2<String> words = new Part1And2<>(new String[]{"home", "work"});
        Part1And2<Integer> numbers = new Part1And2<>(new Integer[]{12, 20});
        Part1And2<Double> fractionalNumberss = new Part1And2<Double>(new Double[]{1.5, 0.3});

        System.out.println("\nWrite a method that converts an array to an ArrayList");
        words.convertsArrayList();
        numbers.convertsArrayList();
        fractionalNumberss.convertsArrayList();


        System.out.println("\nWrite a method that swaps two elements of the array.");
        words.changePositionOfElementsInArray();
        numbers.changePositionOfElementsInArray();
        fractionalNumberss.changePositionOfElementsInArray();
    }
}
