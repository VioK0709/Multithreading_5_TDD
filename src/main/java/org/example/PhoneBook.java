package org.example;

import java.util.*;

public class PhoneBook {

    HashMap<String, String> phoneBook = new HashMap<>();

    public int add(String name, String number) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        return phoneBook.entrySet().stream()
                .filter(e -> e.getValue().equals(number))
                .map(HashMap.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }

    public List<String> printAllNames() {
        List<String> result = new ArrayList<>();
        for (String key : phoneBook.keySet()) {
            result.add(key.replaceAll("[\\[\\]]", ""));
        }
        return result;
    }
}

