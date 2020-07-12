package com.example.crudoperations.models;

import java.util.List;

public class AllUsers {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(Iterable<User> users) {
        this.users = (List<User>) users;
    }
}
