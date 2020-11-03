package tasks.task02;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN),
 * name (имя - строка). Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки.
 * Реализовать два различных метода сортировки этого массива по правилам:
 * первые идут мужчины
 * выше в списке тот, кто более старший
 * имена сортируются по алфавиту
 * Программа должна вывести на экран отсортированный список и время работы каждого алгоритма сортировки.
 * Предусмотреть генерацию исходного массива (10000 элементов и более).
 * Если имена людей и возраст совпадают, выбрасывать в программе пользовательское исключение
 */



interface Sort {

    public Person[] sort(Person[] person);
}



class Person implements Comparable {
    int age;
    Sex sex;
    String name;


    Person(int age, Sex sex, String name) {
        this.age = age;
        this.name = name;
        this.sex = sex;

    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name='" + name + '\'' +
                '}';
    }

    public static String createName(int arrayLength) {
        String eman = null;
        String namerandom = "ABCDE";
        StringBuilder name = new StringBuilder(5);/*Создаем обьект имя,
            который будет состоять из символов namerandom*/

        for (int k = 0; k < 5; k++) {
                /*Ниже выдергиваем символ из namerandpm псевдослучайным образом
                и добавляем его в наше имя*/
            int index = (int) (namerandom.length() * Math.random());
            eman = name.append(namerandom.charAt(index)).toString();
        }

        return eman;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return this.getName().compareTo(person.getName());
    }
}


enum Sex {
    MAN,
    WOMAN;

    //Создаем из перечеслений неизменяемый список
    private static final List<Sex> value =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final Random random = new Random();

    //Выбираем случайный элемент списка
    public static Sex randomSex() {
        return value.get(random.nextInt(value.size()));
    }
}

class SortPerson implements Sort{

    @Override
    public Person[] sort(Person[] person){
        for (int i = 0; i < person.length; i++) {
            for (int j = 0; j < person.length - 1 - i; j++) {
                if ((person[j].getName().compareTo(person[j + 1].getName()) > 0 &&
                        person[j].getSex() == person[j + 1].getSex() &&
                        person[j].getAge() == person[j + 1].getAge()) ||
                        (person[j].getSex() == Sex.WOMAN && person[j + 1].getSex() == Sex.MAN) ||
                        (person[j].getSex() == person[j + 1].getSex() &&
                                person[j].getAge() < person[j + 1].getAge())) {
                    Person temp = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = temp;
                }
            }
        }

        return person;
    }
}


public class Main {
    public static void main(String[] args) {
        Person[] person = new Person[10000];
        //присваиваем полям person значения
        for (int i = 0; i < person.length; i++) {
            person[i] = (new Person(((int) (100 * Math.random())), Sex.randomSex(), Person.createName(person.length)));
            System.out.println(person[i].toString());
        }
//Сортируем
        SortPerson sortPerson = new SortPerson();
        sortPerson.sort(person);
        System.out.println("===============Результат после сортировки===================");
        for (Person value : person)
            System.out.println(value.toString());
    }
}
