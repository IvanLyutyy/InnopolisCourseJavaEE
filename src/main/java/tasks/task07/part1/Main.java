package tasks.task07.part1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Написать программу, читающую текстовый файл.
 * Программа должна составлять отсортированный по алфавиту список слов,
 * найденных в файле и сохранять его в файл-результат.
 * Найденные слова не должны повторяться, регистр не должен учитываться.
 * Одно слово в разных падежах – это разные слова.
 */



public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("File.txt"), StandardCharsets.UTF_8))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                list.add(str);
            }
            Set<String> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
            list.sort(String::compareToIgnoreCase);
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
