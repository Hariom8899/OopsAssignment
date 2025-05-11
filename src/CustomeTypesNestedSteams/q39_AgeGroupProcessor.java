package CustomeTypesNestedSteams;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
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
public class q39_AgeGroupProcessor {

    public static Map<String, List<Person>> groupPeopleByAge(List<Person> people) {
        // Group people by age group
        return people.stream()
                .collect(Collectors.groupingBy(person -> {
                    int age = person.getAge();
                    if (age < 20) {
                        return "<20";
                    } else if (age <= 40) {
                        return "20-40";
                    } else {
                        return "40+";
                    }
                }));
    }

    public static void main(String[] args) {
        // Sample list of people
        List<Person> people = List.of(
                new Person("Alice", 18),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 50),
                new Person("Edward", 60),
                new Person("Fiona", 15)
        );

        // Group people by age and print the result
        Map<String, List<Person>> ageGroups = groupPeopleByAge(people);

        // Output the result
        ageGroups.forEach((ageGroup, groupMembers) -> {
            System.out.println(ageGroup + ":");
            groupMembers.forEach(person -> System.out.println("  - " + person.getName() + " (Age: " + person.getAge() + ")"));
        });
    }
}

