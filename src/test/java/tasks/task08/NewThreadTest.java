package tasks.task08;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NewThreadTest {

    /**
     * количество прогоняемых тестов
     * */
    private static final int TEST_COUNT = 50;

    @ParameterizedTest
    @MethodSource("getTestData")
    public void threadTest(Integer testValue) throws InterruptedException {
        NewThread thread1 = new NewThread(testValue);
        thread1.t1.start();
        thread1.t2.start();
        thread1.t3.start();
        BigInteger actual = thread1.getResult(500);

        assertNotNull(actual);
    }

    @ParameterizedTest
    @MethodSource("getTestData")
    public void threadTest2(Integer testValue) throws InterruptedException {
        NewThread thread1 = new NewThread(testValue);
        thread1.t1.start();
        thread1.t2.start();
        thread1.t1.join();
        thread1.t3.start();

        BigInteger actual = thread1.getResult(1000);
        BigInteger expected = calculateExpectedFactorial(testValue);
        assertEquals(expected, actual);
    }

    /**
     * генерирует тестовые данные
     * @return Stream аргументов используемых при вызове метода теста.
     * */
    public static Stream<Arguments> getTestData() {
        return generateLimitedStream(TEST_COUNT).map(Arguments::of);
    }

    private BigInteger calculateExpectedFactorial(int value) {
        return generateLimitedStream(value).map(BigInteger::valueOf).reduce(BigInteger::multiply).get();
    }

    private static Stream<Integer> generateLimitedStream(int value) {
        return Stream.iterate(1, integer -> ++integer).limit(value);
    }
}