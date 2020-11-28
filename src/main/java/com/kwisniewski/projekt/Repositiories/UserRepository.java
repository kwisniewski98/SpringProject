package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserRepository {

    @Autowired
    private List<User> userList;

    private static List<User> users;

    @PostConstruct
    private void init(){
        users = this.userList;
    }

    public static User get(int id){
        return users.get(id);
    }

    public static User delete(int id){
        return users.remove(id);
    }
    public static List<User> getAll(){
        return users;
    }

    public static void add(int id, User user){
        users.add(id, user);
    }
    public static void add(User user){
        users.add(user);
    }

    public static User find(int userId) {
        for (User user : users){
            if (user.getId() == userId){
                return user;
            }
        }
        return null;
    }

}
