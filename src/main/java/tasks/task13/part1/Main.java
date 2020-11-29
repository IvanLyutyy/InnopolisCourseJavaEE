package tasks.task13.part1;


import java.util.ArrayList;
import java.util.List;

/**
 * Задание 1.Необходимо создать программу,
 * которая продемонстрирует утечку памяти в Java.
 * При этом объекты должны не только создаваться,
 * но и периодически частично удаляться,
 * чтобы GC имел возможность очищать часть памяти.
 * Через некоторое время программа должна завершиться с ошибкой OutOfMemoryError c пометкой Java Heap Space.
 */


public class Main {

    // Демонстрация OutOfMemoryError: Java heap space
    public static void main(String[] args) {
        List<Long[]> list = new ArrayList<>();
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            list.add( new Long[24000]);
            if (i % 1000 == 0) {
                list.remove(0);
            }
        }
    }
}
