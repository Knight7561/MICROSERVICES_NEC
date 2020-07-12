package com.example.userdeleteservice;


import com.example.userdeleteservice.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
