package com.kwisniewski.projekt.Controllers;

import com.kwisniewski.projekt.Models.UserFile;
import com.kwisniewski.projekt.Repositiories.UserFileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserFileController {

    @PostMapping("userfile/delete")
    public String removeUserFile(HttpServletRequest req, String userFile){
        UserFileRepository.delete(userFile);
        String referer = req.getHeader("Referer");
        return "redirect:" + referer;
    }
}
