package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.User;
import com.kwisniewski.projekt.Repositiories.AppRepository;
import com.kwisniewski.projekt.Repositiories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
