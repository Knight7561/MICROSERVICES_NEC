package com.example.usersaveservice;


import com.example.usersaveservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SaveController {

    @Autowired
    private com.example.usersaveservice.UserRepository userRepository;

    @RequestMapping(path = "/save")
    public @ResponseBody
    String addNewUser(@RequestParam int id, @RequestParam String name, @RequestParam String email) {

        User user = new User();
        if (id == 0) {
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            return "User Successfully Saved.";
        } else {
            if (userRepository.existsById(id)) {
                User existingUser = new User();
                existingUser = userRepository.findById(id).get();
                existingUser.setName(name);
                existingUser.setEmail(email);
                userRepository.save(existingUser);
                return "User updated Successfully";
            }
                return "Invalid User ID";
        }

    }
}