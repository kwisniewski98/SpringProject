package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.User;
import com.kwisniewski.projekt.Repositiories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/users")
    public String users(Model model) throws ParseException {
        model.addAttribute("users", UserRepository.getUsers());
        return "users/userList";
    }
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        UserRepository.deleteUser(id);
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model){
        model.addAttribute("user", UserRepository.getUser(id));
        return "users/userEditForm";
    }
    @PostMapping("/users/edit/{id}")
    public String editUser(@PathVariable int id, @Valid User user,Errors errors){
        if(errors.hasErrors()) {
            return "users/userEditForm";
        }
        UserRepository.deleteUser(id);
        user.setId(user.getId()+1);
        UserRepository.addUser(id, user);
        return "redirect:/users";

    }
    @GetMapping("/users/add")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "users/userAddForm";
    }
    @PostMapping("/users/add")
    public String addUser(@Valid User user, Errors errors){
        if(errors.hasErrors()) {
            return "users/userAddForm";
        }
        UserRepository.addUser(user);
        return "redirect:/users";

    }
}
