package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
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

    public static void dump(String directory) throws IOException {
        String header = "id_app,id_user";
        File outFile = new File(Paths.get(directory, "AppUser.csv").toString());
        outFile.delete();
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile);
        out.write(header);
        for (AppUser appUser : appUsers){
            out.write("\n" + appUser.toString());
        }
        out.close();
    }
}
