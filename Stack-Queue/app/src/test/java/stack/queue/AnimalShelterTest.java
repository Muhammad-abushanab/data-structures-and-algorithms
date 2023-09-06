package stack.queue;

import org.junit.jupiter.api.Test;
import stack.queue.anmials.Animal;
import stack.queue.anmials.AnimalShelter;
import stack.queue.anmials.Cat;
import stack.queue.anmials.Dog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AnimalShelterTest {
    @Test
    public void catClassTest() {
        Cat cat = new Cat("cat1");
        Animal animalCat = new Cat("cat2");

        assertEquals( "cat1", cat.getName());
        assertEquals( "Cat", animalCat.getClass().getSimpleName());
    }
    @Test
    public void dogClassTest() {
        Dog dog = new Dog("dog1");
        Animal animalDog = new Dog("dog2");

        assertEquals( "dog1", dog.getName());
        assertEquals( "Dog", animalDog.getClass().getSimpleName());
    }

    @Test
    public void enqueueTest() {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));

        assertEquals( "front -> { Cat -> { Name : cat1, Species : Cat } } -> { Cat -> { Name : cat2, Species : Cat } } <- rear", shelter.getCats());
        assertEquals( "front -> { Dog -> { Name : dog1, Species : Dog } } <- rear", shelter.getDogs());
    }

    @Test
    public void dequeueTest() {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Cat("cat1"));
        shelter.enqueue(new Dog("dog1"));
        shelter.enqueue(new Cat("cat2"));
        shelter.dequeue("cat");
        shelter.dequeue("dog");
        assertEquals( "front -> { Cat -> { Name : cat2, Species : Cat } } <- rear", shelter.getCats());
        assertNull( shelter.dequeue("bird"));
        assertEquals( "front -> rear", shelter.getDogs());
        assertEquals( "front -> { Cat -> { Name : cat2, Species : Cat } } <- rear", shelter.getCats());
    }
}
