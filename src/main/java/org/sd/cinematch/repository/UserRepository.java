package org.sd.cinematch.repository;

import org.sd.cinematch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByName(String name);   
    /* Hacerlo para consultar personalizadas que no tiene predefinida Jpa */
    /* ?1 es el primer argumento */
    User findByEmailAndPassword(String email, String password);
}
