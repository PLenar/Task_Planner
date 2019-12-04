package pl.piotrlenar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.piotrlenar.entities.User;
import pl.piotrlenar.model.UserDto;
import pl.piotrlenar.repositories.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomePageController {


    @RequestMapping()
    public String getHome(){
        return "homePage";
    }


}
