package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.User;
import com.kwisniewski.projekt.Models.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class UserFileRepository {
    @Autowired
    private List<UserFile> userFileList;

    private static List<UserFile> userFiles;

    @PostConstruct
    private void init(){
        userFiles = this.userFileList;
    }
    public static UserFile get(int id){
        return userFiles.get(id);
    }

    public static UserFile delete(int id){
        return userFiles.remove(id);
    }
    public static List<UserFile> getAll(){
        return userFiles;
    }

    public static void add(int id, UserFile UserFile){
        userFiles.add(id, UserFile);
    }
    public static void add(UserFile UserFile){
        userFiles.add(UserFile);
    }

}
