package pl.piotrlenar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.piotrlenar.entities.User;
import pl.piotrlenar.model.UserDto;
import pl.piotrlenar.repositories.UserRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String getRegister(Model m){
        m.addAttribute("user", new UserDto());
        return "registration-form";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("user") UserDto userDto, BindingResult br){
        if(userDto.getPassword() != null &&
                !userDto.getPassword().trim().equals("") &&
                !userDto.getPassword().equals(userDto.getRepeatPassword())) {
            br.rejectValue("repeatPassword", "PasswordsDoNotMatch", "Passwords must match");
        }
        if(br.hasErrors()) {
            return "registration-form";
        }

        User user = new User(userDto);

        this.userRepository.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String login(Model m){
        m.addAttribute("user", new UserDto());

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(UserDto loginData, Model m, HttpSession s) {
        User user = this.userRepository.findByEmail(loginData.getEmail());
        if(user==null){
            m.addAttribute("user", loginData);
            m.addAttribute("msg", "User not found");
            return "login";
        }

        if(!user.isPasswordCorrect(loginData.getPassword())){
            m.addAttribute("user", loginData);
            m.addAttribute("msg", "Wrong password");
            return "login";
        }

        s.setAttribute("loggedInUser", user);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession s){
        s.removeAttribute("loggedInUser");

        return "redirect:login";
    }

    @RequestMapping("/manage")
    public String user() {
        return "manageProject";
    }

}
