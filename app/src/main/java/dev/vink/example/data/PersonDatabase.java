package dev.vink.example.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDatabase {
    // Just an in-memory map of person class
    private static Map<Integer, Person> personDB = new HashMap<>();

    public static Person getById(int id) {
        return personDB.get(id);
    }

    public static List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        for (Person p : personDB.values()) {
            persons.add(p);
        }
        return persons;
    }

    public static int getSize() {
        return personDB.size();
    }

    public static void removePersonById(int id) {
        personDB.remove(id);
    }

    public static void addOrUpdatePerson(Person person) {
        personDB.put(person.getId(), person);
    }

    public static boolean addPerson(Person person) {
        if (personDB.containsKey(person.getId()))
            return false;

        personDB.put(person.getId(), person);
        return true;
    }

    // Other remove / add methods can be added based on the class attributes
}
