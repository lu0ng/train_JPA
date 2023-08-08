package com.example.jpa_demo.controller;
import com.example.jpa_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.jpa_demo.repository.UserRepository;
import com.example.jpa_demo.service.UserService;
import java.util.List;
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
        @GetMapping("/user")
        public ResponseEntity<?> getAllUser() {
            try {
                List<User> userList = userService.getAllUsers();
                return new ResponseEntity<>(userList, HttpStatus.OK);
            }
            catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping("/user/{id}")
        public ResponseEntity<?> getUserByID(@PathVariable("id") Long id) {
            try {
                User user = userService.getUserByID(id);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @PostMapping("/user")
        public ResponseEntity<?> createUser(@RequestBody User usr){
            try{
                User user = userService.createUser(usr);
                return new ResponseEntity<>(user,HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        @PutMapping("/user")
        public ResponseEntity<?> updateUserById(@RequestBody User user)
        {
            try {
                    userService.updateUser(user);
                    return new ResponseEntity<>("Cap nhat thanh cong",HttpStatus.OK);
                }
            catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        }
        @DeleteMapping("user/{id}")
        public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id){
            try {
                userService.deleteUserByID(id);
                return new ResponseEntity<>("xoa thanh cong",HttpStatus.NO_CONTENT);
            }
            catch (Exception e){
                return new ResponseEntity<>("xoa khong thanh cong",HttpStatus.NOT_FOUND);
            }
        }

}
