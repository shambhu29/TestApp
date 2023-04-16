package com.example.testapp.service;

import com.example.testapp.model.Category;
import com.example.testapp.model.Gender;
import com.example.testapp.model.User;
import com.example.testapp.util.UsersUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
public class UserService {

    private List<User> listOfUsers = new ArrayList<>();

    public void addUser(String name, Gender gender, String city) {
        listOfUsers.add(User
                .builder()
                .id(UsersUtil.getRandomId())
                .name(name)
                .age(UsersUtil.getRandomAge())
                .city(city)
                .gender(gender)
                .build());
    }

    public void assignCategory() {
        listOfUsers
                .stream()
                .forEach(user -> {
                    int age = user.getAge();

                    if (age > 0 && age <= 11) {
                        user.setCategory(Category.CHILDREN);
                    } else if (age > 11 && age <= 19) {
                        user.setCategory(Category.TEENAGER);
                    } else if (age > 19 && age <= 30) {
                        user.setCategory(Category.YOUNG);
                    } else if (age > 30 && age <= 55) {
                        user.setCategory(Category.MIDDLE_AGED);
                    } else if (age > 55 && age <= 100) {
                        user.setCategory(Category.OLD);
                    }
                });
    }

    public void assignMotherAndFatherToAChild() {
        Random random = new Random();
        List<User> middleAgedMale = listOfUsers.stream().filter(user -> user.getGender().equals(Gender.MALE)).filter(user -> user.getCategory().equals(Category.MIDDLE_AGED)).collect(Collectors.toList());
        List<User> middleAgedFemale = listOfUsers.stream().filter(user -> user.getGender().equals(Gender.FEMALE)).filter(user -> user.getCategory().equals(Category.MIDDLE_AGED)).collect(Collectors.toList());

        listOfUsers
                .stream()
                .filter(user -> user.getCategory().equals(Category.CHILDREN))
                .forEach(user -> {
                    user.setFathersName(middleAgedMale.get(random.nextInt(middleAgedMale.size())).getName());
                    user.setMothersName(middleAgedFemale.get(random.nextInt(middleAgedFemale.size())).getName());
                });
    }

    public void filterUsers(Gender gender) {
        log.info("logging [{}] user details", gender);
        listOfUsers
                .stream()
                .filter(user -> user.getGender().equals(gender))
                .forEach(user -> log.info("Id: {}, Name: {}, Age: {}, Gender: {}, Category: {}, Father's Name: {}, Mother's Name: {}",
                        user.getId(), user.getName(), user.getAge(), user.getGender(), user.getCategory(), user.getFathersName(), user.getMothersName()));
    }

    public void printUsersData() {
        listOfUsers.forEach(user -> log.info("User: [{}]", user.toString()));
    }
}
