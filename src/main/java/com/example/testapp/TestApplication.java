package com.example.testapp;

import com.example.testapp.model.Gender;
import com.example.testapp.service.UserService;
import com.example.testapp.util.UsersUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

    private static UserService userService = new UserService();

    public static void main(String[] args) {
        executeTask();
    }

    public static void executeTask() {

        //add 100 users
        for (int i = 1; i <= 100; i++) {
            userService.addUser("Test Name".concat(i + ""),
                    i % 2 == 0 ? Gender.MALE : Gender.FEMALE,
                    UsersUtil.getRandomCity()
            );
        }

        //assign category
        userService.assignCategory();

        //assign Mother and Father to a Child
        userService.assignMotherAndFatherToAChild();

        //print Male users
        userService.filterUsers(Gender.MALE);

        //print Female users
        userService.filterUsers(Gender.FEMALE);

        //print all users
        //userService.printUsersData();
    }
}
