package com.example.crudoperations;


import com.example.crudoperations.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
