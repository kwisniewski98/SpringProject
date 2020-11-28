package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.App;
import com.kwisniewski.projekt.Models.AppImageData;
import com.kwisniewski.projekt.Repositiories.AppImageDataRepository;
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
public class AppImageDataController {

    @GetMapping("/appimagedata")
    public String appImagedata(Model model) throws ParseException {
        model.addAttribute("appImageData", AppImageDataRepository.getAll());
        return "appImageData/appImageDataList";
    }
    @PostMapping("/appimagedata/delete/{id}")
    public String deleteAID(@PathVariable int id){
        AppImageDataRepository.delete(id);
        return "redirect:/appimagedata";
    }
    @GetMapping("/appimagedata/edit/{id}")
    public String editAIDForm(@PathVariable int id, Model model){
        model.addAttribute("aid", AppImageDataRepository.get(id));
        model.addAttribute("aidID", id);
        return "appImageData/appImageDataEditForm";
    }
    @PostMapping("/appimagedata/edit/{id}")
    public String editAID(@PathVariable int id, @Valid AppImageData appImageData,Errors errors){
        if(errors.hasErrors()) {
            return "appImageData/appImageDataEditForm";
        }
        AppImageDataRepository.delete(id);
        AppImageDataRepository.add(id, appImageData);
        return "redirect:/appimagedata";

    }
    @GetMapping("/appimagedata/add")
    public String aidForm(Model model){
        model.addAttribute("aid", new AppImageData());
        return "appImageData/appImageDataAddForm";
    }
    @PostMapping("/appimagedata/add")
    public String addAID(@Valid App app, Errors errors){
        if(errors.hasErrors()) {
            return "appImageData/appImageDataAddForm";
        }
        AppRepository.add(app);
        return "redirect:/appimagedata";

    }
}
