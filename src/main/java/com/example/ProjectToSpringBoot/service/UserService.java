package com.example.ProjectToSpringBoot.service;



import com.example.ProjectToSpringBoot.model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);

    public void deleteUser(Long id);

    public void updateUser(long id, User user);

    public User findById(long id);

    public List<User> getAllUsers();


}
