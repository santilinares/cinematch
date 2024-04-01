package org.sd.cinematch.controller;

import java.net.URI;
import java.util.Collection;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import org.sd.cinematch.model.Platform;
import org.sd.cinematch.service.PlatformService;

@RestController
@RequestMapping("/platform")
public class PlatformController {

    private PlatformService platforms;

    public PlatformController(PlatformService plataforms) {
        this.platforms = plataforms;
    }

    @GetMapping("/")
    public Collection<Platform> getPlatform() {
        return platforms.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platform> getPlatform(@PathVariable long id) {
        Platform platform = platforms.findById(id);
        if (platform != null) {
            return ResponseEntity.ok(platform);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Platform> createPlatform(@RequestBody Platform platform) {        
        platforms.save(platform);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(platform.getId())
                .toUri();
        return ResponseEntity.created(location).body(platform);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Platform> deletePlatform(@PathVariable long id){
        Platform platform = platforms.findById(id);
          if (platform != null) {
            platforms.deleteById(id);
            return ResponseEntity.ok(platform);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Platform> replacePlatform(@PathVariable long id, @RequestBody Platform newPlatform) {
        Platform platform = platforms.findById(id);
        if (platform != null) {
            newPlatform.setId(id);
            platforms.save(newPlatform);
            return ResponseEntity.ok(platform);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
