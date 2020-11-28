package com.kwisniewski.projekt;

import com.kwisniewski.projekt.Models.AppImageData;
import com.kwisniewski.projekt.Models.AppLocation;
import com.kwisniewski.projekt.Models.UserFile;
import com.kwisniewski.projekt.Repositiories.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;

@ImportResource("classpath:beans.xml")

@SpringBootApplication
public class ProjektApplication {




    public static void main(String[] args) throws IOException {
        parseCSV("src\\main\\resources\\static\\csv", "src\\main\\resources\\beans.xml");
        SpringApplication.run(ProjektApplication.class, args);
    }

    @PreDestroy
    public void onExit() throws IOException {
        String dumpPath = "tmp";
        File f = new File(dumpPath);
        f.mkdir();
        AppImageDataRepository.dump(dumpPath);
        AppLocationRepository.dump(dumpPath);
        AppRepository.dump(dumpPath);
        AppUserRepository.dump(dumpPath);
        UserFileRepository.dump(dumpPath);
        UserRepository.dump(dumpPath);

    }

    public static void parseCSV(String csvPath, String outputFile) throws IOException {
        BufferedReader br;
        String line = "";
        String classPath = "com.kwisniewski.projekt.Models.";
        File outFile = new File(outputFile);
        outFile.delete();
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile, true);
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<beans xmlns=\"http://www.springframework.org/schema/beans\"\n" +
                "       xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "       xsi:schemaLocation=\"http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd\">\n");
        File folder = new File(csvPath);
        File[] csvFiles = folder.listFiles();
        for (int f = 0; f < csvFiles.length; f++){
            try {
                br = new BufferedReader(new FileReader(csvFiles[f]));
                String[] header = br.readLine().split(",");
                int i = 0;
                while ((line = br.readLine()) != null) {
                    String className = csvFiles[f].getName().split("\\.")[0];
                    String[] fields = line.split(",");
                    out.write("<bean name=\"" +className+i +"\" id=\"" +className + i + "\" class=\"" + classPath + className + "\">\n");
                    for ( int j = 0; j < fields.length; j++ ){
                        out.write("\t<property name=\"" + header[j] +"\" value=\""+fields[j] + "\" />\n");
                    }
                    out.write("</bean>\n");
                    i++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
         }
        out.write("</beans>");
        out.close();
    }
}

