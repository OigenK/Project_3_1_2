package com.example.ProjectToSpringBoot.controller;


import com.example.ProjectToSpringBoot.model.User;
import com.example.ProjectToSpringBoot.service.UserService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "create-user";
    }

    @PostMapping("/")
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit-user";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/";
    }

}