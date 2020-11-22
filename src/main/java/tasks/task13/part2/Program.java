package tasks.task13.part2;


/**
 * Задание 2.Доработать программу так,
 * чтобы ошибка OutOfMemoryError возникала в Metaspace /Permanent Generation
 */


import java.io.File;

public class Program {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        String classname = "Test";
        CustomClassLoader loader = new CustomClassLoader();
        for(int i=0;i<Integer.MAX_VALUE;i++) {
            if (CodeReadWriter.readCodeToWrite(classname+"_"+i)) {
                if (Compiler.Compile(classname+"_"+i+ ".java")) {
                    loader.Load(classname+"_"+i);

                    File file = new File(classname+"_"+i+ ".java");
                    file.delete();
                    file = new File(classname+"_"+i+ ".class");
                    file.delete();
                }
            }
        }

    }
}
