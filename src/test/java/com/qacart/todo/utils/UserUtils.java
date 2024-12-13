package com.qacart.todo.utils;

import com.github.javafaker.Faker;
import com.qacart.todo.object.User;

public class UserUtils {
    public static User generateRandomUser(){
        String firstName =new Faker().name().firstName();
        String lastName =new Faker().name().firstName();
        String email =new Faker().internet().emailAddress();

        User user =new User(firstName,lastName,email,"password");
        return user;
    }
}
