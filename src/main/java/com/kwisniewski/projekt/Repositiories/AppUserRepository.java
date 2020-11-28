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
    public static AppUser getAppUser(int id){
        return appUsers.get(id);
    }

    public static AppUser deleteAppUser(int id){
        return appUsers.remove(id);
    }
    public static List<AppUser> getAppUsers(){
        return appUsers;
    }
    
    public static void addAppUser(int id, AppUser AppUser){
        appUsers.add(id, AppUser);
    }
    public static void addAppUser(AppUser AppUser){
        appUsers.add(AppUser);
    }
}
