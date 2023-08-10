package com.example.jpa_demo.service;

import com.example.jpa_demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jpa_demo.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
/** todo :If no custom rollback rules apply, the transaction will roll back on RuntimeException and Error but not on checked exceptions*/
 @Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private final EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUser();
    }

    public User getUserByID(Long id){return userRepository.findAllById(id);
    }
    @Transactional(rollbackOn = {Exception.class})
    public User createUser(User user){
        return userRepository.save(user);
    }
    @Transactional(rollbackOn = {Exception.class})
    public User updateUser(User user)
    {
       User usr = userRepository.findAllById(user.getId());
       usr.setName(user.getName());
       usr.setUsername(user.getUsername());
       usr.setPassword(user.getPassword());
       return userRepository.save(usr);
    }
    @Transactional(rollbackOn = {Exception.class})
    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }
    @Transactional(rollbackOn = {Exception.class})
    public void createListUserByBatch(List<User> userList) {
            userRepository.saveAll(userList);
    }
    public List<User> updateUserByBatchProcess(){
        return null;
    }
}
