package org.example;

import java.util.HashMap;

public class PhoneBook {

    HashMap<String, String> phoneBook = new HashMap<>();

    public int add(String name, String number) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, number);
        }
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        return null;
    }
}

