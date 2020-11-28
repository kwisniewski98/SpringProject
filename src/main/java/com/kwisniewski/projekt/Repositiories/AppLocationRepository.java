package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.AppImageData;
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
public class AppLocationRepository extends DumpableRepository {
    @Autowired
    private List<AppLocation> appLocationList;

    private static List<AppLocation> appLocations;

    @PostConstruct
    private void init(){
        appLocations = this.appLocationList;
    }
    public static AppLocation get(int id){
        return appLocations.get(id);
    }

    public static AppLocation delete(int id){
        return appLocations.remove(id);
    }
    public static List<AppLocation> getAll(){
        return appLocations;
    }
    
    public static void add(int id, AppLocation AppLocation){
        appLocations.add(id, AppLocation);
    }
    public static void add(AppLocation AppLocation){
        appLocations.add(AppLocation);
    }

    public static void dump(String directory) throws IOException {
        String header = "id,id_app,city,street,street_number,country";
        File outFile = new File(Paths.get(directory, "AppLocation.csv").toString());
        outFile.delete();
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile);
        out.write(header);
        for (AppLocation appLocation: appLocations){
            out.write("\n" + appLocation.toString());
        }
        out.close();
    }
}
