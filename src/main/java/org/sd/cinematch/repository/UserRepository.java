package org.sd.cinematch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sd.cinematch.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
