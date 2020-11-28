package com.kwisniewski.projekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.*;

@ImportResource("classpath:beans.xml")

@SpringBootApplication
public class ProjektApplication {

    public static void main(String[] args) throws IOException {

        parseCSV("C:\\Users\\Krzysiu\\Desktop\\uczelnia\\spring\\projekt\\src\\main\\resources\\static\\csv", "C:\\Users\\Krzysiu\\Desktop\\uczelnia\\spring\\projekt\\src\\main\\resources\\beans.xml");
        ConfigurableApplicationContext ctx = SpringApplication.run(ProjektApplication.class, args);
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

