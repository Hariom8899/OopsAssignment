package q9_AnimalSound_Super;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        super.makeSound();  // Call base class method
        System.out.println("Cat says: Meow!");
    }
}
