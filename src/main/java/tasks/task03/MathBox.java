package tasks.task03;

import java.util.*;

public class MathBox<T extends Number> extends ObjectBox<T> {
    public MathBox(T[] numbersArray) {
        this.values = new TreeSet<>();
        this.values.addAll(Arrays.asList(numbersArray));
    }

    public Integer summator() {
        Integer sum = 0;
        for (T num : values) {
            sum = sum + num.intValue();
        }
        return sum;
    }

    public List<Integer> splitter(int c) {
        List<Integer> list = new ArrayList<>(values.size());
        for (T num : values) {
            Integer d = num.intValue() / c;
            list.add(d);
        }
        return list;
    }

    public boolean delInteger(Integer del) {
        deleteObject((T) del);
        return false;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        Long sum = 1l;
        for (T num : values) {
            sum = sum * prime + Double.doubleToLongBits(num.doubleValue());
        }
        return sum.intValue();
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "values=" + values +
                        '}';

        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return values.equals(mathBox.values);
        }
    }
