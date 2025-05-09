//Ques -> Given a list of people (name, age), filter adults (age > 18) and collect names.
package L4_ComplexOprComposition;
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}

public class q25 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 17),
                new Person("Charlie", 30),
                new Person("David", 22)
        );

        List<String> adultNames = people.stream()
                .filter(person -> person.getAge() > 18)
                .map(person -> person.getName())
                .collect(Collectors.toList());

        System.out.println("Adults: " + adultNames);
    }
}

