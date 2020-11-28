package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.AppLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppLocationRepository {
    @Autowired
    private static List<AppLocation> appLocations;
    
    public static AppLocation getAppLocation(int id){
        return appLocations.get(id);
    }

    public static AppLocation deleteAppLocation(int id){
        return appLocations.remove(id);
    }
    public static List<AppLocation> getAppLocations(){
        return appLocations;
    }
    
    public static void addAppLocation(int id, AppLocation AppLocation){
        appLocations.add(id, AppLocation);
    }
    public static void addAppLocation(AppLocation AppLocation){
        appLocations.add(AppLocation);
    }
}
