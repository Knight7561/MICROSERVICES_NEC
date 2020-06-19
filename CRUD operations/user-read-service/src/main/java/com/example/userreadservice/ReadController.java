package com.example.userreadservice;


import com.example.userreadservice.models.AllUsers;
import com.example.userreadservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class ReadController {

    @Autowired
    private com.example.userreadservice.UserRepository userRepository;
    @RequestMapping("/all")
    public @ResponseBody AllUsers getAllUsers()
    {
        AllUsers allUsers= new AllUsers();
        allUsers.setUsers(userRepository.findAll());
        System.out.print(allUsers);
        return allUsers;
    }
    @RequestMapping("/getUserByID")
    public @ResponseBody Optional<User> getUserById(@RequestParam int id)
    {
            return userRepository.findById(id);
    }
//    @RequestMapping("/getUserByPartialName")
//    public @ResponseBody AllUsers getUserByPartialName(@RequestParam String partialName)
//    {
//        AllUsers existingUsers=new AllUsers();
//        existingUsers=userRepository.findByName(partialName);
//        System.out.print(existingUsers);
//        return existingUsers;
//    }
}
