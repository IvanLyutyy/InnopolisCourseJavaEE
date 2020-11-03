package tasks.task07.part2;

import java.util.*;

/**
 * Создать генератор текстовых файлов, работающий по следующим правилам:
 *
 * Предложение состоит из 1<=n1<=15 слов.
 * В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
 * В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000.
 * Есть вероятность probability вхождения одного из слов этого массива
 * в следующее предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words,
 * int probability), который создаст n файлов размером size в каталоге path. words -
 * - массив слов, probability - вероятность.
 */


public class Main {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        List<String> sentenceList = new ArrayList<>();
        List<String> paragList = new ArrayList<>();
        for (int i=0; i<((int)(Math.random()*15)); i++){
            wordList.add(i, Generation.wordGen());
        }
        for (int i=0; i<(1+(int)(Math.random()*20)); i++){
            sentenceList.add(i,Generation.sentenceGen(Generation.firsWordGen(), wordList, Generation.markGen()));
        }
        String paragrapg = Generation.paragrapfGen(sentenceList);
        System.out.println(paragrapg);
    }
}
