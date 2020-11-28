package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.AppImageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppImageDataRepository {
    @Autowired
    private static List<AppImageData> appImageData;

    public static AppImageData getAppImageData(int id){
        return appImageData.get(id);
    }

    public static AppImageData deleteAppImageData(int id){
        return appImageData.remove(id);
    }
    public static List<AppImageData> getAppImageData(){
        return appImageData;
    }

    public static void addAppImageData(int id, AppImageData AppImageData){
        appImageData.add(id, AppImageData);
    }
    public static void addAppImageData(AppImageData AppImageData){
        appImageData.add(AppImageData);
    }
}
