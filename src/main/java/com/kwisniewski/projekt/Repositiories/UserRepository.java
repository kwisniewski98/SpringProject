package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {
    @Autowired
    private static List<User> users;

    public static User getUser(int id){
        return users.get(id);
    }

    public static User deleteUser(int id){
        return users.remove(id);
    }
    public static List<User> getUsers(){
        return users;
    }

    public static void addUser(int id, User user){
        users.add(id, user);
    }
    public static void addUser(User user){
        users.add(user);
    }
}
