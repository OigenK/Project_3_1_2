package com.example.ProjectToSpringBoot.dao;


import com.example.ProjectToSpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User userToUpdate = findById(id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setAge(updatedUser.getAge());
    }
    @Override
    public User findById(Long id) {
        return  entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
}
