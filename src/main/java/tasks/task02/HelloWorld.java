package tasks.task02;

/**
 * Задание 1. Написать программу ”Hello, World!”. В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 * <p>
 * Смоделировав ошибку «NullPointerException»
 * Смоделировав ошибку «ArrayIndexOutOfBoundsException»
 * Вызвав свой вариант ошибки через оператор throw
 */


class TestException {
    static void ArrayIndex() {
        int i = 0;
        int[] array = new int[10];
        while (true) {
            try {
                array[i] = i;
            } catch (Exception ex) {
                System.out.println("\n" + "Мы вышли за пределы массива" + ex.toString());
                break;
            }
            System.out.println(i);
            i++;
        }
    }

    public static void NullPointerException(){
        int i;
        int[] array = new int[10];
        array = null;
        try{
            i = array.length;
        } catch (Exception ex) {
            System.out.println(" ");
            System.out.println("Ошибка перехвачена:" + ex.toString());
        }
    }


    public static void MyException(Object exp) {
        if (exp == null) {
            throw new NullPointerException("a must not be null");
        }
        System.out.println("Ошибки нет");
    }
}


    public class HelloWorld {
        public static void main(String[] args) {
            TestException.ArrayIndex();
            TestException.NullPointerException();
            TestException.MyException(null);
        }

    }
