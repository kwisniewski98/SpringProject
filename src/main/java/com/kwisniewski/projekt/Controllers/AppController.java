package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Repositiories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class AppController {

    @GetMapping("/apps")
    public String apps(Model model) throws ParseException {
        model.addAttribute("apps", AppRepository.getApps());
        return "apps/appList";
    }
    @PostMapping("/apps/delete/{id}")
    public String deleteapp(@PathVariable int id){
        AppRepository.deleteApp(id);
        return "redirect:/apps";
    }
    @GetMapping("/apps/edit/{id}")
    public String editAppForm(@PathVariable int id, Model model){
        model.addAttribute("app", AppRepository.getApp(id));
        return "apps/appEditForm";
    }
    @PostMapping("/apps/edit/{id}")
    public String editApp(@PathVariable int id, @Valid App app,Errors errors){
        if(errors.hasErrors()) {
            return "apps/appEditForm";
        }
        AppRepository.deleteApp(id);
        app.setId(app.getId()+1);
        AppRepository.addApp(id, app);
        return "redirect:/apps";

    }
    @GetMapping("/apps/add")
    public String appForm(Model model){
        model.addAttribute("app", new App());
        return "apps/appAddForm";
    }
    @PostMapping("/apps/add")
    public String addapp(@Valid App app, Errors errors){
        if(errors.hasErrors()) {
            return "apps/appAddForm";
        }
        AppRepository.addApp(app);
        return "redirect:/apps";

    }
}
