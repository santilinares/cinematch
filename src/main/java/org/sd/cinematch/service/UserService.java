package org.sd.cinematch.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import java.util.Collection;
import org.sd.cinematch.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();
    private AtomicLong nextId = new AtomicLong(1);

    public UserService(){
        save(new User("Santi", "santilinares@gmail.com", "1234"));
        save(new User("Mireya", "mireyaa23@gmail.com", "4323"));
        save(new User("Frascuelo", "elfrascu23@gmail.com", "2368"));
    }

    public Collection<User> findAll(){
        return users.values();
    }

    public User findById(long id){
        return users.get(id);
    }    

    public User findByEmailAndPassword(String email, String password) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; // User not found
    }

    public void save(User user) {
        if(user.getId() == null || user.getId() == 0) {
            long id = nextId.getAndIncrement();
            user.setId(id);            
        }

        this.users.put(user.getId(), user);
    }

    public void deleteById(long id){
        this.users.remove(id);
    }
}
