package tasks.task12;

import java.math.BigInteger;
        import java.util.Collection;
        import java.util.List;
        import java.util.stream.Collectors;

/**
 * Класс для вычисления факториалов
 *
 * @author Ivan Lyutyy
 */
public class FactorialCalc {
    /**
     * Многопоточное вычисление факториалов с помощью parallelStream
     * @param numbers список чисел, для вычисления их факториала
     * @return список вычисленных факториалов
     */
    public static List<NumbersBox<Integer, BigInteger>> calc(Collection<Integer> numbers) {
        List listOfFactorial = numbers.parallelStream()
                .map(num -> {
                    if (num < 0) {
                        throw new IllegalArgumentException("Факториал определен только для положительных чисел. Число " + num + " неудовлетворяет этому условию.");
                    }
                    BigInteger factorial = new BigInteger("1");
                    for (int i = 1; i <= num; i++) {
                        factorial = factorial.multiply(BigInteger.valueOf(i));
                    }
                    return new NumbersBox(num, factorial);
                })
                .collect(Collectors.toList());
        //        .forEach(System.out::println);
        return listOfFactorial;
    }
}
