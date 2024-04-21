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

import lombok.AllArgsConstructor;

import org.sd.cinematch.entity.Platform;
import org.sd.cinematch.service.PlatformService;

@RestController
@AllArgsConstructor
@RequestMapping("/platform")
public class PlatformRestController {

    private final PlatformService platforms;

    @GetMapping("/")
    public Collection<Platform> getPlatform() {
        return platforms.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platform> getPlatform(@PathVariable final long id) {
        Platform platform = platforms.findById(id);
        if (platform != null) {
            return ResponseEntity.ok(platform);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Platform> createPlatform(@RequestBody final Platform platform) {
        platforms.save(platform);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(platform.getId())
                .toUri();
        return ResponseEntity.created(location).body(platform);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Platform> deletePlatform(@PathVariable final long id) {
        Platform platform = platforms.findById(id);
        if (platform != null) {
            platforms.deleteById(id);
            return ResponseEntity.ok(platform);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Platform> replacePlatform(@PathVariable final long id,
            @RequestBody final Platform newPlatform) {
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