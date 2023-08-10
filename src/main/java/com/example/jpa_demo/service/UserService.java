package com.example.jpa_demo.service;

import com.example.jpa_demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jpa_demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.getAllUser();
    }

    public User getUserByID(Long id){return userRepository.findAllById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(User user)
    {
       User usr = userRepository.findAllById(user.getId());
       usr.setName(user.getName());
       usr.setUsername(user.getUsername());
       usr.setPassword(user.getPassword());
       return userRepository.save(usr);
    }
    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }
    public void createListUserByBatch() {

        }
    public List<User> updateUserByBatchProcess(){
        return null;
    }
}
