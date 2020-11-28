package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.AppLocation;
import com.kwisniewski.projekt.Repositiories.AppLocationRepository;
import com.kwisniewski.projekt.Repositiories.AppRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;

@Controller
public class AppLocationController {

    @GetMapping("/applocations")
    public String appLocations(Model model) throws ParseException {
        model.addAttribute("appLocations", AppLocationRepository.getAll());
        return "appLocations/appLocationList";
    }
    @PostMapping("/applocations/delete/{id}")
    public String deleteapp(@PathVariable int id){
        AppLocationRepository.delete(id);
        return "redirect:/applocations";
    }
    @GetMapping("/applocations/edit/{id}")
    public String editAppLocationForm(@PathVariable int id, Model model){
        model.addAttribute("appLocation", AppLocationRepository.get(id));
        model.addAttribute("appLocationId", id);
        return "appLocations/appLocationEditForm";
    }
    @PostMapping("/applocations/edit/{id}")
    public String editAppLocation(@PathVariable int id, @Valid AppLocation appLocation, Errors errors){
        if(errors.hasErrors()) {
            return "appLocations/appLocationEditForm";
        }
        AppLocationRepository.delete(id);
        AppLocationRepository.add(id, appLocation);
        return "redirect:/applocations";

    }
    @GetMapping("/applocations/add")
    public String appLocationForm(Model model){
        model.addAttribute("appLocation", new AppLocation());
        return "appLocations/appLocationAddForm";
    }
    @PostMapping("/applocations/add")
    public String addAppLocation(@Valid AppLocation appLocation, Errors errors){
        if(errors.hasErrors()) {
            return "appLocations/appLocationAddForm";
        }
        AppLocationRepository.add(appLocation);
        return "redirect:/applocations";

    }
}
