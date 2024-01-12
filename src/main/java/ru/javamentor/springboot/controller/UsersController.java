package ru.javamentor.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.springboot.model.User;
import ru.javamentor.springboot.service.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/allusers")
    public String getListUsers(ModelMap model) {
        model.addAttribute("users",userService.getListUsers());
        return "pages/listusers";
    }

    @GetMapping(value = "/user")
    public String getUser(Model model, @RequestParam(value = "id", required = false) Integer id) {
        model.addAttribute("user",userService.getUser(id));
        return "pages/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "pages/new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/allusers";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id", required = false) Integer id,
                           @ModelAttribute("user") User user) {
        model.addAttribute("user",userService.getUser(id));
        return "pages/edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/allusers";
    }

    @GetMapping("/delete")
    public String deleteUser(Model model, @RequestParam(value = "id", required = false) Integer id,
                           @ModelAttribute("user") User user) {
        model.addAttribute("user",userService.getUser(id));
        return "pages/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user);
        return "redirect:/allusers";
    }
}
