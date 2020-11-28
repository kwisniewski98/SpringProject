package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class AppUserRepository {

    @Autowired
    private List<AppUser> appUserList;

    private static List<AppUser> appUsers;

    @PostConstruct
    private void init(){
        appUsers = this.appUserList;
    }
    public static AppUser get(int id){
        return appUsers.get(id);
    }

    public static AppUser delete(int id){
        return appUsers.remove(id);
    }
    public static List<AppUser> getAll(){
        return appUsers;
    }
    
    public static void add(int id, AppUser AppUser){
        appUsers.add(id, AppUser);
    }
    public static void add(AppUser AppUser){
        appUsers.add(AppUser);
    }
}
