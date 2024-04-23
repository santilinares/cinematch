package org.sd.cinematch.controller;

import java.net.URI;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.AllArgsConstructor;

import org.sd.cinematch.entity.User;
import org.sd.cinematch.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<Collection<User>> getUsers() {
        Collection<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final long id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/getuser")
    public String getUserByEmailAndPassword(
        @RequestParam String email, 
        @RequestParam String password, RedirectAttributes redirectAttributes)
        {
        User user = userService.findByEmailAndPassword(email, password);
        if(user != null){
            //redirectAttributes.addFlashAttribute("successMessage","You have successfully logged in");
            return "home";
        } else{
            //redirectAttributes.addFlashAttribute("errorMessage","You haven´t logged in");
            return "login";
        }
        

    }

    @PostMapping("/createuser")
    public String createUser(@RequestParam("name") String name, @RequestParam("email") String email, 
                @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
                User newUser = userService.save(new User(name, email, password));
                if(newUser != null){
                    redirectAttributes.addFlashAttribute("successMessage", "You have successfully logged in");
                    return "redirect:/login";
                }else{
                    redirectAttributes.addFlashAttribute("errorMessage", "You have not logged in");
                    return "redirect:/signup";
                }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletePlatform(@PathVariable final long id) {
        User user = userService.findById(id);
        if (user != null) {
            userService.deleteById(id);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> replaceUserById(@PathVariable String id, @RequestBody User newUser) {
        long userId = Long.parseLong(id);
        User user = userService.findById(userId);
        if (user != null) {
            newUser.setId(userId);
            userService.save(newUser);
            return ResponseEntity.ok().body("Completed 200 OK. User with ID " + id + " has been replaced succesfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }    

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updateUser) {
        User existingUser = userService.findById(id);
        if (existingUser != null) {
            if (updateUser.getName() != null) {
                existingUser.setName(updateUser.getName());
            }
            if (updateUser.getEmail() != null) {
                existingUser.setEmail(updateUser.getEmail());
            }
            if (updateUser.getPassword() != null) {
                existingUser.setPassword(updateUser.getPassword());
            }
            userService.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(
        @RequestParam(name = "email") final String email,
        @RequestParam(name = "password") final String password
    ) {
        userService.login(email, password);
        return ResponseEntity.ok().build();
    }

}
