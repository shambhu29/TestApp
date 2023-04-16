package com.example.testapp.util;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UsersUtil {

    private static List<String> listOfCity = List.of("Pune", "Mumbai", "Hyderabad", "Bangalore", "Delhi");

    public static String getRandomId() {
        return UUID.randomUUID().toString();
    }

    public static int getRandomAge() {
        Random random = new Random();
        return random.nextInt(99) + 1;
    }

    public static String getRandomCity() {
        Random random = new Random();
        return listOfCity.get(random.nextInt(4));
    }
}
