package com.Geekster.UserManagementSystem.controller;

import com.Geekster.UserManagementSystem.model.User;
import com.Geekster.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userManagement")
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)

    public List<User> allUsers() {
        return userService.getUsers();
    }

    @RequestMapping (value = "/user/{id}", method = RequestMethod.GET)

    public User userById (@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public String addUser(@Valid @RequestBody User user) {
        boolean isAdded = userService.addUser(user);
        if (isAdded) return "User Added";
        return "User Not Added";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)

    public String delUser(@PathVariable String id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) return "User Deleted";
        return "User Not Deleted";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)

    public String updateUser(@PathVariable String id, @RequestBody User user) {
        boolean isUpdated = userService.updateUser(id, user);
        if(isUpdated) return "User Updated";
        return "User updating Failed";
    }
}
