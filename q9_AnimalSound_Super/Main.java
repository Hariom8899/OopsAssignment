package q9_AnimalSound_Super;

public class Main {
    public static void main(String[] args) {
        Animal myCat = new Cat();
        Animal myDog = new Dog();

        System.out.println("Cat:");
        myCat.makeSound();

        System.out.println("\nDog:");
        myDog.makeSound();
    }
}

