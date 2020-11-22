package tasks.task10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Класс создания класса для динамической загрузки
 */
public class CodeReadWriter {

    /**
     * Метод получения ввода(кода) пользователя с консоли
     *
     * @return Исходный код веденный пользователем
     */
    private static String getCodeText() {
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        StringBuilder temp = new StringBuilder();
        do {
            String inputString = scanner.nextLine();
            if (inputString.equals("")) {
                run = false;
                scanner.close();
            } else {
                temp.append(inputString);
                temp.append("\n");
            }
        } while (run);
        return temp.toString();
    }

    private static final String codeTemplate = "import "+ Worker.class.getName()+";\n"+
            "public class $1 implements Worker{\n" +
            "    @Override\n" +
            "    public void doWork() {\n" +
            "       $2 "+
            "    }\n" +
            "}";

    /**
     * Метод чтения кода с консоли и сохранение его в файл
     *
     * @param classname имя класса
     * @return Признак состояния успешности создания и сборки класса
     */
    public static boolean readCodeToWrite(String classname){
        String source = sourceBuilder(classname, getCodeText());

        if(source.equals("")) return false;

        return writeCodeToFile(classname,source);
    }

    /**
     * Метод сборки исходного текста
     *
     * @param classname имя класса
     * @return Сформированный исходный код
     */
    private static String sourceBuilder(String classname, String rawSource){
        if(rawSource.equals("")) return "";

        StringBuilder finalSource = new StringBuilder(codeTemplate);
        int indClassName = finalSource.indexOf("$1");
        finalSource.replace(indClassName,indClassName+2,classname);
        int indSource = finalSource.indexOf("$2");
        finalSource.replace(indSource,indSource+2,rawSource);
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
