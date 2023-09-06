package stack.queue.anmials;

public class Cat extends Animal{
    public Cat(String name){
        super.setName(name);
        super.setSpecies("Cat");
    }

    public String toString() {
        return "Cat -> " +
                "{ " + "Name : " + super.getName() + ", Species : " + super.getSpecies() + " }";
    }
}
