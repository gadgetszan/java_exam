package javadeveloper.exam.polymorphism;

import java.sql.SQLOutput;
import java.util.ArrayList;

interface Transportable{
    void transport();
}

abstract class Animal {
    String animalType;
    String animalName;
    String typeAndName;

    public Animal(String animalType,String animalName){
        this.animalType = animalType;
        this.animalName = animalName;
        this.typeAndName = setTypeAndName(animalType,animalName);
    }

    public Animal(String animalName){
        this.animalName = animalName;
        this.typeAndName = setTypeAndName("Unknown",animalName);
    }

    public void eat(){
        System.out.println(typeAndName + " is eating");
    }

    public void sleep(){
        System.out.println(typeAndName + " is sleeping");
    }

    public void play(){
        System.out.println(typeAndName + " is playing");
    }

    private String setTypeAndName(String animalType,String animalName){
        return "The " + animalType + " named " + animalName;
    };

    public abstract void animalSound();

}

class Cat extends Animal implements Transportable{
    public Cat(String animalName) {
        super("Cat",animalName);
    }

    @Override
    public void animalSound() {
        System.out.println("Meow");
    }

    @Override
    public void transport() {
        System.out.println("This cat can be transported to a small crate");
    }
}

class Dog extends Animal implements Transportable{
    public Dog(String animalName) {
        super("Dog",animalName);
    }

    @Override
    public void animalSound() {
        System.out.println("Arf Arf");
    }


    @Override
    public void transport() {
        System.out.println("This dog can be transported to a Medium crate");
    }
}



public class Polymorphism {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Barky");
        Cat cat1 = new Cat("Meowwy");

        ArrayList<Cat> myCats = new ArrayList<Cat>();
        myCats.add(cat1);
//        myCats.add(dog1);

        ArrayList<Dog> myDogs = new ArrayList<Dog>();
        myDogs.add(dog1);
//        myDogs.add(cat1);

        ArrayList<Animal> myPets = new ArrayList<Animal>();
        myPets.add(dog1);
        myPets.add(cat1);

        myPets.get(0).eat();
        myPets.get(0).animalSound();
        myPets.get(1).play();
        myPets.get(1).animalSound();


        ArrayList<Transportable> myTransportablePets = new ArrayList<Transportable>();
        myTransportablePets.add(cat1);
        myTransportablePets.add(dog1);

        myTransportablePets.get(0).transport();
        myTransportablePets.get(1).transport();

        }
}
