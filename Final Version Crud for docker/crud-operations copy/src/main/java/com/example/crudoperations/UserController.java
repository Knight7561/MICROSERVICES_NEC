package com.example.crudoperations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "/demo")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/addUser")
    public @ResponseBody String callUpdateUser(@RequestParam int id,@RequestParam String name, @RequestParam String email)
    {
        return "Hello";
    }

}
