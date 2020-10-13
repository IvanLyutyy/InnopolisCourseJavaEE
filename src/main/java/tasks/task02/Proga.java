package tasks.task02;


public class Proga {
    public static void main(String[] args) {
        int a = 0; // Начальное значение диапазона - "от"
        int b = 100; // Конечное значение диапазона - "до"

        for (int i = 0; i <= 100; i++) {
            int k = a + (int) (Math.random() * b); // Генерация всех чисел
            double q = Math.sqrt(k);
            if (q==k){
                System.out.println(q);
            }
//            System.out.println("1-ое случайное число: " + k);
        }
    }
}
