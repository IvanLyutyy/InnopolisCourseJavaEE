package tasks.task05;

/**
 * Разработать программу – картотеку домашних животных. У каждого животного есть уникальный идентификационный номер, кличка, хозяин (объект класс Person с полями – имя, возраст, пол), вес.
 *
 * Реализовать:
 *
 * метод добавления животного в общий список (учесть, что добавление дубликатов должно приводить к исключительной ситуации)
 * поиск животного по его кличке (поиск должен быть эффективным)
 * изменение данных животного по его идентификатору
 * вывод на экран списка животных в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.a
 */


public class Main {
    public static void main(String[] args) throws Exception {
        Person Svetlana = new Person("Svetlana",18, Sex.WOMAN);
        Person Andrey = new Person("Andrey",39, Sex.MAN);
        Person Irina = new Person("Irina",56, Sex.WOMAN);
        Person Oleg = new Person("Oleg",18, Sex.MAN);
        Person Svetlana1 = new Person("Svetlana",30, Sex.WOMAN);
        Person Pavel = new Person("Pavel",22, Sex.MAN);
        Person Olga = new Person("Olga",40, Sex.WOMAN);
        Person Yulia = new Person("Yulia",27, Sex.WOMAN);
        Person Roman = new Person("Roman",22, Sex.MAN);

        Pet catBarsik = new Pet(1, "Barsik", Svetlana, 3.5);
        Pet dogTuzik = new Pet(2, "Tuzik", Svetlana1, 10);
        Pet catVaska = new Pet(3, "Vaska", Andrey, 4);
        Pet parrot = new Pet(4, "Kuzya", Irina, 0.5);
        Pet dogSharik = new Pet(5, "Sharik", Oleg, 8);
        Pet lionSimba = new Pet(6, "Simba", Pavel, 40);
        Pet catGav = new Pet(7, "Gav", Olga, 2.7);
        Pet dogPolkan = new Pet(8, "Polkan", Yulia, 12);
        Pet hamster = new Pet(9, "PiPi", Roman, 0.3);
        Pet catTishka = new Pet(10, "Tishka", Yulia, 3);
        Pet enot = new Pet(11, "Enot", Irina, 0.7);
        Pet snake = new Pet(12, "Snake", Pavel, 1);
        Cataloge cataloge = new Cataloge();

        cataloge.addPet(catBarsik);
        cataloge.addPet(dogTuzik);
        cataloge.addPet(catVaska);
        cataloge.addPet(parrot);
        cataloge.addPet(dogSharik);
        cataloge.addPet(lionSimba);
        cataloge.addPet(catGav);
        cataloge.addPet(dogPolkan);
        cataloge.addPet(hamster);
        cataloge.addPet(catTishka);
        cataloge.addPet(enot);
        cataloge.addPet(snake);
        cataloge.print();
        cataloge.search("Sharik");

        cataloge.update(4, "Bobik", Olga, 14);
        cataloge.print();
    }
}
