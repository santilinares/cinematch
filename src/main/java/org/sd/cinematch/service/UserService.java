package org.sd.cinematch.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.sd.cinematch.entity.User;
import org.sd.cinematch.repository.UserRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(final long id){
        Optional<User> optionalPlatform = userRepository.findById(id);
        if (optionalPlatform.isPresent()) {
         return optionalPlatform.get();
        } else {
         throw new RuntimeException("User not found");
        }
    }

    public User findByEmailAndPassword(final String email, final String password) {
        User possibleUser = userRepository.findByEmailAndPassword(email, password);
        if (Objects.isNull(possibleUser)) {
            throw new RuntimeException("User not found");
        } else {
            return possibleUser;
        }
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

    public void login(final String email, final String password) {
        if (Objects.isNull(userRepository.findByEmailAndPassword(email, password))) {
            throw new RuntimeException("User not found, should register");
        }
    }
}
