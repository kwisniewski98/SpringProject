package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.AppUser;
import com.kwisniewski.projekt.Models.User;
import com.kwisniewski.projekt.Models.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
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

    public static void dump(String directory) throws IOException {
        String header = "id_app,id_user,filename";
        File outFile = new File(Paths.get(directory, "UserFile.csv").toString());
        outFile.delete();
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile);
        out.write(header);
        for (UserFile userFile : userFiles){
            out.write("\n" + userFile.toString());
        }
        out.close();
    }
    public static List<UserFile> findByUser(int id) {
        ArrayList<UserFile> files = new ArrayList<>();
        for(UserFile file : userFiles) {
            if (file.getId_user() == id){
                files.add(file);
            }
        }
        return files;
    }
    public static List<UserFile> findByApp(int id) {
        ArrayList<UserFile> files = new ArrayList<>();
        for(UserFile file : userFiles) {
            if (file.getId_app() == id){
                files.add(file);
            }
        }
        return files;
    }
    public static void delete(String userFile) {
        String[] fields = userFile.split(",");
        UserFile f = null;
        for (UserFile file : userFiles) {
            if (file.getId_app() == Integer.parseInt(fields[0]) &&
                file.getId_user() == Integer.parseInt(fields[1]) &&
                    file.getFilename().equals(fields[2])){
                f = file;
                break;
            }
        }
        userFiles.remove(f);
    }
}
