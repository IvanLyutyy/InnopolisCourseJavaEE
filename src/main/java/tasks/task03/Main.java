package tasks.task03;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {0, 4, 2, 7, 1, 1};

        MathBox<Integer> box = new MathBox<>(intArray);
        System.out.println(box.hashCode());
        System.out.println(box.toString());
        System.out.println(box.splitter().toString());
        System.out.println(box.summator());
        box.deleteObject(0);
        box.addObject(456);
        System.out.println(box.toString());
    }

}
