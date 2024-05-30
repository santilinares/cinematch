package org.sd.cinematch.repository;

import org.sd.cinematch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByName(String name);   
    User findByEmailAndPassword(String email, String password);
}
