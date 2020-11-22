package tasks.task13.part2;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс создания класса для динамической загрузки
 */
public class CodeReadWriter {


    private static final String codeTemplate = "public class $1{\n" +
            "       private static final Long g = Long.MAX_VALUE;\n" +
            "}";

    /**
     * Метод чтения кода с консоли и сохранение его в файл
     *
     * @param classname имя класса
     * @return Признак состояния успешности создания и сборки класса
     */
    public static boolean readCodeToWrite(String classname){
        String source = sourceBuilder(classname);

        if(source.equals("")) return false;
        return writeCodeToFile(classname,source);
    }

    /**
     * Метод сборки исходного текста
     *
     * @param classname имя класса
     * @return Сформированный исходный код
     */
    private static String sourceBuilder(String classname){

        StringBuilder finalSource = new StringBuilder(codeTemplate);
        int indClassName = finalSource.indexOf("$1");
        finalSource.replace(indClassName,indClassName+2,classname);
        return finalSource.toString();
    }

    /**
     * Метод записи исходного текста в файл
     *
     * @param classname имя класса
     * @param source Сформированный исходный код
     * @return Признак состояния успешности создания и сборки класса
     */
    private static boolean writeCodeToFile(String classname, String source) {
        boolean result =true;
        try (FileOutputStream fileOutputStream = new FileOutputStream(classname + ".java")) {
            byte[] buffer = source.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
            result=false;
        }

        return result;
    }

}
