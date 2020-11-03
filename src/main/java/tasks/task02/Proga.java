package tasks.task02;

/**
 * Составить программу, генерирующую N случайных чисел.
 * Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */

class NegativeNumberException extends Exception {
    NegativeNumberException(double value) {
        super(value + " is a negative number!!!");
    }
}


public class Proga{
    public static void generateArray(final int size) throws NegativeNumberException {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            if (i >= 0) {
                Double sqr = Math.sqrt(i);
                System.out.println(sqr);
                int temp = sqr.intValue();
                System.out.println(temp);
                double pow = Math.pow(temp, 2);
                System.out.println(pow);
                if (pow == i) {
                    System.out.print(i + "Result ");
                }
            } else {
                throw new NegativeNumberException(i);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws NegativeNumberException {
        generateArray(10);
    }
}
