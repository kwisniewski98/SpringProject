package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.AppLocation;
import com.kwisniewski.projekt.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Component
public class AppRepository {

    @Autowired
    private List<App> appList;

    private static List<App> apps;

    @PostConstruct
    private void init(){
        apps = this.appList;
    }
    public static App get(int id){
        return apps.get(id);
    }

    public static App delete(int id){
        return apps.remove(id);
    }
    public static List<App> getAll(){
        return apps;
    }
    
    public static void add(int id, App app){
        apps.add(id, app);
    }
    public static void add(App app){
        apps.add(app);
    }

    public static void dump(String directory) throws IOException {
        String header = "id,name,domain,version";
        File outFile = new File(Paths.get(directory, "App.csv").toString());
        outFile.delete();
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile);
        out.write(header);
        for (App app : apps){
            out.write("\n" + app.toString());
        }
        out.close();
    }

    public static App find(int userId) {
        for (App app : apps){
            if (app.getId() == userId){
                return app;
            }
        }
        return null;
    }
}
