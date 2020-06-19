package com.example.userdeleteservice;


import com.example.userdeleteservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteController {

    @Autowired
    private com.example.userdeleteservice.UserRepository userRepository;


    @RequestMapping(path = "/delete")
    public @ResponseBody String deleteUser(@RequestParam int id)
    {
        System.out.println("Inside delete Function");
        if(userRepository.existsById(id))
        {
            System.out.println("Id exist");
            userRepository.deleteById(id);
            return "User Deleted Successfully";
        }
        else{
            return "User Deleted Failed..! User ID does not exist.";
        }

    }

}
