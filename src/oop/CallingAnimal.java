package oop;

public class CallingAnimal {
    public static void main(String[] args) {

        //Creating Animal class object
        Animal animal1 = new Animal("Dog",15,10.5d);
        animal1.printAnimalInfo();

        Animal animal2 = new Animal("Cat",16);
        animal2.printAnimalInfo();

        Animal animal3 = new Animal();

    }
}
