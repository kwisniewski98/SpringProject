package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.AppImageData;
import com.kwisniewski.projekt.Models.User;
import com.kwisniewski.projekt.Models.UserFile;
import com.kwisniewski.projekt.Repositiories.AppImageDataRepository;
import com.kwisniewski.projekt.Repositiories.AppRepository;
import com.kwisniewski.projekt.Repositiories.UserFileRepository;
import com.kwisniewski.projekt.Repositiories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {
    @GetMapping("/api/users/get/{id}")
    public User getUser(@PathVariable int id) {
        return UserRepository.find(id);
    }
    @GetMapping("/api/apps/get/{id}")
    public App getApp(@PathVariable int id) {
        return AppRepository.find(id);
    }
    @GetMapping("/api/stats/user/{id}")
    public Map<String, Integer> getUserStats(@PathVariable int id) {
           Map<String, Integer> stats = new HashMap<>();
           stats.put("Files", UserFileRepository.findByUser(id).size());
           return stats;
    }

    @GetMapping("/api/stats/app/{id}")
    public Map<String, Integer> getAppStats(@PathVariable int id) {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("Files", UserFileRepository.findByApp(id).size());
        stats.put("Images", AppImageDataRepository.findByApp(id).size());
        return stats;
    }
    @GetMapping("/api/stats")
    public Map<String, String> getStats() {
        Map<String, String> stats = new HashMap<>();
        stats.put("Files", String.valueOf(UserFileRepository.getAll().size()));
        stats.put("Images", String.valueOf(AppImageDataRepository.getAll().size()));
        List<String> occ = new ArrayList<>();
        for(UserFile f : UserFileRepository.getAll()){
            String[] splittedFile = f.getFilename().split("\\.");
            String extension = splittedFile[splittedFile.length-1];
            occ.add(extension);
            }
        stats.put("most_occuring_file_extension", mostCommon(occ));
        occ = new ArrayList<>();
        for(AppImageData aid : AppImageDataRepository.getAll()){
            String[] splittedFile = aid.getImage_url().split("\\.");
            String extension = splittedFile[splittedFile.length-1];
            occ.add(extension);
        }
        stats.put("most_occuring_image_extension", mostCommon(occ));

        return stats;
    }
    public static <T> T mostCommon(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for (T t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }

        Map.Entry<T, Integer> max = null;

        for (Map.Entry<T, Integer> e : map.entrySet()) {
            if (max == null || e.getValue() > max.getValue())
                max = e;
        }

        return max.getKey();
    }
}
