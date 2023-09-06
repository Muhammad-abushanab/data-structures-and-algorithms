package stack.queue.anmials;

public class Dog  extends Animal{
    public Dog(String name) {
        super.setName(name);
        super.setSpecies("Dog");
    }

    @Override
    public String toString() {
        return "Dog -> " +
                "{ " + "Name : " + super.getName() + ", Species : " + super.getSpecies() + " }";
    }
}
