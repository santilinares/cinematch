package org.sd.cinematch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

import org.sd.cinematch.model.User;
import org.sd.cinematch.service.UserService;

@RestController
@RequestMapping("/signup")
public class UserController {

    private UserService users;

    @Autowired
    public UserController(UserService users) {
        this.users = users;
    }

    @GetMapping("/")
    public Collection<User> getUsers() {
        return users.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = users.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(/* Model model, @RequestParam String name, @RequestParam String email, @RequestParam String password, */ @RequestBody User user) {        
/*         model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("password", password); */

        /* User user = new User(name, email, password); */
        users.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).body(user);
    }


}
