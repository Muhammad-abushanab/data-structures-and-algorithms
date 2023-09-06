package stack.queue.anmials;

import stack.queue.queue.Queue;

public class AnimalShelter {
    private final Queue<Dog> dogs;
    private final Queue<Cat> cats;

    public AnimalShelter() {
        this.cats = new Queue<>();
        this.dogs = new Queue<>();
    }

    public void enqueue(Animal animal) {
        String className = animal.getClass().getSimpleName();
        if (className.equals("Cat")) {
            cats.enqueue((Cat) animal);
        } else if (className.equals("Dog")) {
            dogs.enqueue((Dog) animal);
        } else throw new IllegalArgumentException("Should provide an Dog or Cat Object");
    }

    public Animal dequeue(String pref) {
        if (pref.equalsIgnoreCase("cat")) {
            return cats.dequeue();
        } else if (pref.equalsIgnoreCase("dog")) {
            return dogs.dequeue();
        } else return null;
    }

    public String getCats() {
        return cats.toString();
    }

    public String getDogs() {
        return dogs.toString();
    }
    public String getShelter(){
        return dogs + " " + cats;
    }
}
