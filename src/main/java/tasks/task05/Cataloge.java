package tasks.task05;


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Cataloge {

    static Map<Integer, Pet> pets = new TreeMap<>();
    ArrayList<Pet> values = new ArrayList<Pet>(pets.values());

    public void addPet(Pet pet) throws Exception {

        pets.put(pet.id, pet);

    }

    public void search(String name) {
        for (Pet pet : values) {
            if (name.equals(pet.getName())) {
                System.out.println(pets.get(pet.getId()));
            }
        }
    }

    public void print() {
        if (pets != null) {
            System.out.println(pets.toString());
        }
    }

    public void update(int id, String name, Person person, double weigth) {
        pets.get(id).setName(name);
        pets.get(id).setPerson(person);
        pets.get(id).setWeight(weigth);
    }

    public void sort() {
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.size() - 1 - i; j++) {
                if ((values.get(j).getPerson().getName().compareTo(values.get(j + 1).getPerson().getName()) > 0 &&
                        values.get(j).getPerson().getSex() == values.get(j + 1).getPerson().getSex() &&
                        values.get(j).getPerson().getAge() == values.get(j + 1).getPerson().getAge()) ||
                        (values.get(j).getPerson().getSex() == Sex.WOMAN && values.get(j + 1).getPerson().getSex() == Sex.MAN) ||
                        (values.get(j).getPerson().getSex() == values.get(j + 1).getPerson().getSex() &&
                                values.get(j).getPerson().getAge() < values.get(j + 1).getPerson().getAge())) {
                    Pet temp = values.get(j);
                    values.set(j, values.get(j + 1));
                    values.set((j + 1), temp);
                }
            }
            System.out.println(values.get(i));
        }
        for(Pet pet: values){
            System.out.println(pet);
        }
    }
}
