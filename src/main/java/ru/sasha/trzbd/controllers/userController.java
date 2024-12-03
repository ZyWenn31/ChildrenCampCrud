package ru.sasha.trzbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sasha.trzbd.dao.UserDAO;
import ru.sasha.trzbd.models.User;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class userController {

    private final UserDAO userDAO;

    @Autowired
    public userController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String login(@ModelAttribute("user")User user){
        return "user/login";
    }

    @PostMapping()
    public String postLogin(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "user/login";
        }
        if (userDAO.loginUser(user) == null)
        {
            return "user/notAccess";
        } else {
            return "user/access";
        }
    }
}
