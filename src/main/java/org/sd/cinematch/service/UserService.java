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

    public UserService(){}

    public Collection<User> findAll(){
        return users.values();
    }

    public User findById(long id){
        return users.get(id);
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
