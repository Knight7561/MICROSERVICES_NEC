package com.example.userreadservice;


import com.example.userreadservice.models.AllUsers;
import com.example.userreadservice.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
//    @Query("SELECT * FROM db_example e WHERE e.name LIKE %?1%")
//    public AllUsers findByName(String name);
}
