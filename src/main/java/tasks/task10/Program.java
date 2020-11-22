package tasks.task10;

public class Program {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        String classname = "Test";

        if (CodeReadWriter.readCodeToWrite(classname)) {
            if (Compiler.Compile(classname + ".java")) {
                new CustomClassLoader<Worker>().Load(classname).doWork();
            }
        }
    }
}
