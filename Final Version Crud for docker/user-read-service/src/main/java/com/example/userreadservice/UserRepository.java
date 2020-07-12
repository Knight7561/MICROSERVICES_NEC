package com.example.userreadservice;


import com.example.userreadservice.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
//    @Query("SELECT * FROM db_example e WHERE e.name LIKE %?1%")
//    public AllUsers findByName(String name);
}
