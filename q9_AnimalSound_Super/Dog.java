package q9_AnimalSound_Super;

public class Dog extends Animal {
    @Override
    public void makeSound() {
        super.makeSound();  // Call base class method
        System.out.println("Dog says: Woof!");
    }
}

