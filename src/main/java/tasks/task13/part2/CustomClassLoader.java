package tasks.task13.part2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Класс пользовательского загрузчика классов
 *
 * @param <T> тип
 */
public class CustomClassLoader<T> extends ClassLoader {

    private static CustomClassLoader myClassLoader = null;

    /**
     * Метод получения Class по его имени
     *
     * @param name имя класса
     * @return Class
     * @throws ClassNotFoundException
     */
    private static Class loadClazz(String name) throws ClassNotFoundException {
        if(myClassLoader==null) myClassLoader = new CustomClassLoader();
        return Class.forName(name, true, myClassLoader);
    }

    /**
     * Метод загрузки класса по имени и инстанцированеи его
     *
     * @param name имя класса
     * @return Новый экземпляр класса
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public T Load(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (T)loadClazz(name).newInstance();
    }

    @Override
    protected Class<?> findClass(String name) {
        File classFile = new File(name + ".class");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(classFile))) {
            byte[] content = new byte[(int) classFile.length()];
            bis.read(content);
            return defineClass(name, content, 0, content.length);
        } catch (IOException e) {
            System.out.println("Class load error.");
            return null;
        }
    }

}