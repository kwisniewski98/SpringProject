package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.User;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private List<User> users;


    @GetMapping("/users")
    public String users(Model model) throws ParseException {
        model.addAttribute("users", users);
        return "userList";
    }
    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        users.remove(id);
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
    public String editUserForm(@PathVariable int id, Model model){
        model.addAttribute("user", users.get(id));
        return "userEditForm";
    }
    @PostMapping("/users/edit/{id}")
    public String editUser(@PathVariable int id, @Valid User user,Errors errors){
        if(errors.hasErrors()) {
            return "userEditForm";
        }
        users.remove(id);
        users.add(id, user);
        return "redirect:/users";

    }
    @GetMapping("/users/add")
    public String userForm(Model model){
        model.addAttribute("user", new User());
        return "userAddForm";
    }
    @PostMapping("/users/add")
    public String addUser(@Valid User user, Errors errors){
        if(errors.hasErrors()) {
            return "userAddForm";
        }
        users.add(user);
        return "redirect:/users";

    }
}
