package com.example.ProjectToSpringBoot.dao;




import com.example.ProjectToSpringBoot.model.User;

import java.util.List;

public interface UserDao {

    public void saveUser(User user);

    public void deleteUser(Long id);


    public void updateUser(long id,User updateUser);

    public User findById(Long id);

    public List<User> getAllUsers();

}
