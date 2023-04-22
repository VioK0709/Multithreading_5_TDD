package org.example;

import java.util.HashMap;

public class PhoneBook {

    HashMap<String, String> phone = new HashMap<>();

    public int add(String name, String number) {
        if (!phone.containsKey(name)) {
            phone.put(name, number);
        }
        return phone.size();
    }
}
