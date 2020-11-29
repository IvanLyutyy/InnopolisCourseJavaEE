package tasks.task13.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        outOfMem();
//      outOfMemAnother();
//      stackOverflow(1);
    }

    public static void outOfMemAnother() {
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(Integer.MAX_VALUE);
        }
    }

    public static void outOfMem() {
        int[] arr = new Random().ints(1, 100).toArray();
    }

    public static int stackOverflow(int n) {
        System.out.println(n);
        stackOverflow(++n);
        return n;
    }
}

