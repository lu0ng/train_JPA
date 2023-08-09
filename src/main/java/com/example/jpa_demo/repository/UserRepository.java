package com.example.jpa_demo.repository;

import com.example.jpa_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM user_management.login;" ,nativeQuery = true)
    List<User> getAllUser();
    User findAllById(Long id);
    @Modifying
    @Query(value = "DELETE FROM login l WHERE l.id=:id;",nativeQuery = true)
    User deleteUserById(@RequestParam("id") Long id);
}
