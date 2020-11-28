package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFileRepository {
    @Autowired
    private static List<UserFile> userFiles;

    public static UserFile getUserFile(int id){
        return userFiles.get(id);
    }

    public static UserFile deleteUserFile(int id){
        return userFiles.remove(id);
    }
    public static List<UserFile> getUserFiles(){
        return userFiles;
    }

    public static void addUserFile(int id, UserFile UserFile){
        userFiles.add(id, UserFile);
    }
    public static void addUserFile(UserFile UserFile){
        userFiles.add(UserFile);
    }
}
