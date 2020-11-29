package tasks.task07.part2;

import java.util.*;

public class Generation {
    static List<String> sentence = new ArrayList<>();
    static String alfabet = "abcdefghijklmnopqsrtuvwxyz";
    static String alfaUp = alfabet.toUpperCase();
    static String znaki = ".!?,";
    static String space = " ";

    public static String firsWordGen() {
        Random random = new Random();
        char[] str = new char[15];
        char c = alfaUp.charAt(random.nextInt(alfaUp.length()));
        str[0] = c;
        for (int i = 1; i <= (((int) (Math.random() * 15))); i++) {
            str[i] = alfabet.charAt(random.nextInt(alfabet.length()));
        }
        return new String(str);
    }

    public static String wordGen() {
        Random random = new Random();
        char[] str = new char[15];
        for (int i = 0; i <= (((int) (Math.random() * 15))); i++) {
            str[i] = alfabet.charAt(random.nextInt(alfabet.length()));
        }
        return new String(str);
    }

    public static String markGen() {
        int index = (int) (Math.random() * 3);
        return String.valueOf(znaki.charAt(index));
    }

    public static String sentenceGen(String fisrtWord, List<String> wordList, String mark) {
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < wordList.size(); i++) {
            if (i < (wordList.size() - 1)) {
                sentence.append(wordList.get(i)).append(space);
            } else {
                sentence.append(wordList.get(i));
            }

        }
        return fisrtWord +
                System.lineSeparator() + sentence + mark +
                System.lineSeparator();
    }

    public static String paragrapfGen(List<String> sentence) {
        StringBuilder para = new StringBuilder();
        for (String s : sentence) {
            para.append(s);
        }
        return para.toString() +
                System.lineSeparator();
    }
    public static String textGen(List<String> paragrapg) {
        StringBuilder para = new StringBuilder();
        for (String s : paragrapg) {
            para.append(s);
        }
        return para.toString() +
                System.lineSeparator();
    }
}
