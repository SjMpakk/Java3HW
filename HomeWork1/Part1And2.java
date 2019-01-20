import java.util.ArrayList;
import java.util.Arrays;

public class Part1And2 <T> {

    private T[] obj;

    public Part1And2(T[] obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }

    public ArrayList<T> convertsArrayList() {
        ArrayList<T> arrayList = new ArrayList<T>(Arrays.asList(obj));
        System.out.println(arrayList);
        return arrayList;
    }

    public void changePositionOfElementsInArray() {
        T x = obj[0];
        obj[0] = obj[1];
        obj[1] = x;
        System.out.println(Arrays.toString(obj));
    }
}
