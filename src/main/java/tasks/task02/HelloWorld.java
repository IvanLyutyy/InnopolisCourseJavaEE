package tasks.task02;

/**
 * Задание 1. Написать программу ”Hello, World!”.
 * В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
 */

public class HelloWorld {
    public static void main(String[] args) {
        Object obj = null;
        int[] array = {1, 2, 3, -7};
        NullPointerException(obj);
        ArrayIndex(array);
        try {
            if (array[3] < 0)
                throw new Exception("Третий элемент отрицательный");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private static void NullPointerException(Object obj){
        obj.equals("AAAAA");
        System.out.println("Hello world");
    }

    private static void ArrayIndex(int[] array) {
        array[5] = 8;
    }
}