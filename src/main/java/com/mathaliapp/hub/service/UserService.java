package com.mathaliapp.hub.service;

import com.mathaliapp.hub.exception.UserNotFoudException;
import com.mathaliapp.hub.model.User;
import com.mathaliapp.hub.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public User addUser (User user){
        user.setUserIdent(UUID.randomUUID().toString());
        userRepo.save(user);
        return user;
    }

    public List<User> findAllUsers(){

        return userRepo.findAll();
    }

    public User updateUser (User user){
        return userRepo.save(user);

    }
    public User findUserById(Long id){
        return userRepo.findUserById(id)
                .orElseThrow(()-> new UserNotFoudException("User where id = "+id+ "not found"));

    }
    public void deleteUserById(Long id){
         userRepo.deleteUserById(id);
    }
    @Transactional
    public void deleteUserByUserIdent(String userIdent){
        userRepo.deleteUserByUserIdent(userIdent);
    }
}
