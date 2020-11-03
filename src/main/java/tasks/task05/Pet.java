package tasks.task05;


public class Pet{

    int id;
    private String name;
    Person person;
    private double weight;

    public Pet(int id, String name,Person person ,double weight) {
        this.id = id;
        this.name = name;
        this.person = person;
        this.weight = weight;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}'+ "\n";
    }
}
