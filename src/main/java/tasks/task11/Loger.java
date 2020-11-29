package tasks.task11;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;

public class Loger {
    private static final String template = "%s : %s \r\n";

    public static void i(String str) {
        System.out.printf(template, LocalDateTime.now().toString(), str);
    }

    public static void i(Integer integer) {
        i(integer.toString());
    }

    public static void i(Collection list) {
        for (Object item : list) {
            i(item.toString());
        }
    }

    public static <T> void i(Map<T, T> pairs) {
        System.out.println(LocalDateTime.now());
        for (Map.Entry e : pairs.entrySet()) {
            System.out.printf(template, e.getKey().toString(), e.getValue().toString());
        }
    }
}
