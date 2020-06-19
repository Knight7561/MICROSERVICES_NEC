package com.example.crudoperations;


import com.example.crudoperations.models.AllUsers;
import com.example.crudoperations.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private com.example.crudoperations.UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/addUser")
    public @ResponseBody String callUpdateUser(@RequestParam int id,@RequestParam String name, @RequestParam String email)
    {
        return restTemplate.getForObject("http://user-save-service/save/?id="+id+"&&name="+name+"&&email="+email,String.class);
    }
    @RequestMapping("/getAllUsers")
    public @ResponseBody AllUsers callAllUsers()
    {
        return restTemplate.getForObject("http://user-read-service/all",AllUsers.class );
    }
    @RequestMapping("/getUserByID")
    public @ResponseBody User getUsersById(@RequestParam int id)
    {
        User requiredUser=new User();
        requiredUser=restTemplate.getForObject("http://user-read-service/getUserByID?id="+id,User.class );
        if(requiredUser==null)
        {
            requiredUser=new User();
            requiredUser.setName("Invalid ID");
            requiredUser.setEmail("Invalid ID");
            requiredUser.setId(0);
        }
        return requiredUser;
    }
    @RequestMapping(path = "/deleteUser")
    public @ResponseBody String deleteUser(@RequestParam int id)
    {
        System.out.println("Inside deleteuser");
        return restTemplate.getForObject("http://user-delete-service/delete?id="+id,String.class);
    }
}
