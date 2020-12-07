package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.User;
import com.kwisniewski.projekt.Models.UserFile;
import com.kwisniewski.projekt.Repositiories.AppRepository;
import com.kwisniewski.projekt.Repositiories.UserFileRepository;
import com.kwisniewski.projekt.Repositiories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String users(Model model) throws ParseException {
        model.addAttribute("users", UserRepository.getAll());
        return "users/userList";
    }
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        UserRepository.delete(id);
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model){
        model.addAttribute("user", UserRepository.get(id));
        model.addAttribute("userId", id);
        return "users/userEditForm";
    }
    @PostMapping("/users/edit/{id}")
    public String editUser(@PathVariable int id, @Valid User user,Errors errors){
        if(errors.hasErrors()) {
            return "users/userEditForm";
        }
        UserRepository.delete(id);
        UserRepository.add(id, user);
        return "redirect:/users";

    }
    @GetMapping("/users/add")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "users/userAddForm";
    }
    @GetMapping("/users/files/{id}")
    public String userFiles(@PathVariable int id, Model model) {
        List<UserFile> files = UserFileRepository.findByUser(id);

        model.addAttribute("files", files);
        return "users/files";
    }
    @PostMapping("/users/add")
    public String addUser(@Valid User user, Errors errors){
        if(errors.hasErrors()) {
            return "users/userAddForm";
        }
        UserRepository.add(user);
        return "redirect:/users";

    }
    @PostMapping("/users/search")
    public String searchUser(String id, Model model){
        ArrayList<User> users = new ArrayList<>();
        try {
            users.add(UserRepository.find(Integer.parseInt(id)));
        }
        catch (NumberFormatException ignored){

        }
        model.addAttribute("users", users);
        return "users/userList";
    }
}

