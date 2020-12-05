package com.kwisniewski.projekt.Repositiories;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.AppImageData;
import com.kwisniewski.projekt.Models.User;
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
public class AppImageDataRepository extends DumpableRepository{
    @Autowired
    private List<AppImageData> appImageDataList;

    private static List<AppImageData> appImageData;

    @PostConstruct
    private void init(){
        appImageData = this.appImageDataList;
    }
    public static AppImageData get(int id){
        return appImageData.get(id);
    }

    public static AppImageData delete(int id){
        return appImageData.remove(id);
    }
    public static List<AppImageData> getAll(){
        return appImageData;
    }

    public static void add(int id, AppImageData AppImageData){
        appImageData.add(id, AppImageData);
    }
    public static void add(AppImageData AppImageData){
        appImageData.add(AppImageData);
    }

    public static void dump(String directory) throws IOException {
        String header = "id,id_app,image_url";
        File outFile = new File(Paths.get(directory, "AppImageData.csv").toString());
        outFile.delete();
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile);
        out.write(header);
        for (AppImageData aid : appImageData){
            out.write("\n" + aid.toString());
        }
        out.close();
    }
    public static List<AppImageData> findByApp(int id) {
        ArrayList<AppImageData> list = new ArrayList<>();
        for(AppImageData aid : appImageData) {
            if (aid.getId_app() == id) {
                list.add(aid);
            }
        }
        return list;
    }
}
